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
	public List<User> getUsers() {
		List<User> listUsers = new ArrayList<User>();
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "SELECT * FROM USER_TABLE";
			PreparedStatement pstmt = con.prepareStatement(sql); 
			ResultSet rs = pstmt.executeQuery(sql); 
			while (rs.next()){
				int id = rs.getInt("USER_ID");
				String user_type = rs.getString("USER_TYPE");
				String user_username = rs.getString("USER_USERNAME"); 
				String user_password = rs.getString("USER_PASSWORD"); 
				listUsers.add(new User(id, user_type, user_username, user_password));
			}  
		} catch (SQLException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}
		return listUsers;
	}

	@Override
	public void createUser(User u) {
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "INSERT INTO USER_TABLE(USER_TYPE, USER_USERNAME, USER_PASSWORD) VALUES(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,u.getUser_type()); 
			pstmt.setString(2,u.getUser_username()); 
			pstmt.setString(3,u.getUser_password());  
			pstmt.executeUpdate(sql);  
		} catch (SQLException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		} 
	}

	@Override
	public void updateUser(User u) {
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "UPDATE USER_TABLE SET USER_TYPE = ?, USER_USERNAME = ?, USER_PASSWROD = ? WHERE USER_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, u.getUser_type());  
			pstmt.setString(2, u.getUser_username());
			pstmt.setString(3, u.getUser_password());
			pstmt.executeUpdate(sql);  
		} catch (SQLException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}   
	}

	@Override
	public void deleteUser(User u) {
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "DELETE FROM USER_TABLE WHERE USER_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,u.getUser_id());  
			pstmt.executeUpdate(sql);  
		} catch (SQLException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}    
	}

	@Override
	public boolean loginUser(User u) {  
		try(Connection con = ConnectionUtil.getConnection("connection.properties")){
			String sql = "SELECT * FROM USER_TABLE WHERE USER_USERNAME = ? AND USER_PASSWORD = ?";
			PreparedStatement pstmt = con.prepareStatement(sql); 
			pstmt.setString(1, u.getUser_username());
			pstmt.setString(2, u.getUser_password());
			ResultSet rs = pstmt.executeQuery(sql);  
			if (rs.next()){
				 return true;
			}  
			else
				return false;
		} catch (SQLException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		}  
		return false; 
	}
 
}
