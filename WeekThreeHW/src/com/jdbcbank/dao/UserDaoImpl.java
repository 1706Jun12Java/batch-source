package com.jdbcbank.dao;

import java.io.IOException;
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbcbank.domain.*; 
import com.jdbcbank.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<User> getUsers() throws SQLException, IOException {
		List<User> listUsers = new ArrayList<User>();
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "SELECT * FROM USER_TABLE";
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet rs = pstmt.executeQuery(); 
			while (rs.next()){
				int id = rs.getInt("USER_ID");
				String user_email = rs.getString("USER_EMAIL");
				String user_username = rs.getString("USER_USERNAME"); 
				String user_password = rs.getString("USER_PASSWORD"); 
				int user_active = rs.getInt("USER_ACTIVE");
				listUsers.add(new User(id, user_username, user_password, user_email, user_active));
			}  
		} 
		return listUsers;
	}

	@Override
	public void createUser(User u) throws SQLException, IOException {
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "INSERT INTO USER_TABLE(USER_USERNAME, USER_PASSWORD, USER_EMAIL, USER_ACTIVE) VALUES(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,u.getUser_username()); 
			pstmt.setString(2,u.getUser_password()); 
			pstmt.setString(3,u.getUser_email());  
			pstmt.setInt(4,u.getUser_active());  
			pstmt.executeUpdate();  
			System.out.println("create...");
		}  
	}

	@Override
	public void updateUser(User u) throws SQLException, IOException {
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "UPDATE USER_TABLE SET USER_USERNAME = ?, USER_PASSWROD = ? USER_EMAIL = ?,USER_ACTIVE = ?, WHERE USER_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u.getUser_username());  
			pstmt.setString(2, u.getUser_password());
			pstmt.setString(3, u.getUser_email());
			pstmt.setInt(4, u.getUser_active());
			pstmt.executeUpdate();  
		}   
	}

	@Override
	public void deleteUser(User u) throws SQLException, IOException {
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "UPDATE USER_TABLE SET USER_ACTIVE = 0, WHERE USER_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,u.getUser_id());  
			pstmt.executeUpdate();  
		}    
	}

	@Override
	public int loginUser(User u) throws SQLException, IOException {  
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "SELECT * FROM USER_TABLE WHERE USER_USERNAME = ? AND USER_PASSWORD = ? AND USER_ACTIVE = 1";
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, u.getUser_username());
			pstmt.setString(2, u.getUser_password());
			ResultSet rs = pstmt.executeQuery();  
			if (rs.next()){
				 return rs.getInt("USER_ID");
			}  
			else
				return 0;
		}   
	}

	@Override
	public boolean userNameExist(User u) throws SQLException, IOException {
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			System.out.println("222");
			String sql = "SELECT * FROM USER_TABLE WHERE USER_USERNAME = ?";
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, u.getUser_username()); 
			ResultSet rs = pstmt.executeQuery();  
			if (rs.next()){
				 return true;
			}  
			else
				return false;
		}  
	}

	@Override
	public int updateUserID(User u) throws SQLException, IOException {
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "SELECT * FROM USER_TABLE WHERE USER_USERNAME = ?";
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, u.getUser_username()); 
			ResultSet rs = pstmt.executeQuery();  
			if (rs.next()){
				 return rs.getInt("USER_ID");
			}  
			else
				return 0;
		}  
	} 
}