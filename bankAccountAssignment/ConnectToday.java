package com.revature.leibniz.bankAccountAssignment;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 
 * @author Leibniz Berihuete
 * THIS CLASS IS IN CHARGE OF CONNECTING TO THE DATABASE
 */
public class ConnectToday {
	public static Connection getConnection(InputStream filename) throws IOException, SQLException{
		Properties prop = new Properties();
		InputStream in = filename;
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("user");
		String password = prop.getProperty("password");				
		return DriverManager.getConnection(url, username, password);
		
		
		
	}
}
