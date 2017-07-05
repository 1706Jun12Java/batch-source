package Util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ConnectionUtil {

	/**
	 * Returns a connection to the database
	 * 
	 * @return The connection to the database
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		String url = "", username = "", password = "";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// Retrieve the url, username, and password from a properties file
			Properties prop = new Properties();
			InputStream in;
			in = new FileInputStream(
					"/Users/Soul/Documents/workspace-sts-3.8.4.RELEASE/JDBCBankProject/src/connection.properties");
			prop.load(in);
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
