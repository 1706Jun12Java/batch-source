package com.ers.util;

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
	
	public static Connection getConnectionFromFile(String file) throws IOException, SQLException{
		
		Connection con = null; 
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        Properties prop = new Properties();
	        InputStream in = ConnectionUtil.class.getResourceAsStream(file);
	        prop.load(in);
	        String url = prop.getProperty("url");
	        String username = prop.getProperty("username");
	        String password = prop.getProperty("password");
	        con =  DriverManager.getConnection(url,username,password);

			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(con == null){
			System.out.println("Connection is null");
		}
		return con;

		
	}


}


