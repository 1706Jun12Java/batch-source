package com.jdbcbank.dao;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import com.jdbcbank.domain.Account;
import com.jdbcbank.domain.User;
import com.jdbcbank.util.ConnectionUtil; 


public class AccountDaoImpl implements AccountDao {

	public AccountDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Account> getUserAccount(User u) throws SQLException, IOException {
		List<Account> listAccounts = new ArrayList<Account>();
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "SELECT * FROM ACCOUNT WHERE USER_ID = ? AND ACCOUNT_ACTIVE = 1 ORDER BY ACCOUNT_ID";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,u.getUser_id()); 
			ResultSet rs = pstmt.executeQuery(); 
			while (rs.next()){
				int id = rs.getInt("ACCOUNT_ID");
				int user_id = rs.getInt("USER_ID");
				float balance = rs.getFloat("BALANCE"); 
				int account_active = rs.getInt("ACCOUNT_ACTIVE");
				listAccounts.add(new Account(id, user_id, balance, account_active));
			}  
		} 
		return listAccounts;
	}

	@Override
	public void createAccount(Account a) throws SQLException, IOException {
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "INSERT INTO ACCOUNT(USER_ID) VALUES(?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,a.getUser_id());  
			pstmt.executeUpdate();   
		}  
	}
		 

	@Override
	public void deleteAccount(Account a) throws SQLException, IOException{
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "UPDATE ACCOUNT SET ACCOUNT_ACTIVE=0 WHERE ACCOUNT_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,a.getAccount_id());  
			pstmt.executeUpdate();  
		}  
	}

	@Override
	public void depositAccount(Account a, float money) throws SQLException, IOException{
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "UPDATE ACCOUNT SET BALANCE = BALANCE + ? WHERE ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setFloat(1,money);  
			pstmt.setInt(2, a.getAccount_id());
			pstmt.executeUpdate();  
		}  
	}

	@Override
	public void withdrowAccount(Account a, float money) throws SQLException, IOException {
	 depositAccount(a,  -1 * money);
	} 
}