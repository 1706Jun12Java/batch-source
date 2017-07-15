package com.revature.leibniz.ers.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * 
 * @author Leibniz Berihuete
 * This class contains a static getConnection method, 
 * which is useful in order to connect to database
 */
public class ConnectionUtil {
	private static final String FILE_NAME = "Connection.properties";
	
	// DEFAULT CONSTRUCTOR
	public ConnectionUtil() {}
	
	// THIS WILL CONNECT TO DATABASE, AND RETURN A CONNECTION OBJECT OF IT.
	public static Connection getConnection() throws SQLException, IOException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// Obtain property file
		InputStream in = ConnectionUtil.class.getResourceAsStream(FILE_NAME);
		
		// Load file into properties instance
		Properties prop = new Properties();
		prop.load(in);
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("user");
		String password = prop.getProperty("password");
		
		// Connect to database...
		Debug.printMessage(ConnectionUtil.class, "getConnection()", "Connecting to database...");
		Connection con = DriverManager.getConnection(url,username, password);
		Debug.printMessage(ConnectionUtil.class, "getConnection()", "Connected to database!");
		return con;
		
	}

}
