package com.chase.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.chase.domain.BankAccount;
import com.chase.util.ConnectionUtil;

public class BankAccountDaoImpl implements BankAccountDao {
	
	public static void withdraw(int userId,int accountNum,int amount) {
		CallableStatement cs;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "{call WITHDRAWL(?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, userId);
			cs.setInt(2, accountNum);
			cs.setInt(3, amount);
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("You withdrew $"+amount);
	}
	
	public static void deposit(int userId,int bankAccountId,int amount) {
		CallableStatement cs = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			String sql = "{call DEPOSIT(?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, userId);
			cs.setInt(2, bankAccountId);
			cs.setInt(3, amount);
			cs.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("You deposited $"+amount);
	}
	
	public static void createBankAccount(double amount) {
        try(Connection con = ConnectionUtil.getConnectionFromFile()) {
            String sql = "INSERT INTO BANK_ACCOUNT (CURRENT_BALANCE) VALUES(?)";

            PreparedStatement pStatement = con.prepareStatement(sql);
            pStatement.setDouble(1,amount);
            pStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
		System.out.println("New account created.");
	}
	public static BankAccount getBankAccountbyId(int id) {
		PreparedStatement pstmt = null;
		BankAccount ba = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			String sql = "SELECT CURRENT_BALANCE FROM BANK_ACCOUNT WHERE BANK_ACCOUNT_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				double currentBalance = rs.getDouble("CURRENT_BALANCE");
				ba = new BankAccount(currentBalance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ba;
	}

}
