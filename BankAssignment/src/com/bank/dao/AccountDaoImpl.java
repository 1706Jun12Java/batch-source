package com.bank.dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.domain.Account;
import com.bank.domain.Customer;
import com.bank.util.ConnectionUtil;

public class AccountDaoImpl implements AccountDao{

	@Override
	public List<Account> getAccounts() throws SQLException, IOException {
		List<Account> al = new ArrayList<>();
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ACCOUNT";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()){
				int aid = rs.getInt("accId");
				int bal = rs.getInt("balance");
				int cid = rs.getInt("custId");
				al.add(new Account(aid,bal,cid));
			}
	}
		return al;
}
	
	@Override
	public static void createAccount() throws IOException {
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			con.setAutoCommit(false); //manual tx management
			String sql = "{call SP_INSERT_ACCOUNT(?,?,?)}"; //calling stored procedure to insert new record
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,account.getAccId());
			pstmt.setInt(2,account.getBalance());
			pstmt.setInt(3,account.getCustId());			
			accountsCreated = pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}


	@Override
	public Account getAccountById(int id) {
		PreparedStatement pstmt = null;
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		Account account = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ACCOUNT WHERE accId = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int aid = rs.getInt("accId");
				int bal = rs.getInt("balance");
				int cid = rs.getInt("custId");
				Customer customer = cdi.getCustomerById(cid);
				account = new Account(aid,bal,cid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return account;
	}

	@Override
	public int updateAccount(int accId) {
		int amtFed = 0;
		CallableStatement cs = null;
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT";
			cs = con.prepareCall(sql);
			cs.setInt(1, accId);
			cs.setInt(2, balance);
			cs.setInt(3, a);
			cs.registerOutParameter(4, java.sql.Types.INTEGER);
			cs.execute();
			amtFed = cs.getInt(4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return amtFed;
	}

	@Override
	public int deleteAccount(Account account) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addToAccount(int accId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int withDrawFromAccount(int accId) {
		// TODO Auto-generated method stub
		return 0;
	}
}
