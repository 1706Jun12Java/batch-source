package com.revature.Util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	private static Connection con = null;
	public static Connection getConnectionFromFile(String filename){
		Properties prop = new Properties();	
		try{
			if(con == null){
			InputStream is = new FileInputStream(filename);
			prop.load(is);
			String url = prop.getProperty("url");
			String userName  = prop.getProperty("userName");
			String password = prop.getProperty("password");
			 Class.forName ("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url,userName,password);	
			return con;
			} else {
				return con;
			}			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public static void closeConnection(){
		if(con!=null){
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
