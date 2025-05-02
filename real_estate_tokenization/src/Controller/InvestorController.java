package Controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import DigitalSignature.MySignature;
import PairKey.MyKeyPair;
import SecretKey.Random;
import SecretKey.Symmetric;
import BlockChain.Block;
import BlockChain.Transaction;
import BlockChain.BlockChain;


public class InvestorController {
	
	public static String port = Config.mysql_port;
	public static String myUser = Config.myUser;
	public static String myPassword = Config.myPassword;
	public static Integer userId = 15;
	 
	private Connection establishConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/rs_token", myUser, myPassword);
    }
	
	public String login(String username,String password) {
		try{
            Connection conn = establishConnection();
            
            Statement t = (Statement) conn.createStatement();

            String script = "SELECT * from INVESTOR where Name = '" + username + "' and PASSWORD = '" + password + "'";

            ResultSet rs = ((java.sql.Statement) t).executeQuery(script);

            if(rs.next()){
            	userId = rs.getInt("ID");
            	return "Success";
            	
            }else{
            	return "Error";
            }
        }catch(Exception e){
        	return e.toString();
        } 
	}
	
	public String register(boolean role, String username, String password) {
		try {
			String thisRole;
			if (role == true) {
				thisRole = "INVESTOR";
			}else {
				thisRole = "PROJECTOWNER";
			}
			
			Connection conn = establishConnection();
	        
	        try (Statement statement = conn.createStatement()) {
	            String checkExist = "SELECT NAME FROM  " + thisRole + "  WHERE NAME = '" + username + "'";
	            ResultSet resultSet = statement.executeQuery(checkExist);
	            if (resultSet.next()) {
	                return "exists";
	            }
	        } 

	        try (Statement statement = conn.createStatement()) {
	        	Random key = new Random();
	        	String secretKeyString = Base64.getEncoder().encodeToString(key.create().getEncoded());
	        	
	            String script = "INSERT INTO " + thisRole + " (NAME, PASSWORD, SECRET_KEY) " +
	                            "VALUES ('" + username + "', '" + password + "', '" + secretKeyString + "')";
	            statement.executeUpdate(script, Statement.RETURN_GENERATED_KEYS);
	            

	            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    int generatedId = generatedKeys.getInt(1);
	                    new MyKeyPair();
	                    MyKeyPair.genKeyPair(Integer.toString(generatedId), thisRole);
	                }
	            }
	            return "success";
	        } 
		}catch(Exception e) {
			return e.toString();
		}
		
	}
	
	public void logOut() {
		userId = 0;
	}
	
	public List<String[]> showMarket() {
        List<String[]> realEstateList = new ArrayList<>();

        try {
        	Connection conn = establishConnection();
            Statement statement = conn.createStatement();

            String script = "SELECT * FROM RealEstate";
            ResultSet resultSet = statement.executeQuery(script);

            while (resultSet.next()) {
            	String[] realEstateData = new String[10];
                realEstateData[0] = resultSet.getString("ID");
                realEstateData[1] = resultSet.getString("Token_Name");
                realEstateData[2] = resultSet.getString("State");
                realEstateData[3] = resultSet.getString("City");
                realEstateData[4] = resultSet.getString("ZipCode");
                realEstateData[5] = resultSet.getString("Address");
                realEstateData[6] = resultSet.getString("TokenAmount");
                realEstateData[7] = resultSet.getString("Price");
                realEstateData[8] = resultSet.getString("POwner_ID");
                realEstateData[9] = resultSet.getString("Image");

                realEstateList.add(realEstateData);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return realEstateList;
    }
	
	public String buyToken(Integer rsId, Integer qty) throws Exception {
        try {
        	Connection connection = establishConnection();
        	Integer ownerId = getRealEstateOwner(connection,rsId);
            
            if (!digitalSignature(ownerId,rsId,qty,"primary")) {
                return "invalidSignature";
            }
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            int availableTokens = getAvailableTokens(connection, rsId);
            if (availableTokens < qty) {
                return "less";
            }

            updateTokenAmount(connection, rsId, qty);

            insertTransaction(connection, getRealEstateOwner(connection, rsId),userId, rsId, qty,"primary");

            if(tokenExists(connection,rsId)) {
            	updateTokenWallet(connection, rsId, qty,"+");
            }else {
            	insertTokenWallet(connection, rsId, qty);
            }
            
            blockChain(Integer.toString(getRealEstateOwner(connection, rsId))+"|"+Integer.toString(userId)+"|"+Integer.toString(rsId)+"|"+Integer.toString(qty)+"|primary");
            connection.close();

            return "success";
        } catch (ClassNotFoundException | SQLException e) {
            return e.toString();
        }
    }
	
	public boolean digitalSignature(Integer id, Integer rsId, Integer qty,String market) {
		String role;
		Boolean sign = false;
		if(market.equals("primary")) {
			role = "PROJECTOWNER";
		}else {
			role = "INVESTOR";
		}
		
		try {
			PublicKey pubKey = getPublicKey("KeyPair/"+ role +"/"+ Integer.toString(id) + "/PublicKey");
			PrivateKey privKey = getPrivateKey("KeyPair/"+ role +"/"+ Integer.toString(id) + "/PrivateKey");
			MySignature signatureUtil = new MySignature();
	        String transactionMessage = "BuyToken-" + userId + "-" + rsId + "-" + qty;
	        
	        byte[] digitalSignature = signatureUtil.getSignature(transactionMessage, privKey);

	        boolean isSignatureValid = signatureUtil.isTextAndSignatureValid(transactionMessage, digitalSignature, pubKey);
	        sign = isSignatureValid;
		} catch (Exception e) {
			sign = false;
			e.printStackTrace();
		}
		
        
		return sign;
	}

	public static PublicKey getPublicKey(String path) throws Exception{
		byte[] keyBytes = Files.readAllBytes(Paths.get(path));
		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		return KeyFactory.getInstance("RSA").generatePublic(spec);
	}
	
	public static PrivateKey getPrivateKey(String path) throws Exception{
		byte[] keyBytes = Files.readAllBytes(Paths.get(path));
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		return KeyFactory.getInstance("RSA").generatePrivate(spec);
	}
	
	private boolean tokenExists(Connection connection, Integer rsId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM TokenWallet WHERE Investor_ID = ? AND RealEstate_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setInt(2, rsId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }
	
    private int getAvailableTokens(Connection connection, Integer rsId) throws SQLException {
        String sql = "SELECT TokenAmount FROM RealEstate WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, rsId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("TokenAmount");
                }
            }
        }
        return 0;
    }

    private void updateTokenAmount(Connection connection, Integer rsId, Integer qty) throws SQLException {
    	String sql = "UPDATE RealEstate SET TokenAmount = TokenAmount - ? WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, qty);
            statement.setInt(2, rsId);
            statement.executeUpdate();
        }
    }

    private void insertTransaction(Connection connection,Integer from, Integer to, Integer rsId, Integer qty,String market) throws SQLException {
    	String from_encrypted =null;
    	String to_encrypted =null;
    	Key fromkey = getSecretKey(market.equals("primary") ? "powner" : "investor",from);
    	Key tokey = getSecretKey("investor",to);
    	try {
			Symmetric en = new Symmetric();
			from_encrypted = en.encrypt(Integer.toString(from)+"|"+Integer.toString(to)+"|"+Integer.toString(rsId)+"|"+Integer.toString(qty)+"|primary", fromkey);
			to_encrypted = en.encrypt(Integer.toString(from)+"|"+Integer.toString(to)+"|"+Integer.toString(rsId)+"|"+Integer.toString(qty)+"|primary", tokey);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
        String sql = "INSERT INTO Transaction (FromInvestor_ID, ToInvestor_ID, RealEstate_ID, Amount, Market, from_encrypted, to_encrypted) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, from);
            statement.setInt(2, to);
            statement.setInt(3, rsId);
            statement.setInt(4, qty);
            statement.setString(5, market);
            statement.setString(6, from_encrypted);
            statement.setString(7, to_encrypted);
            statement.executeUpdate();
        }
    }
    
    private void insertTokenWallet(Connection connection, Integer rsId, Integer qty) throws SQLException {
    	String sql = "INSERT INTO TokenWallet (Investor_ID, RealEstate_ID, Amount) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setInt(2, rsId);
            statement.setInt(3, qty);
            statement.executeUpdate();
        }
    }

    private int getRealEstateOwner(Connection connection, Integer rsId) throws SQLException {
        String sql = "SELECT POwner_ID FROM RealEstate WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, rsId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("POwner_ID");
                }
            }
        }
        return 0;
    }
    
    public List<String[]> showSecondMarket() {

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection connection = establishConnection();

            // SQL query to get data from the Sale table and join with RealEstate table
            String sql = "SELECT Sale.ID, Sale.Investor_ID, Sale.Amount, Sale.Price, "
                    + "RealEstate.Token_Name, RealEstate.State, RealEstate.City, RealEstate.ZipCode, RealEstate.Address, RealEstate.Image "
                    + "FROM Sale "
                    + "JOIN RealEstate ON Sale.RealEstate_ID = RealEstate.ID";

            // Execute the query
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                List<String[]> result = new ArrayList<>();

                // Iterate through the result set and store data in an Object array
                while (resultSet.next()) {
                	String[] data = new String[10];
                    data[0] = resultSet.getString("ID");
                    data[1] = resultSet.getString("Investor_ID");
                    data[2] = resultSet.getString("Amount");
                    data[3] = resultSet.getString("Price");
                    data[4] = resultSet.getString("Token_Name");
                    data[5] = resultSet.getString("State");
                    data[6] = resultSet.getString("City");
                    data[7] = resultSet.getString("ZipCode");
                    data[8] = resultSet.getString("Address");
                    data[9] = resultSet.getString("Image");
                    result.add(data);
                }

                // Close resources
                connection.close();

                return result;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String buySecond(Integer saleId, Integer qty) throws Exception {
        Connection connection = null;
        PreparedStatement updateSaleStatement = null;
        PreparedStatement insertTransactionStatement = null;
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Establish a connection
            connection = establishConnection();
            Integer rsId = Integer.parseInt(getSale(connection,saleId)[2]);
            Integer sellerId = Integer.parseInt(getSale(connection,saleId)[1]);
            // Start a transaction
            connection.setAutoCommit(false);
            if (digitalSignature(sellerId,rsId,qty,"second") == false) {
                return "invalidSignature";
            }
            // Update Sale table by decreasing the amount
            String updateSaleQuery = "UPDATE Sale SET Amount = Amount - ? WHERE ID = ?";
            updateSaleStatement = connection.prepareStatement(updateSaleQuery);
            updateSaleStatement.setInt(1, qty);
            updateSaleStatement.setInt(2, saleId);
            updateSaleStatement.executeUpdate();

            insertTransaction(connection, sellerId,userId, rsId, qty,"second");

            if(tokenExists(connection,rsId)) {
            	updateTokenWallet(connection, rsId, qty,"+");
            }else {
            	insertTokenWallet(connection, rsId, qty);
            }

            blockChain(Integer.toString(getRealEstateOwner(connection, rsId))+"|"+Integer.toString(userId)+"|"+Integer.toString(rsId)+"|"+Integer.toString(qty)+"|second");
            connection.commit();

            return "success";
        } catch (SQLException e) {
            // Handle exceptions and rollback the transaction in case of an error
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException rollbackException) {
                    rollbackException.printStackTrace();  // Handle rollback exception
                }
            }
            e.printStackTrace();  // Handle the exception or log it
            return "Error during purchase";
        } finally {
            // Close JDBC resources in the finally block
            if (updateSaleStatement != null) {
                updateSaleStatement.close();
            }
            if (insertTransactionStatement != null) {
                insertTransactionStatement.close();
            }
            if (connection != null) {
                connection.setAutoCommit(true);  // Reset auto-commit to true
                connection.close();
            }
        }
    }
    

	public String[] getSale(Connection connection, Integer saleId) throws SQLException {
        String sql = "SELECT * FROM Sale WHERE ID = ?";
        String[] saleData = null;
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, saleId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                	int investorId = resultSet.getInt("Investor_ID");
                    int realEstateId = resultSet.getInt("RealEstate_ID");
                    int amount = resultSet.getInt("Amount");
                    double price = resultSet.getDouble("Price");

                    // Create a String array to hold the sale data
                    saleData = new String[]{String.valueOf(saleId), String.valueOf(investorId),
                                            String.valueOf(realEstateId), String.valueOf(amount),
                                            String.valueOf(price)};
                }
            }
        }
        return saleData;
    }
	
	public List<String[]> showMyToken() {
		List<String[]> result = new ArrayList<>();

        String sql = "SELECT TokenWallet.Amount, TokenWallet.ID, TokenWallet.Investor_ID, TokenWallet.RealEstate_ID, " +
                     "RealEstate.Token_Name, RealEstate.State, RealEstate.City," +
                     "RealEstate.ZipCode, RealEstate.Address, RealEstate.Image " +
                     "FROM TokenWallet " +
                     "JOIN RealEstate ON TokenWallet.RealEstate_ID = RealEstate.ID " +
                     "WHERE TokenWallet.Investor_ID = ?";

        try (Connection conn = establishConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, userId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int amount = resultSet.getInt("Amount");
                    int tokenWalletId = resultSet.getInt("ID");
                    int rsId = resultSet.getInt("RealEstate_ID");
                    int walletInvestorId = resultSet.getInt("Investor_ID");
                    String tokenName = resultSet.getString("Token_Name");
                    String state = resultSet.getString("State");
                    String city = resultSet.getString("City");
                    int zipCode = resultSet.getInt("ZipCode");
                    String address = resultSet.getString("Address");
                    String image = resultSet.getString("Image");

                    // Create a String array to store the data
                    String[] data = {
                            String.valueOf(amount),
                            String.valueOf(tokenWalletId),
                            String.valueOf(walletInvestorId),
                            tokenName,
                            state,
                            city,
                            String.valueOf(zipCode),
                            address,
                            String.valueOf(rsId),
                            image
                    };
                    // Add the array to the result list
                    result.add(data);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
        return result;
    }
    
	public String sellSecond(Integer rsId, Integer qty, Double price) {
        Connection connection = null;
        try {
            // Establish a database connection (Replace with your actual connection code)
        	connection = establishConnection();

            // Check if the sale already exists for the user and real estate
            if (saleExists(connection, userId, rsId)) {
                // Update the existing sale
                updateExistingSale(connection, userId, rsId, qty, price);
            } else {
                // Insert a new sale
                insertNewSale(connection, userId, rsId, qty, price);
            }

            // Update the TokenWallet table
            updateTokenWallet(connection, rsId, qty,"-");

            return "success";
        } catch (SQLException e) {
            return "Error: " + e.getMessage();
        } finally {
            // Close the connection (Replace with your actual closing code)
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean saleExists(Connection connection, Integer userId, Integer rsId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM SALE WHERE Investor_ID = ? AND RealEstate_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setInt(2, rsId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

    private void updateExistingSale(Connection connection, Integer userId, Integer rsId, Integer qty, Double price) throws SQLException {
        String sql = "UPDATE SALE SET Amount = Amount + ?, Price = ? WHERE Investor_ID = ? AND RealEstate_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, qty);
            statement.setDouble(2, price);
            statement.setInt(3, userId);
            statement.setInt(4, rsId);
            statement.executeUpdate();
        }
    }

    private void insertNewSale(Connection connection, Integer userId, Integer rsId, Integer qty, Double price) throws SQLException {
        String sql = "INSERT INTO SALE (Investor_ID, RealEstate_ID, Amount, Price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setInt(2, rsId);
            statement.setInt(3, qty);
            statement.setDouble(4, price);
            statement.executeUpdate();
        }
    }

    private void updateTokenWallet(Connection connection, Integer rsId, Integer qty,String mop) throws SQLException {
    	String sql = "UPDATE TokenWallet SET Amount = Amount "+ mop +" ? WHERE Investor_ID = ? AND RealEstate_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, qty);
            statement.setInt(2, userId);
            statement.setInt(3, rsId);
            statement.executeUpdate();
        }
    }
    
    private static String masterFolder = "master";
	private static String fileName = masterFolder + "/chain.bin";
	
	public void blockChain(String transaction) {
		BlockChain bc = BlockChain.getInstance(fileName);
		String line1 = transaction;
		Transaction tranxLst = new Transaction();
		if(!new File(masterFolder).exists()) {
			System.err.println("> creating Blockchain binary!");
			new File(masterFolder).mkdir();
			bc.genesis();

		}
		tranxLst.add(line1);
		tranxLst.setMerkleRoot();
		String previousHash = bc.get().getLast().getHeader().getCurrentHash();
		Integer index = bc.get().getLast().getHeader().getIndex();
		Block b1 = new Block(previousHash,index);
		b1.setTransactions(tranxLst);
		bc.nextBlock(b1);
		System.out.println(b1);
		bc.distribute();
	}
	
	
	private boolean canDecrypt(String encryptedData, Key key) {
        try {
            Symmetric symmetric = new Symmetric();
            symmetric.decrypt(encryptedData, key);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<String[]> showTransactionHistory(String type) {
        List<String[]> transactionHistory = new ArrayList<>();
        String fromName;
        String toName;
        String rsName;
        OwnerController o = new OwnerController();
        Integer userId = type.equals("investor") ? this.userId : o.userId;
        
        try (Connection connection = establishConnection()) {
            String query = "SELECT FromInvestor_ID, ToInvestor_ID, RealEstate_ID, Amount, Market, From_encrypted, To_encrypted "
                    + "FROM Transaction "
                    + "WHERE FromInvestor_ID = ? OR ToInvestor_ID = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.setInt(2, userId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int fromId = resultSet.getInt("FromInvestor_ID");
                        int toId = resultSet.getInt("ToInvestor_ID");
                        int realEstateId = resultSet.getInt("RealEstate_ID");
                        int amount = resultSet.getInt("Amount");
                        String market = resultSet.getString("Market");
                        String fromEncrypted = resultSet.getString("From_encrypted");
                        String toEncrypted = resultSet.getString("To_encrypted");

                        
                        if ("second".equals(market)) {
                            fromName = getUserName(fromId,"investor");
                        } else {
                        	fromName = getUserName(fromId,"powner");
                        }
                        
                        toName = getUserName(toId,"investor");
                        rsName = getRealEstateName(realEstateId);
                        
                        Key SecretKey;
                        SecretKey = getSecretKey(type,userId);
                        
                        if (canDecrypt(fromEncrypted, SecretKey) || canDecrypt(toEncrypted, SecretKey)) {
                            String[] transactionEntry = {
                            		fromName,
                                    toName,
                                    rsName,
                                    String.valueOf(amount),
                                    market
                            };
                            
                            transactionHistory.add(transactionEntry);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return transactionHistory;
    }

    private Key getSecretKey(String type, int userId) {
    	Random key = new Random();
        try (Connection connection = establishConnection()) {
            String tableName = "investor".equals(type) ? "Investor" : "ProjectOwner";
            String query = "SELECT Secret_Key FROM " + tableName + " WHERE ID = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String secretKeyString = resultSet.getString("Secret_Key");
                        
                        Key sKey = key.decode(secretKeyString);
                        return sKey;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private String getUserName(int Id, String type) {
        try (Connection connection = establishConnection()) {
            String tableName = "investor".equals(type) ? "Investor" : "ProjectOwner";

            String query = "SELECT Name FROM " + tableName + " WHERE ID = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, Id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("Name");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; 
    }

    private String getRealEstateName(int realEstateId) {
    	try (Connection connection = establishConnection()) {
            String query = "SELECT Token_Name FROM REALESTATE WHERE ID = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, realEstateId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return resultSet.getString("Token_Name");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null; 
    }
}
