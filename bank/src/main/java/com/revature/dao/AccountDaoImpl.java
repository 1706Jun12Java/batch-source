package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.revature.domain.Account;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao {

	@Override
	public List<Account> getAccount() {
		List<Account> al = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile("connections.properties")) {
			String sql = "SELECT * FROM ACCOUNT";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("Account_ID");
				int balance = rs.getInt("BALANCE");
				al.add(new Account(id, balance));
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

	@Override
	public Account getAccountById(int id) {
		PreparedStatement pstmt;
		Account account = null;

		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			String sql = "SELECT * FROM ACCOUT WHERE ACCOUNT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int balance = rs.getInt("BALANCE");
				int user_id = rs.getInt("USER_ID");
				account = new Account(user_id,balance);
			}

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	@Override
	public int createAccount(Account account) {
		// TODO Auto-generated method stub
		return 0;
	}
}