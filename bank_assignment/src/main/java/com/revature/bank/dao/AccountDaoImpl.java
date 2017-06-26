package com.revature.bank.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.domain.Account;
import com.revature.bank.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao{
	
	public AccountDaoImpl(){};

	public List<Account> getAccounts() {
		List<Account> accList = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM BANK_ACCOUNT";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int userId = rs.getInt("USER_ID");
				double balance = rs.getDouble("BAL");
				int acId = rs.getInt("AC_ID");
				accList.add(new Account(acId, userId, balance));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}
		return accList;
	}

	public List<Account> getAccountByUserId(int id) {
		PreparedStatement pstmt = null;
		List<Account> acList = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM BANK_ACCOUNT WHERE USER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int userId = rs.getInt("USER_ID");
				double balance = rs.getDouble("BAL");
				int acId = rs.getInt("AC_ID");
				acList.add(new Account(acId, userId, balance));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return acList;
	}

	public int createAccount(int userId) {
		int acCreated = 0;
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			con.setAutoCommit(false); //manual tx management
			String sql = "INSERT INTO BANK_ACCOUNT (USER_ID, BAL)"
					+" VALUES(?,0)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			acCreated = pstmt.executeUpdate();
			con.commit();
		} catch(IOException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return acCreated;
	}

	public int deleteAccount(int userId, int id) {
		int accDeleted = 0;
		CallableStatement cs = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			con.setAutoCommit(false); //manual tx management
			String sql = "{call SP_DELETE_BANK_ACCOUNT(?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, userId);
			cs.setInt(2, id);
			cs.registerOutParameter(3, java.sql.Types.INTEGER);
			cs.execute();
			accDeleted=cs.getInt(3);
			System.out.println("account deleted");
		} catch(IOException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return accDeleted;
	}

	public int deposite(int acc, Double amount) {
		int deposited = 0;
		CallableStatement cs = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			con.setAutoCommit(false); //manual tx management
			String sql = "{call SP_DEPOSITE_BANK_ACCOUNT(?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, acc);
			cs.setDouble(2, amount);
			cs.registerOutParameter(3, java.sql.Types.INTEGER);
			cs.execute();
			deposited = cs.getInt(3);
		} catch(IOException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return deposited;
	}

	public int withdraw(int acc, Double amount) {
		int withdrawn=0;
		CallableStatement cs = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			con.setAutoCommit(false); //manual tx management
			String sql = "{call SP_WITHDRAW_BANK_ACCOUNT(?,?,?)}";
			cs = con.prepareCall(sql);
			cs.setInt(1, acc);
			cs.setDouble(2, amount);
			cs.registerOutParameter(3, java.sql.Types.INTEGER);
			cs.execute();
			withdrawn = cs.getInt(3);
			
		} catch(IOException e){
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return withdrawn;
	}
}


