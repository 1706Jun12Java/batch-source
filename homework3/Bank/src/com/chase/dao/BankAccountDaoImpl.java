package com.chase.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chase.domain.BankAccount;
import com.chase.util.ConnectionUtil;

public class BankAccountDaoImpl implements BankAccountDao {

	@Override
	public BankAccount getBankAccountbyId(int id) {
		PreparedStatement pstmt = null;
		BankAccount ba = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			String sql = "SELECT * FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				double currentBalance = rs.getDouble("CURRENT_BALANCE");
				ba = new BankAccount(id, currentBalance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return ba;
	}
}
