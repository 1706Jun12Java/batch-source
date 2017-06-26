package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Account;
import com.revature.domain.Users;
import com.revature.util.ConnectionUtil;

public class UsersDaoImpl implements UsersDao {

	public UsersDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Users> getUsers() {
		List<Users> ul = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM USERS";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String usersName = rs.getString("USERS_NAME");
				int usersID = rs.getInt("USERS_ID");
				ul.add(new Users(usersID, usersName));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ul;
	}

	@Override
	public Users getUsersById(int usersid) {
		  PreparedStatement pStatement;
		          Users user= null;
		  
		          try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
		              String sql = "SELECT * FROM USER_ID WHERE USERS_ID = ?";
		              pStatement = con.prepareStatement(sql);
		              pStatement.setInt(1,usersid);
		              ResultSet rs = pStatement.executeQuery();
		  
		              while(rs.next()){
		                  int userID = rs.getInt("USERS_ID");
		                  String username = rs.getString("USERS_NAME");
		                  user = new Users(userID, username);
		              }
		  
		  
		          } catch (IOException | SQLException e) {
		              e.printStackTrace();
		          }
		  
		          return user;
		      }

	@Override
	public void createUsers(String usersName, String password) {

		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")) {
			String sql = "INSERT INTO USERS(USERS_NAME, USERS_PASSWORD)" + " VALUES(?,?)";
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setString(1, usersName);
			pStatement.setString(2, password);
			if (pStatement.executeUpdate() > 0)
				System.out.println("Registration Complete");
			else
				System.out.println("Failed to register.");

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createAccount(String user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(String user, int aNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Account> getAllBalances(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void withdraw(String user, int accountId, int withdraw) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposit(String user, int accountId, int deposit) {
		// TODO Auto-generated method stub
		
	}
}