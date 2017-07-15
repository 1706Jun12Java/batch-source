package com.bank.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtil {

	private static Connection con = null;

	  public static Connection getConnectionFromFile() {
	          try {
	              InputStream inputStream = ConnectionUtil.class.getClassLoader()
	                      .getResourceAsStream("connection.properties");
	              Properties properties = new Properties();
	              if (properties != null) {
	                  properties.load(inputStream);

	                  String driver = properties.getProperty("driver");
	                  String url = properties
	                          .getProperty("url");
	                  String username = properties.getProperty("username");
	                  String password = properties.getProperty("password");

	                  Class.forName(driver).newInstance();
	                  con = DriverManager.getConnection(url,
	                          username, password);
	              }
	          } catch (Exception e) {
	              e.printStackTrace();
	          }
	          return con;
	      }
}
