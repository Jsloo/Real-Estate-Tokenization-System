package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class InvestorController {
	Config n = new Config();
	public static String port = Config.mysql_port;
	public String login(String username,String password) {
		try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + port+ "/rs_token", "root", "");
            
            Statement t = (Statement) conn.createStatement();

            String script = "SELECT * from INVESTOR where Name = '" + username + "' and PASSWORD = '" + password + "'";

            ResultSet rs = ((java.sql.Statement) t).executeQuery(script);

            if(rs.next()){
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
			
	        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + port+ "/rs_token", "root", "");
	        
	        try (Statement statement = conn.createStatement()) {
	            String checkExist = "SELECT NAME FROM  " + thisRole + "  WHERE NAME = '" + username + "'";
	            ResultSet resultSet = statement.executeQuery(checkExist);
	            if (resultSet.next()) {
	                return "exists";
	            }
	        } 

	        try (Statement statement = conn.createStatement()) {
	            String script = "INSERT INTO " + thisRole + " (NAME, PASSWORD) " +
	                            "VALUES ('" + username + "', '" + password + "')";
	            statement.executeUpdate(script);
	            return "success";
	        } 
		}catch(Exception e) {
			return e.toString();
		}
		
	}
}
