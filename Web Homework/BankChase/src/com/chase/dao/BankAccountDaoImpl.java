package com.chase.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chase.domain.BankAccount;
import com.chase.exceptions.IncorrectAccountException;
import com.chase.exceptions.OverDraftException;
import com.chase.util.ConnectionUtil;

public class BankAccountDaoImpl implements BankAccountDao {

	public static void withdraw(int userId, int accountNum, int amount)
			throws IncorrectAccountException, OverDraftException {
		CallableStatement cs;
		PreparedStatement ps;

		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql1 = "SELECT * FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID = ? AND USER_ID = ?";
			ps = con.prepareStatement(sql1);
			ps.setInt(1, accountNum);
			ps.setInt(2, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				if (rs.getInt("CURRENT_BALANCE") - amount < 0) {
					throw new OverDraftException("Nice Try");
				}
				String sql2 = "{call WITHDRAWL(?,?,?)}";
				cs = con.prepareCall(sql2);
				cs.setInt(1, userId);
				cs.setInt(2, accountNum);
				cs.setInt(3, amount);
				cs.execute();
			} else {
				throw new IncorrectAccountException("Incorrect Account");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("You withdrew $" + amount);
	}

	public static void deposit(int userId, int bankAccountId, int amount) throws IncorrectAccountException {
		CallableStatement cs = null;
		PreparedStatement ps = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql1 = "SELECT * FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID = ? AND USER_ID = ?";
			ps = con.prepareStatement(sql1);
			ps.setInt(1, bankAccountId);
			ps.setInt(2, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String sql = "{call DEPOSIT(?,?,?)}";
				cs = con.prepareCall(sql);
				cs.setInt(1, userId);
				cs.setInt(2, bankAccountId);
				cs.setInt(3, amount);
				cs.executeQuery();
			} else {
				throw new IncorrectAccountException("Incorrect Account");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("You deposited $" + amount);
	}

	public static void createBankAccount(int userId, double amount) {
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "INSERT INTO BANK_ACCOUNT (USER_ID,CURRENT_BALANCE) VALUES(?,?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setDouble(2, amount);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("New account created.");
	}

	public static BankAccount getBankAccountbyId(int u_id, int b_id) throws IncorrectAccountException {
		PreparedStatement ps = null;
		BankAccount ba = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT * FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID = ? AND USER_ID = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, b_id);
			ps.setInt(2, u_id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int baid = rs.getInt("BANK_ACCOUNT_ID");
				double currentBalance = rs.getDouble("CURRENT_BALANCE");
				ba = new BankAccount(baid, currentBalance);
			} else {
				throw new IncorrectAccountException("Incorrect Account");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ba;
	}

}
