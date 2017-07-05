package com.revature.bank.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private static Connection conn=null;
	
	public static Connection getConnectionFromFile() throws IOException, SQLException{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Properties prop = new Properties();
			InputStream in = ConnectionUtil.class.getResourceAsStream("connection.properties");
			prop.load(in);
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			conn =  DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
			return conn;
	}
}
