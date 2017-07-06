package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.domain.Account;
import com.revature.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao {

	@Override
	public List<Account> getAccount() {
		List<Account> al = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			String sql = "SELECT * FROM ACCOUNT";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("A_ID");
				int balance = rs.getInt("BALANCE");
				int withdraw = rs.getInt("WITHDRAW");
				int deposit = rs.getInt("DEPOSIT");
				al.add(new Account(id, balance,withdraw,deposit));
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
			String sql = "SELECT * FROM ACCOUNT WHERE A_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int uid = rs.getInt("A_ID");
				int balance = rs.getInt("BALANCE");
				int withdraw = rs.getInt("WITHDRAW");
				int deposit = rs.getInt("DEPOSIT");
				account = new Account(uid,balance,withdraw,deposit);
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

	@Override
	public void deleteAccount(int a_id) {
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			String sql = "SELECT * FROM ACCOUNT WHERE A_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,a_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int balance = rs.getInt("BALANCE");
				if(balance > 0){
					System.out.println("Can not delete an account with a balance that is not zero");
				}else{
				sql = "DELETE FROM ACCOUNT WHERE A_ID = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1,a_id);
				ps.executeQuery();
				System.out.println("Account deleted");
				}
				}
		}catch(IOException |SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void withdraw(int a_id, int withdraw) {
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			String sql = "SELECT * FROM ACCOUNT WHERE A_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int balance = rs.getInt("BALANCE");
				if (balance == 0) {
					System.out.println("Cannot withdraw because there is no money.");
				} else {
					balance -= withdraw;
					sql = "UPDATE ACCOUNT SET WITHDRAW = ? WHERE A_ID = ?";
					ps = con.prepareStatement(sql);
					ps.setInt(1, withdraw);
					ps.setInt(2, a_id);
					ps.executeQuery();
					sql = "UPDATE ACCOUNT SET BALANCE = ? WHERE A_ID = ?";
					ps = con.prepareStatement(sql);
					ps.setInt(1, balance);
					ps.setInt(2, a_id);
					ps.executeQuery();
					System.out.println("Account withdraw.");
				}
			}
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deposit(int a_id, int deposit) {
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			String sql = "SELECT * FROM ACCOUNT WHERE A_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a_id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int balance = rs.getInt("BALANCE");
					balance += deposit;
					sql = "UPDATE ACCOUNT SET 	DEPOSIT = ? WHERE A_ID = ?";
					ps = con.prepareStatement(sql);
					ps.setInt(1, deposit);
					ps.setInt(2, a_id);
					ps.executeQuery();
					sql = "UPDATE ACCOUNT SET BALANCE = ? WHERE A_ID = ?";
					ps = con.prepareStatement(sql);
					ps.setInt(1, balance);
					ps.setInt(2, a_id);
					ps.executeQuery();
					System.out.println("Deposit made.");
				}
			}
		 catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
}