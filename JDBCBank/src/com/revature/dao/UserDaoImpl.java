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
	public int createUser(User superUser) {
		int usersCreated = 0;
		Connection con = null;
		UserDaoImpl userDao = new UserDaoImpl();
		User test=null;
		if(superUser!=null){
			test = userDao.userLogin(superUser.getUsername(), superUser.getPassword());
		}
		else{
			return 0;
		}
		System.out.println(test);
		if(!test.getIsSuperUser().equals("T")){
			return 0;
		}
		else{
			try{
				con = ConnectionUtil.getConnectionFromFile("connection.properties");
				con.setAutoCommit(false); //manual tx management
				String sql = "INSERT INTO USERACCOUNT(USERNAME,U_PASSWORD,FNAME,LNAME,ISSUPERUSER) "
						+ "VALUES (?,?,?,?,?)";
				
				Scanner scan = new Scanner(System.in);
				
				
				String username=scan.nextLine();
				String password=scan.nextLine();
				String fname=scan.nextLine();
				String lname=scan.nextLine();
				String isSuperUser=scan.nextLine();
				
				
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1,username);
				pstmt.setString(2,password);
				pstmt.setString(3,fname);
				pstmt.setString(4,lname);
				pstmt.setString(5,isSuperUser);
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
	public int deleteUser(User superUser) {
		UserDaoImpl userDao = new UserDaoImpl();
		User test=null;
		if(superUser!=null){
			test = userDao.userLogin(superUser.getUsername(), superUser.getPassword());
		}
		else{
			return 0;
		}
		System.out.println(test);
		if(!test.getIsSuperUser().equals("T")){
			return 0;
		}
		else{
			int usersDeleted = 0;
			Connection con = null;
			try{
				con = ConnectionUtil.getConnectionFromFile("connection.properties");
				con.setAutoCommit(false); //manual tx management
				String sql = "DELETE USERACCOUNT WHERE USERNAME = ?";
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter username of account to be deleted");
				
				String username=scan.nextLine();
				pstmt.setString(1,username);
				
				
				usersDeleted = pstmt.executeUpdate();
				con.commit();
				con.setAutoCommit(true);
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				try {
					con.rollback();
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return usersDeleted;
		}
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
	public User registerUser() {
		int userCreated=0;
		User user=null;
		UserDaoImpl userDao = new UserDaoImpl();
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			con.setAutoCommit(false); //manual tx management
			String sql = "INSERT INTO USERACCOUNT(USERNAME,U_PASSWORD,FNAME,LNAME,ISSUPERUSER) "
					+ "VALUES (?,?,?,?,?)";
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter username: ");
			String username=scan.nextLine();

			System.out.println("Enter password: ");
			String password=scan.nextLine();

			System.out.println("Enter first name: ");
			String fname=scan.nextLine();

			System.out.println("Enter last name: ");
			String lname=scan.nextLine();
			String isSuperUser="F";
			
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2,password);
			pstmt.setString(3,fname);
			pstmt.setString(4,lname);
			pstmt.setString(5,isSuperUser);
			userCreated = pstmt.executeUpdate();
			user=userDao.userLogin(username, password);
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
		return user;
	}

	public int updateUser(User superUser){
		UserDaoImpl userDao = new UserDaoImpl();
		User test=null;
		if(superUser!=null){
			test = userDao.userLogin(superUser.getUsername(), superUser.getPassword());
		}
		else{
			return 0;
		}
		System.out.println(test);
		if(!test.getIsSuperUser().equals("T")){
			return 0;
		}
		
		int updated=0;
		Connection con = null;
		try{
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			con.setAutoCommit(false); //manual tx management
			String sql = "UPDATE USERACCOUNT "
					+ "SET "
					+ "U_PASSWORD=?,"
					+ "FNAME=?,"
					+ "LNAME=?,"
					+ "ISSUPERUSER=? "
					+ "WHERE USERNAME =?";
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter username of the user you wish to change: ");
			String username=scan.nextLine();

			System.out.println("Enter  NEW password: ");
			String password=scan.nextLine();

			System.out.println("Enter NEW first name: ");
			String fname=scan.nextLine();

			System.out.println("Enter NEW last name: ");
			String lname=scan.nextLine();
			
			System.out.println("Enter T is you wish to change user into a superUser");
			String isSuperUser=scan.nextLine();
			if(!isSuperUser.equals("T"))
				isSuperUser="F";
			
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,password);
			pstmt.setString(2,fname);
			pstmt.setString(3,lname);
			pstmt.setString(4,isSuperUser);
			
			pstmt.setString(5,username);
			
			
			updated = pstmt.executeUpdate();
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
		return updated;
	}

	@Override
	public void logout(User user) {
		User test=new User();
		user = test;
	}
}
