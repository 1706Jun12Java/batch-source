package com.revature.leibniz.bank.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateUtil {
	
	public static void updateAccountBalance(int accountID, double newBalance) {
		try {
			// Connect database
			Connection con = ConnectionUtil.getConnection();
			
			System.out.println("New balance = " + newBalance);
			
			// Query
			String query = "UPDATE ACCOUNT_TABLE SET BALANCE = ? WHERE ACCOUNT_ID = ?";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setDouble(1, newBalance);
			preparedStatement.setInt(2, accountID);
			
			System.out.println("Updating balance...");
			// Update Query
			preparedStatement.executeUpdate();		
			System.out.println("Balance updated.");
			
			// close connection
			con.close();
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
}
