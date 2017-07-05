package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException{
		String url="jdbc:oracle:thin:@javademo.c1eldqv7hqgd.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username="Admin";
		String password="password1q";
		return DriverManager.getConnection(url,username,password);
	}
	public static Connection getConnectionFromFile(String filename)
			throws IOException, SQLException{
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url=prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}
}
