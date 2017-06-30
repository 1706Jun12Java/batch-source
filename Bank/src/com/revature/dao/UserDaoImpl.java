package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
			String sql = "SELECT * FROM USERACCOUNT";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int userId=rs.getInt("USER_ID");
				String username = rs.getString("USERNAME");
				String password= rs.getString("U_PASSWORD");
				String fname= rs.getString("FNAME");
				String lname= rs.getString("LNAME");
				String isSuperUser= rs.getString("ISSUPERUSER");
				
				users.add(new User(userId,username,password,fname,lname,isSuperUser));
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
			String sql = "SELECT * FROM USERACCOUNT WHERE USER_ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				String username = rs.getString("USERNAME");
				String password= rs.getString("U_PASSWORD");
				String fname= rs.getString("FNAME");
				String lname= rs.getString("LNAME");
				String isSuperUser= rs.getString("ISSUPERUSER");
				user = new User(id,username,password,fname,lname,isSuperUser);
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
			String sql = "SELECT * FROM USERACCOUNT WHERE USERNAME = ? AND U_PASSWORD = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				int userId = rs.getInt("USER_ID");
				String fname= rs.getString("FNAME");
				String lname= rs.getString("LNAME");
				String isSuperUser= rs.getString("ISSUPERUSER");
				user = new User(userId,username,pass,fname,lname,isSuperUser);
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
	public void viewUsers(User superUser) {
		//check if usperUser
		UserDaoImpl userDao = new UserDaoImpl();
		User test=null;
		if(superUser!=null){
			test = userDao.userLogin(superUser.getUsername(), superUser.getPassword());
		}
		else{
			return;
		}
		System.out.println(test);
		if(!test.getIsSuperUser().equals("T")){
			return;
		}
		else{
			
			for(User u : userDao.getUsers()){
				System.out.println(u);
			}
		}

	}
	
	

	@Override
	public void logout(User user) {
		user.setUserId(-1);
		user.setUsername("");
		user.setPassword("");
		user.setFname("");
		user.setLname("");
		user.setIsSuperUser("");
		user=null;
	}

	@Override
	public int createUser(User superUser, User user) {
		int usersCreated = 0;
		Connection con = null;
		UserDaoImpl userDao = new UserDaoImpl();
		if(userDao.isSuperUser(superUser)!=true)
			return 0;
		else{
			try{
				con = ConnectionUtil.getConnectionFromFile("connection.properties");
				con.setAutoCommit(false); //manual tx management
				String sql = "INSERT INTO USERACCOUNT(USERNAME,U_PASSWORD,FNAME,LNAME,ISSUPERUSER) "
						+ "VALUES (?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1,user.getUsername());
				pstmt.setString(2,user.getPassword());
				pstmt.setString(3,user.getFname());
				pstmt.setString(4,user.getLname());
				pstmt.setString(5,user.getIsSuperUser());
				usersCreated = pstmt.executeUpdate();
				con.commit();
				con.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return usersCreated;
		}
	}

	@Override
	public int deleteUser(User superUser, User user) {
		int usersDeleted = 0;
		Connection con = null;
		UserDaoImpl userDao = new UserDaoImpl();
		if(userDao.isSuperUser(superUser)!=true)
			return 0;
		else{
			try{
				
				con = ConnectionUtil.getConnectionFromFile("connection.properties");
				con.setAutoCommit(false); //manual tx management
				String sql = "DELETE USERACCOUNT WHERE USERNAME = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				
			
				pstmt.setString(1,user.getUsername());
				
				
				usersDeleted = pstmt.executeUpdate();
				
				con.commit();
				con.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return usersDeleted;
		}
	}

	@Override
	public int updateUser(User superUser, User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User registerUser(User user) {
		int userCreated=0;
		User userMade=null;
		UserDaoImpl userDao = new UserDaoImpl();
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			con.setAutoCommit(false); //manual tx management
			String sql = "INSERT INTO USERACCOUNT(USERNAME,U_PASSWORD,FNAME,LNAME,ISSUPERUSER) "
					+ "VALUES (?,?,?,?,?)";
			
			String isSuperUser="F";
			
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,user.getUsername());
			pstmt.setString(2,user.getPassword());
			pstmt.setString(3,user.getFname());
			pstmt.setString(4,user.getLname());
			pstmt.setString(5,isSuperUser);
			userCreated = pstmt.executeUpdate();
			
			userMade=userDao.userLogin(user.getUsername(), user.getPassword());
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userMade;
	}
	
	public boolean isSuperUser(User superUser){
		User test=null;
		if(superUser!=null){
			UserDaoImpl userDao= new UserDaoImpl();
			test = userDao.userLogin(superUser.getUsername(), superUser.getPassword());
		}
		else{
			return false;
		}
		if(!test.getIsSuperUser().equals("T")){
			return false;
		}
		else
			return true;
	}
}
