package com.revature.bank.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.revature.bank.domain.Account;
import com.revature.bank.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao{

	public AccountDaoImpl(){};

	public List<Account> getAccounts() {
		List<Account> accList = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
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
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
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
		CallableStatement cstmt = null;
		try{
			con = ConnectionUtil.getConnectionFromFile();
			cstmt = con.prepareCall("{call SP_INSERT_ACCOUNT(?)}");
			cstmt.setInt(1, userId);
			acCreated = cstmt.executeUpdate();
			if(acCreated==1){
				System.out.println("account created");
			}
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
		int accDeleted = 1;
		CallableStatement cstmt = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			cstmt = con.prepareCall("{call SP_DELETE_ACCOUNT(?,?,?)}");
			cstmt.setInt(1, userId);
			cstmt.setInt(2, id);
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.execute();
			accDeleted = cstmt.getInt(3);
			if(accDeleted==0){
				System.out.println("account deleted");
			}else{
				System.out.println("fail to delete");
			}
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
		Connection con = null;
		CallableStatement cstmt = null;
		try{
			con = ConnectionUtil.getConnectionFromFile();
			cstmt = con.prepareCall("{call SP_DEPOSITE_ACCOUNT(?,?)}");
			cstmt.setInt(1, acc);
			cstmt.setDouble(2, amount);
			deposited = cstmt.executeUpdate();
			if(deposited==1){
				System.out.println("deposited");
			}
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
		Connection con = null;
		CallableStatement cstmt = null;
		try{
			con = ConnectionUtil.getConnectionFromFile();
			cstmt = con.prepareCall("{call SP_WD_ACCOUNT(?,?)}");
			cstmt.setInt(1, acc);
			cstmt.setDouble(2, amount);
			withdrawn = cstmt.executeUpdate();
			if(withdrawn==1){
				System.out.println("withdrawn");
			}
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
