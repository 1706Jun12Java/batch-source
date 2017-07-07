package com.jdbcbank.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionUtil {

	public ConnectionUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection(String connectionAuthFile) throws IOException, SQLException{
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
//		
//		Properties prop = new Properties();
//		InputStream in = new FileInputStream(connectionAuthFile);
//		prop.load(in);
//		
//		String url = prop.getProperty("url");
//		String username = prop.getProperty("username");
//		String password = prop.getProperty("password"); 
		//System.out.println(url);
		//System.out.println(DriverManager.getConnection(url, username, password));
		return DriverManager
                .getConnection("jdbc:mysql://localhost/JDBCbank?"
                        + "user=root");
				//DriverManager.getConnection(url, username, password); 
	}
}
