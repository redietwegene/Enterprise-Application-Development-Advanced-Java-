package questionBank;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconn {

	public static void main(String[] args) {
		
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/questionbank";
			String username = "root"; 
			String password = "root"; 
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,
					username, password);
			System.out.println("connected successfully");
			
			
		// TODO Auto-generated method stub

	}catch(Exception e){
		e.printStackTrace();
	}
		
	}

	

}
