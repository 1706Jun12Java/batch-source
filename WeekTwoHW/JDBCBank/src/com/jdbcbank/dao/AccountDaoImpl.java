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
	public List<Account> getUserAcount(User u) {
		List<Account> listAccounts = new ArrayList<Account>();
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "SELECT * FROM ACCOUNT WHERE ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,u.getUser_id()); 
			ResultSet rs = pstmt.executeQuery(sql); 
			while (rs.next()){
				int id = rs.getInt("ACCOUNT_ID");
				int user_id = rs.getInt("USER_ID");
				float balance = rs.getFloat("BALANCE"); 
				listAccounts.add(new Account(id, user_id, balance));
			}  
		}
		catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e1) { 
			e1.printStackTrace();
		}
		return listAccounts;
	}

	@Override
	public void createAccount(User u) {
		Account a = new Account(1, u.getUser_id(), 0);
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "INSERT INTO ACCOUNT(USER_ID, BALANCE) VALUES(?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,a.getUser_id()); 
			pstmt.setFloat(2,a.getBalance()); 
			pstmt.executeUpdate(sql);  
			
		} catch (SQLException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}  
	}
		 

	@Override
	public void deleteAccount(Account a) {
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "DELETE FROM ACCOUNT WHERE ACCOUNT_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,a.getUser_id());  
			pstmt.executeUpdate(sql);  
		} catch (SQLException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}   
	}

	@Override
	public void depositeAccount(Account a, float money) {
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "UPDATE ACCOUNT SET BALACE = BALACE - ? WHERE ACCOUNT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setFloat(1,money);  
			pstmt.setInt(2, a.getAccount_id());
			pstmt.executeUpdate(sql);  
		} catch (SQLException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}  
	}

	@Override
	public void withdrowAccount(Account a, float money) {
		depositeAccount(a,  -1 * money);
	} 
}
