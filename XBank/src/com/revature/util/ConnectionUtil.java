package com.revature.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import oracle.jdbc.driver.OracleDriver;

public class ConnectionUtil {
	public static Connection con = null;
	
	public static Connection getConnectionFromFile() throws IOException, SQLException{
		File dir = new File(".");
		File[] filesList = dir.listFiles();
		for (File file : filesList) {
		    if (file.isFile()) {
		        System.out.println(file.getName());
		    }
		}

		
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		
		if(con!=null){
			return con;
		}else{
			Properties prop = new Properties();
			InputStream in = new FileInputStream("connection.properties");
			prop.load(in);
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			return DriverManager.getConnection(url,username,password);
		}
	}
	
}
