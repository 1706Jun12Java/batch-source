package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.List;

import com.revature.domain.BankUser;
import com.revature.util.ConnectionUtil;

public class BankSuperuserDaoImpl implements BankSuperuserDao {

	public BankSuperuserDaoImpl() {
	}

	@Override
	public int login(String username, String password) {
		return 0;
	}

	@Override
	public int registerNewBankUser(String username, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BankUser> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteAllBankUsers() {
		int deleteSuccess = 0;
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			con.setAutoCommit(false);
			String sql = "TRUNCATE TABLE BANK_LOGIN_INFO CASCADE";
			Statement pstmt = con.createStatement();
			deleteSuccess = pstmt.executeUpdate(sql);
			con.commit();
			System.out.println("Success");

		}catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return deleteSuccess;
		
	}
	

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

}
