package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import oracle.jdbc.driver.OracleDriver;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException{
		String url="jdbc:oracle:thin:@javademo.c1eldqv7hqgd.us-east-2.rds.amazonaws.com:1521:ORCL";
		String username="Admin";
		String password="password1q";
		return DriverManager.getConnection(url,username,password);
	}
	public static Connection getConnectionFromFile(String filename)
			throws IOException, SQLException{
		
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		//InputStream in = ConnectionUtil.class.getResourceAsStream(filename);
		prop.load(in);
		String url=prop.getProperty("url");
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}
}
