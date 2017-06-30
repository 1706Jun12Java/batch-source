package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.Exceptions.InvalidAccountException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.Exceptions.OverDraftException;
import com.revature.Util.ConnectionUtil;
import com.revature.domain.Account;
import com.revature.domain.User;

public class AccountImpl implements AccountDao {
	UserDao ud = new UserImpl();
	public AccountImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean createAccount(int accountType, User owner) {
		boolean success = false;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql;
				PreparedStatement ps;
				sql = "INSERT INTO \"ACCOUNT\" (ACCOUNT_TYPE,BALANCE,ACCOUNT_OWNER) VALUES (?,?,?)";
				ps = con.prepareStatement(sql);
				String type = "";
				if(accountType == 1){
					type = "CHECKING";
				} else {
					type = "SAVINGS";
				}
				ps.setString(1, type);
				ps.setDouble(2, 0);
				ps.setInt(3,owner.getUserID());
				int i = ps.executeUpdate();
				if(i > 0){
					success = true;
				}		
		}catch(SQLException e){
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean deleteAccount(int accountID,User owner) throws InvalidAccountException {
		boolean success = false;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql = "SELECT * FROM \"ACCOUNT\" WHERE ACCOUNT_OWNER = ? AND ACCOUNT_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,owner.getUserID());
			ps.setInt(2,accountID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Double balance = rs.getDouble("BALANCE");
				if(balance > 0){
					throw new InvalidAccountException("DELETION FAILED: Balance is not 0");
				}
				sql = "DELETE FROM \"ACCOUNT\" WHERE ACCOUNT_OWNER = ? AND ACCOUNT_ID = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1,owner.getUserID());
				ps.setInt(2, accountID);
				int i = ps.executeUpdate();
				if(i > 0){
					success = true;
				}
			} else{
				throw new InvalidAccountException("DELETION FAIL:Account does not exist.");
			}			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean updateAccount(int accountNum,double value,User owner) throws InvalidAccountException, OverDraftException {
		boolean success = false;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql = "SELECT * FROM \"ACCOUNT\" WHERE ACCOUNT_OWNER = ? AND ACCOUNT_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, owner.getUserID());
			ps.setInt(2, accountNum);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				if(rs.getDouble("BALANCE") + value < 0){
					throw new OverDraftException("Overdraft: Insufficent funds");
				}
				sql = "{call UPDATE_BALANCE(?,?,?,?)}";
				CallableStatement cs = con.prepareCall(sql);
				cs.setInt(1,accountNum);
				cs.setDouble(2,value);
				cs.setInt(3, owner.getUserID());
				cs.registerOutParameter(4, java.sql.Types.INTEGER);
				cs.execute();
				int i = cs.getInt(4);
				if(i == 1){
					success = true;
				}
			} else {
				throw new InvalidAccountException("TRANSACTION FAIL:Account does not exist"); 
			}
		}catch(SQLException e){
			e.printStackTrace();
		} 
		return success;
	}

	@Override
	public Account getAccount(int ID) throws InvalidUsernameException, InvalidAccountException {
		Account account = null;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql = "SELECT * FROM \"ACCOUNT\" WHERE ACCOUNT_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int accountID = rs.getInt("ACCOUNT_ID");
				String accountType = rs.getString("ACCOUNT_TYPE");
				double balance = rs.getDouble("BALANCE");
				User user = ud.getUser(rs.getInt("ACCOUNT_OWNER"));
				account = new Account(accountID,accountType,balance,user);
			} else {
				throw new InvalidAccountException("Account does not exist");
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		} 
		return account;
	}

	@Override
	public List<Account> getAllAccountsByUser(User owner) throws InvalidUsernameException, InvalidAccountException {
		ArrayList<Account> accounts = new ArrayList<>();
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql = "SELECT * FROM \"ACCOUNT\" WHERE ACCOUNT_OWNER = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, owner.getUserID());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int accountID = rs.getInt("ACCOUNT_ID");
				String accountType = rs.getString("ACCOUNT_TYPE");
				double balance = rs.getDouble("BALANCE");
				User user = ud.getUser(rs.getInt("ACCOUNT_OWNER"));
				Account account = new Account(accountID,accountType,balance,user);
				accounts.add(account);
			} 
			if(accounts.isEmpty()) {
				throw new InvalidAccountException("No current accounts");
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		} 
		return accounts;
	}

}
