package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Account;
import Util.ConnectionUtil;

public class AccountImpl implements AccountDAO {

	@Override
	public List<Account> getAccounts(String username) {
		ArrayList<Account> accounts = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ACCOUNTS WHERE USER_NAME = ? ORDER BY ACCOUNT_ID";
			PreparedStatement pdsmt = con.prepareStatement(sql);
			pdsmt.setString(1, username);
			ResultSet rs = pdsmt.executeQuery();
			while (rs.next()) {
				accounts.add(new Account(rs.getInt("ACCOUNT_ID"), rs.getString("USER_NAME"), rs.getDouble("AMOUNT")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public List<Account> getAccounts() {
		ArrayList<Account> accounts = new ArrayList<>();
		try {
			Connection con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ACCOUNTS ORDER BY ACCOUNT_ID";
			PreparedStatement pdsmt = con.prepareStatement(sql);
			ResultSet rs = pdsmt.executeQuery();
			while (rs.next()) {
				accounts.add(new Account(rs.getInt("ACCOUNT_ID"), rs.getString("USER_NAME"), rs.getDouble("AMOUNT")));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public boolean withdraw(int ID, double amount) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "{CALL WITHDRAW_FROM_ACCOUNTS(?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, ID);
			cs.setDouble(2, amount);
			cs.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean deposit(int ID, double amount) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "{CALL DEPOSIT_TO_ACCOUNTS(?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, ID);
			cs.setDouble(2, amount);
			cs.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean createAccount(String username) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "INSERT INTO ACCOUNTS (USER_NAME,AMOUNT) VALUES ( ? ,DEFAULT)";
			PreparedStatement ptsmt = con.prepareStatement(sql);
			ptsmt.setString(1, username);
			ptsmt.execute();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean deleteAccount(int ID, String username) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ACCOUNTS WHERE ACCOUNT_ID = ? AND USER_NAME = ?";
			PreparedStatement ptsmt = con.prepareStatement(sql);
			ptsmt.setInt(1, ID);
			ptsmt.setString(2, username);
			ResultSet rs = ptsmt.executeQuery();
			rs.next();
			if (rs.getInt("AMOUNT") == 0) {
				con = ConnectionUtil.getConnection();
				sql = "DELETE FROM ACCOUNTS WHERE ACCOUNT_ID = ? AND USER_NAME = ? ";
				ptsmt = con.prepareStatement(sql);
				System.out.println(ID);

				ptsmt.setInt(1, ID);
				ptsmt.setString(2, username);
				ptsmt.execute();
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean deleteAccount(int ID) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ACCOUNTS WHERE ACCOUNT_ID = ?";
			PreparedStatement ptsmt = con.prepareStatement(sql);
			ptsmt.setInt(1, ID);
			ResultSet rs = ptsmt.executeQuery();
			rs.next();
			if (rs.getInt("AMOUNT") == 0) {
				con = ConnectionUtil.getConnection();
				sql = "DELETE FROM ACCOUNTS WHERE ACCOUNT_ID = ?";
				ptsmt = con.prepareStatement(sql);
				System.out.println(ID);

				ptsmt.setInt(1, ID);
				ptsmt.execute();
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean withdraw(int ID, double amount, String username) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ACCOUNTS WHERE USER_NAME = ? AND ACCOUNT_ID = ? ORDER BY ACCOUNT_ID";
			PreparedStatement pdsmt = con.prepareStatement(sql);
			pdsmt.setString(1, username);
			pdsmt.setInt(2, ID);
			ResultSet rs = pdsmt.executeQuery();
			if (rs.next()) {
				sql = "{CALL WITHDRAW_FROM_ACCOUNTS(?,?)}";
				CallableStatement cs = con.prepareCall(sql);
				cs.setInt(1, ID);
				cs.setDouble(2, amount);
				cs.execute();
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean deposit(int ID, double amount, String username) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			String sql = "SELECT * FROM ACCOUNTS WHERE USER_NAME = ? AND ACCOUNT_ID = ? ORDER BY ACCOUNT_ID";
			PreparedStatement pdsmt = con.prepareStatement(sql);
			pdsmt.setString(1, username);
			pdsmt.setInt(2, ID);
			ResultSet rs = pdsmt.executeQuery();
			if (rs.next()) {
				con = ConnectionUtil.getConnection();
				sql = "{CALL DEPOSIT_TO_ACCOUNTS(?,?)}";
				CallableStatement cs = con.prepareCall(sql);
				cs.setInt(1, ID);
				cs.setDouble(2, amount);
				cs.execute();
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

}
