package Controller;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OwnerController {
	public static String port = Config.mysql_port;
	public static Integer userId = 0;
	
	public String login(String username,String password) {
		try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/rs_token", "root", "root");
            
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
	
	public ArrayList<String[]> showToken() throws RemoteException {
	    try {
	        ArrayList<String[]> TokenList = new ArrayList<>();
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + port + "/rs_token", "root", "root");
	        Statement stmt = (Statement) conn.createStatement();
	        String sql = "SELECT Token_Name, TokenAmount from RealEstate where POwner_ID = 1";
//	        String sql1 = "SELECT Token_Name, TokenAmount from RealEstate where ID = " + userId + "";
	        ResultSet rs = stmt.executeQuery(sql);
	        
	        while (rs.next()) {
	            String name = rs.getString("Token_Name");
	            String quantity = rs.getString("TokenAmount");
	           
	            String[] TokenData = {name, String.valueOf(quantity)};
	            TokenList.add(TokenData);
	        }
	        return TokenList;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
	
}
