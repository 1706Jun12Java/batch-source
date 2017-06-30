package com.revature.leibniz.bank.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.leibniz.bank.domain.Account;
import com.revature.leibniz.bank.util.ConnectionUtil;
/**
 * 
 * @author Leibniz Berihuete
 * AccountImpDao
 */
public class AccountImpDao implements AccountDao{

	@Override
	public List<Account> getAccounts() {
		ArrayList<Account> accounts = new ArrayList<>();
		
		try { 
			// Connect to database
			Connection con = ConnectionUtil.getConnection();
			
			// Query
			Statement statement = con.createStatement();			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM ACCOUNT_TABLE");
			
			// Iterate through resultSet
			while(resultSet.next()) {
				// Obtain each account
				int accountID = resultSet.getInt("ACCOUNT_ID");
				double balance = resultSet.getDouble("BALANCE");
				int userID = resultSet.getInt("USER_ID");
				
				Account account = new Account(accountID, balance, userID);
				accounts.add(account);
				con.close();
			}
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public Account getAccountByID(int id) {
		Account account = null;
		try {
			
			// Connect to database
			Connection con = ConnectionUtil.getConnection();
			
			// Query
			String query = "SELECT * FROM ACCOUNT_TABLE WHERE ACCOUNT_ID = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, id);
			
			// Get resultSet
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int accountID = resultSet.getInt("ACCOUNT_ID");
				double balance = resultSet.getDouble("BALANCE");
				int userID = resultSet.getInt("USER_ID");
			
				account = new Account(accountID, balance, userID);
			}
			
			con.close();
			
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public int createAccount(Account account) {
		try {
			
			// Connect Database
			Connection con = ConnectionUtil.getConnection();
			
			// Get account info
			int accountID = account.getAccountID();
			double balance = account.getBalance();
			int userID = account.getUserID();
			
			// SubQuery
			String subQuery = "(SELECT USER_ID FROM USER_TABLE WHERE USER_ID = ?)";
			
			// Query
			String query = "INSERT INTO ACCOUNT_TABLE VALUES(?, ?, " + subQuery + ")";			
			PreparedStatement statement = con.prepareStatement(query);
			
			// Put into query:
			statement.setInt(1, accountID);
			statement.setDouble(2, balance);
			statement.setInt(3, userID);
			
			// Update Query
			statement.executeUpdate();
			
			con.close();
		
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			return -1; // return -1 for error
		}
		return 0; // return 0 for success
	}

}
