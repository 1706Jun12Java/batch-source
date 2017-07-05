package com.bankapp.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;




public class App {

	/*
	public static Connection getConnectionFromFile() throws IOException, SQLException{
		
		Properties prop = new Properties(); 
		//InputStream in = new FileInputStream(filename);
		InputStream in = App.class.getResourceAsStream("connection.properties");
		prop.load(in); // loading all key input values in that file
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}
	
	*/
	/*public static Connection getConnectionFromFile(String filename) throws IOException, SQLException{
		
		Properties prop = new Properties();	
		try{
			InputStream is = new FileInputStream(filename);
			prop.load(is);
			String url = prop.getProperty("url");
			String username  = prop.getProperty("username");
			String password = prop.getProperty("password");
			 Class.forName ("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection(url,username,password);	
		}catch(Exception e){
			e.printStackTrace();
		}

	}
	*/
	public static Connection getConnectionFromFile(String file) throws IOException, SQLException{
		
		Connection con = null; 
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
	        Properties prop = new Properties();
	        InputStream in = App.class.getResourceAsStream(file);
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
