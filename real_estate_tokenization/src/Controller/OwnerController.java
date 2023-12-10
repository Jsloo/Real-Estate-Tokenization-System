package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OwnerController {
	public static String port = Config.mysql_port;
	public static Integer userId = 0;
	
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
}
