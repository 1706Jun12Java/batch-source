package com.jdbcbank.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.DriverManager;
import java.io.*;

public class ConnectionUtil {

	public ConnectionUtil() {
		// TODO Auto-generated constructor stub
	}
	
	public static Connection getConnection(String connectionAuthFile) throws IOException, SQLException{
		Properties prop = new Properties();
		InputStream in = new FileInputStream(connectionAuthFile);
		prop.load(in);
		
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		return DriverManager.getConnection(url, username, password); 
	}
}
