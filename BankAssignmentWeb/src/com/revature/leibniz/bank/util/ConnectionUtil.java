package com.revature.leibniz.bank.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * @author Leibniz Berihuete
 * Constains only one method:
 * getConnection
 */
public class ConnectionUtil {
	// DEFAULT CONSTRUCTOR
	public ConnectionUtil() {}
	
	
	public static Connection getConnection() throws IOException, SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		
		// ADD THIS:
		InputStream in = ConnectionUtil.class.getResourceAsStream("Connection.properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("user");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}	
}


