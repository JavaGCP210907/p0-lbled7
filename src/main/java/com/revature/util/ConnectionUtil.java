package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	
	public static Connection getConnection() throws SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//change to hide credentials in the environment variables
		String url = System.getenv("URL");
		String username = System.getenv("USERNAME");
		String password = System.getenv("PASSWORD");
		//Run -> Run Configurations -> Environment Variables -> Then create key/value pairs
		
		
		
		return DriverManager.getConnection(url,username,password);
	}
}
