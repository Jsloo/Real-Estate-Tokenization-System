package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OwnerController {
	public static String port = Config.mysql_port;
	public static String myUser = Config.myUser;
	public static String myPassword = Config.myPassword;
	public static Integer userId = 1;
	 
	private Connection establishConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/rs_token", myUser, myPassword);
    }
	
	public String login(String username,String password) {
		try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/rs_token", "root", "");
            
            Statement t = (Statement) conn.createStatement();

            String script = "SELECT * from PROJECTOWNER where Name = '" + username + "' and PASSWORD = '" + password + "'";

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
	
	public void logOut() {
		userId = 0;
	}
	
	public List<String[]> showMyRs() {
        List<String[]> resultList = new ArrayList<>();

        try (Connection connection = establishConnection()) {
            // Assuming "realstate" is your table name
            String query = "SELECT * FROM realestate WHERE POwner_ID = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        // Assuming you have three columns: col1, col2, col3
                    	int id = resultSet.getInt("ID");
                    	String tokenName = resultSet.getString("Token_Name");
                        String state = resultSet.getString("State");
                        String city = resultSet.getString("City");
                        int zipCode = resultSet.getInt("ZipCode");
                        String address = resultSet.getString("Address");
                        int tokenAmount = resultSet.getInt("TokenAmount");
                        Double price = resultSet.getDouble("Price");
                        String image = resultSet.getString("Image");

                        // Add the retrieved data to the result list
                        String[] resultRow = {
                        		String.valueOf(id), tokenName, state, 
                        		city, String.valueOf(zipCode), address, 
                        		String.valueOf(tokenAmount), String.valueOf(price), image
                        		};
                        resultList.add(resultRow);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }

        return resultList;
    }
	
	public String publishToken(String image,String tokenName, String state, String city, int zipCode,
		String address, int tokenAmount, double price) {
		try (Connection connection = establishConnection()) {

			if (!isTokenNameUnique(connection, tokenName)) {
				return "exists";
			}
			
			String query = "INSERT INTO RealEstate (Token_Name, State, City, ZipCode, Address, TokenAmount, Price, Image, POwner_ID) " +
			        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, tokenName);
				preparedStatement.setString(2, state);
				preparedStatement.setString(3, city);
				preparedStatement.setInt(4, zipCode);
				preparedStatement.setString(5, address);
				preparedStatement.setInt(6, tokenAmount);
				preparedStatement.setDouble(7, price);
				preparedStatement.setString(8, image);
				preparedStatement.setInt(9, userId);
			
				int rowsAffected = preparedStatement.executeUpdate();
			
				if (rowsAffected > 0) {
					return "success";
				} else {
					return "fail";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error: " + e.getMessage();
		}
	}
		
	private boolean isTokenNameUnique(Connection connection, String tokenName) throws SQLException {
		String query = "SELECT COUNT(*) FROM RealEstate WHERE Token_Name = ?";
		
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, tokenName);
			
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					 int count = resultSet.getInt(1);
					 return count == 0;
				}
			}
		}
		
		return false;
	}

}
