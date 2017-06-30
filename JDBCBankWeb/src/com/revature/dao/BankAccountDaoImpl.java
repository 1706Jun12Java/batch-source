package com.revature.dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.BankAccount;
import com.revature.util.ConnectionUtil;

public class BankAccountDaoImpl implements BankAccountDao{

	@Override
	public List<BankAccount> getBankAccountList(int userId) {
		List<BankAccount> bai = new ArrayList<>();
	
		int loginSuccess = 0;
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			String sql = "SELECT * FROM BANK_ACCOUNT_INFO WHERE USER_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int id  = rs.getInt("USER_ID");
				int bankAccountId = rs.getInt("BANK_ACCOUNT_ID");
				BigDecimal bankAccountBalance = rs.getBigDecimal("BANK_ACCOUNT_BALANCE");
				bai.add(new BankAccount(id, bankAccountId, bankAccountBalance));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bai;
			
			
	}

	@Override
	public int getBankAccountBalance(int userId, int bankAccountId) {
		int bankBalance = 0;
		PreparedStatement pstmt = null;
		BankAccountDaoImpl baidi = new BankAccountDaoImpl();
//		Bear bear = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM BANK_ACCOUNT_INFO WHERE USER_ID = ? AND BANK_ACCOUNT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,userId);
			pstmt.setInt(2, bankAccountId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				bankBalance = rs.getInt("BANK_ACCOUNT_BALANCE");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bankBalance;
		
	}

	@Override
	public void createBankAccount(int userId) {		
		int newUserSuccess = 0;
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			con.setAutoCommit(false); //manual tx management
			String sql = "INSERT INTO BANK_ACCOUNT_INFO (USER_ID)" +
						" VALUES(?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			newUserSuccess = pstmt.executeUpdate();
			con.commit();
			System.out.println("Congrats! Your new bank account has been created!");
	} catch (Exception e){
		e.printStackTrace();
	}
	}

	@Override
	public void deposit(int userId, int bankAccountId, BigDecimal amount) {
		int newUserSuccess = 0;
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			con.setAutoCommit(false);
			String sql = "UPDATE BANK_ACCOUNT_INFO " +
						"SET BANK_ACCOUNT_BALANCE = BANK_ACCOUNT_BALANCE + ?" +
						"WHERE USER_ID = ? AND BANK_ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setBigDecimal(1, amount);
			pstmt.setInt(2,  userId);
			pstmt.setInt(3, bankAccountId);
			newUserSuccess = pstmt.executeUpdate();
			con.commit();
			System.out.println("Success! You've just added $" + amount + " to your bank account: " + bankAccountId);
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void withdraw(int userId, int bankAccountId, BigDecimal amount) {
		int newUserSuccess = 0;
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			con.setAutoCommit(false);
			String sql = "UPDATE BANK_ACCOUNT_INFO " +
						"SET BANK_ACCOUNT_BALANCE = BANK_ACCOUNT_BALANCE - ?" +
						"WHERE USER_ID = ? AND BANK_ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setBigDecimal(1, amount);
			pstmt.setInt(2,  userId);
			pstmt.setInt(3, bankAccountId);
			newUserSuccess = pstmt.executeUpdate();
			con.commit();
			System.out.println("Success! You've just withdrawn $" + amount + "to your bank account: " + bankAccountId);
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public int deleteBankAccount(int userId, int bankAccountId) {
		int newUserSuccess = 0;
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			con.setAutoCommit(false);
			String sql = "DELETE FROM BANK_ACCOUNT_INFO " +
						"WHERE USER_ID = + ?" +
						"WHERE USER_ID = ? AND BANK_ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, bankAccountId);
			newUserSuccess = pstmt.executeUpdate();
			con.commit();
			System.out.println("Success! You've just deleted your bank account: " + bankAccountId);
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return newUserSuccess;
	}

}
