package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.*;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<User> getUsers() {
		PreparedStatement pstmt = null;
		List<User> users = new ArrayList<>();
		try(Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ERS_USERS";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int userId = rs.getInt("U_ID");
				String username = rs.getString("U_USERNAME");
				String password= rs.getString("U_PASSWORD");
				String fname= rs.getString("U_FNAME");
				String lname= rs.getString("U_LNAME");
				String email = rs.getString("U_EMAIL");
				int userRoleId= rs.getInt("UR_ID");
				users.add(new User(userId,username,password,fname,lname,email,userRoleId));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return users;
	}



	@Override
	public User getUserById(int id) {
		PreparedStatement pstmt = null;
		User user = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ERS_USERS WHERE U_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String username = rs.getString("U_USERNAME");
				String password= rs.getString("U_PASSWORD");
				String fname= rs.getString("U_FNAME");
				String lname= rs.getString("U_LNAME");
				String email = rs.getString("U_EMAIL");
				int userRoleId= rs.getInt("UR_ID");
				user = new User(id,username,password,fname,lname,email,userRoleId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return user;
	}



	@Override
	public User userLogin(String username, String pass) {
		PreparedStatement pstmt = null;
		User user = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ERS_USERS WHERE U_USERNAME = ? AND U_PASSWORD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int userId = rs.getInt("U_ID");
				String fname= rs.getString("U_FNAME");
				String lname= rs.getString("U_LNAME");
				String email = rs.getString("U_EMAIL");
				int userRoleId= rs.getInt("UR_ID");
				user = new User(userId,username,pass,fname,lname,email,userRoleId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return user;
	}



	@Override
	public List<User> getAllEmployees() {
		PreparedStatement pstmt = null;
		List<User> users = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ERS_USERS WHERE UR_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 2);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int id = rs.getInt("U_ID");
				String username = rs.getString("U_USERNAME");
				String password= rs.getString("U_PASSWORD");
				String fname= rs.getString("U_FNAME");
				String lname= rs.getString("U_LNAME");
				String email = rs.getString("U_EMAIL");
				int userRoleId= rs.getInt("UR_ID");
				users.add(new User(id,username,password,fname,lname,email,userRoleId));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return users;
		
	}



	@Override
	public boolean updateUser(User user, String fname, String lname, String email) {
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			con.setAutoCommit(false);
			String sql = "UPDATE ERS_USERS SET U_FNAME =  ?, U_LNAME = ?, U_EMAIL= ? WHERE U_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,fname);
			pstmt.setString(2,lname);
			pstmt.setString(3,email);
			pstmt.setInt(4,user.getU_id());
			
			if(pstmt.executeUpdate() == 1){
				con.commit();
				con.setAutoCommit(true);
				return true;
			} 
			else {
				con.rollback();
				return false;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}



	@Override
	public void logout(User user) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public boolean isManager(User manager) {
		String mana="";
		if(manager!=null){
			UserDaoImpl userDao= new UserDaoImpl();
			mana = userDao.getUserRole(manager);
		}
		else{
			return false;
		}
		if(mana.equals("Manager")){
			return true;
		}
		else
			return false;
	}



	@Override
	public boolean registerEmp(User user) {
		int userCreated=0;
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			con.setAutoCommit(false);
			String sql = "INSERT INTO ERS_USERS(U_USERNAME,U_PASSWORD,U_FNAME,U_LNAME,U_EMAIL,UR_ID) "
					+ "VALUES (?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,user.getU_username());
			pstmt.setString(2,user.getU_password());
			pstmt.setString(3,user.getU_fname());
			pstmt.setString(4,user.getU_lname());
			pstmt.setString(5,user.getU_email());
			pstmt.setInt(6, user.getUr_id());
			userCreated = pstmt.executeUpdate();
			
			if(userCreated == 1){
				con.commit();
				con.setAutoCommit(true);
				return true;
			} 
			else {
				con.rollback();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}



	@Override
	public String getUserRole(User user) {
		PreparedStatement pstmt = null;
		String userRole="";
		try (Connection con = ConnectionUtil.getConnectionFromFile("connection.properties")){
			String sql = "SELECT * FROM ERS_USER_ROLES WHERE UR_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, user.getUr_id());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				userRole= rs.getString("UR_ROLE");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return userRole;
	}
}
