package Util;

import java.sql.*;

public class ConnectionUtil {

	/**
	 * Returns a connection to the database
	 * 
	 * @return The connection to the database
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:oracle:thin:@jdbcprojectdatabase.ciwxju2fmzjg.us-east-2.rds.amazonaws.com:1521:ORCL",
				user = "Master", password = "password";
		return DriverManager.getConnection(url, user, password);
	}
}
