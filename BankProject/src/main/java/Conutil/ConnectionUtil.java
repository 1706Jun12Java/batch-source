package Conutil;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

public class ConnectionUtil {
	@Test(expected = Exception.class)
	public void testConnect() {
		getConnection();

	}

	/**
	 * Returns a connection to the database
	 * 
	 * @return The connection to the database
	 */
	public static Connection getConnection() {
		String url = "", username = "", password = "";
		try {
			// Retrieve the url, username, and password from a properties file
			Properties prop = new Properties();
			InputStream in;
			in = new FileInputStream(
					"/Users/Soul/Documents/workspace-sts-3.8.4.RELEASE/BankProject/connection.properties");
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
