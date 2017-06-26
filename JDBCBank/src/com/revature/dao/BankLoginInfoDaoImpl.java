package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.BankLoginInfo;
import com.revature.util.ConnectionUtil;

public class BankLoginInfoDaoImpl implements BankLoginInfoDao {
	int loginSuccess;

	@Override
	public int registerNewBankUser(String username, String password) {
		int newUserSuccess = 0;
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			con.setAutoCommit(false); //manual tx management
			String sql = "INSERT INTO BANK_LOGIN_INFO (USERNAME, PASSWORD)" +
						" VALUES(?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			newUserSuccess = pstmt.executeUpdate();
			con.commit();
			System.out.println("Congrats! Your user account has been created!");

		} catch(SQLIntegrityConstraintViolationException e){
			System.out.println("This username is already taken. Try again.");
			e.printStackTrace();			
		}catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return newUserSuccess;
		
	}

	@Override
	public int login(String username, String password) {
		loginSuccess = 0;
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			String sql = "SELECT * FROM BANK_LOGIN_INFO WHERE USERNAME=? AND PASSWORD=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				loginSuccess = rs.getInt("USER_ID");
				String userName = rs.getString("USERNAME");
				System.out.println("Hi" + userName);
				return loginSuccess;
			} else {
				System.out.println("Invalid username/password. Please try again.");
				return loginSuccess;
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
		return loginSuccess;
	}

	@Override
	public void logout() {
		this.loginSuccess = 0;
	}

	@Override
	public int isOnline() {
		return loginSuccess;
	}

	@Override
	public List<BankLoginInfo> getUsers() {
		PreparedStatement pstmt = null;
		List<BankLoginInfo> bankUsers = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM BANKLOGININFO";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				String username = rs.getString("username");
				BankLoginInfo newB = new BankLoginInfo(username);
				bankUsers.add(newB);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bankUsers;
	}
	
}
