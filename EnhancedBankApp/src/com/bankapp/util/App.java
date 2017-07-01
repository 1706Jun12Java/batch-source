package com.bankapp.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.driver.OracleDriver;


@SuppressWarnings("unused")
public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}

	
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
	
	public static Connection getConnectionFromFile(String filename) throws IOException, SQLException{
		
		Properties prop = new Properties(); 
		InputStream in = new FileInputStream(filename);
		prop.load(in); // loading all key input values in that file
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url,username,password);
	}

}
