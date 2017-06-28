package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	//this is egregious. Don't do it like this!!!! 
 	public static Connection getConnection() throws SQLException {
 		String url = "jdbc:oracle:thin:@jun12javademo.cwt1ckcfzdar.us-west-2.rds.amazonaws.com:1521:ORCL";
 		String username = "Admin";
 		String password = "p4ssw0rd";
 		return DriverManager.getConnection(url,username,password);
 	}
	//this is better
	public static Connection getConnectionFromFile(String filename) throws IOException, SQLException{
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}

}
