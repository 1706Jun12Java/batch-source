package com.revature.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import oracle.jdbc.OracleDriver;

public class ConnectionUtil {

	public static Connection getConnectionFromFile(String filename){
		Properties prop = new Properties();	
		try{
			InputStream is = new FileInputStream(filename);
			prop.load(is);
			String url = prop.getProperty("url");
			String userName  = prop.getProperty("userName");
			String password = prop.getProperty("password");
			 Class.forName ("oracle.jdbc.OracleDriver");
			return DriverManager.getConnection(url,userName,password);	
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
}
