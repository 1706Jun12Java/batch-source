package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.revature.Exceptions.InvalidPasswordException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.Util.ConnectionUtil;
import com.revature.domain.E_User;

public class E_UserImpl implements E_USERSDAO {

	public E_UserImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean createUser(String userName, String password,String firstName,String lastName,String email, int isManager)
			throws InvalidUsernameException, InvalidPasswordException, SQLException {
		boolean success = false;
		if(userName.length() > 32 || userName.length() <= 0){
			throw new InvalidUsernameException("Username is invalid");
		}
		if(password.length() > 32 || password.length() <=0 ){
			throw new InvalidPasswordException("Password is invalid");
		}
		Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			userName = userName.toUpperCase();
			String sql;
			PreparedStatement ps;
			sql = "INSERT INTO E_USERS (USER_NAME,USER_PASS,FIRST_NAME,SECOND_NAME,EMAIL,USER_ROLE) VALUES (?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1,userName);
			ps.setString(2, password);
			ps.setString(3, firstName);
			ps.setString(4, lastName);
			ps.setString(5, email);
			ps.setInt(6, isManager);
			int i = ps.executeUpdate();
			if(i > 0){
				success = true;
			}	
		return success;
	}

	@Override
	public boolean deleteUser(String userName) throws InvalidUsernameException {
		boolean success = false;
		if(userName.length() > 32 || userName.length() <= 0 || userName.equalsIgnoreCase("JOHNCENA")){
			throw new InvalidUsernameException("Username is invalid");
		}
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql = "SELECT * FROM E_USERS WHERE USER_NAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			userName = userName.toUpperCase();
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			try{
			if(rs.next()){
				sql = "DELETE FROM E_USERS WHERE USER_NAME = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, userName);
				int i = ps.executeUpdate();
				if(i > 0){
					success = true;
				} 
			} else {
				throw new InvalidUsernameException("User not found");
			}}finally{
				try { rs.close(); } catch (Exception ignore) { }
			}			
		}catch(SQLException e){
			e.printStackTrace();
		} 
		return success;
		
	}

	@Override
	public List<E_User> getAllUsers() throws InvalidUsernameException {
		ArrayList<E_User> users = new ArrayList();
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql = "SELECT * FROM E_USERS";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			try{
			while(rs.next()){
				int userID = rs.getInt("USER_ID");
				String userName = rs.getString("USER_NAME");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("SECOND_NAME");
				String email = rs.getString("EMAIL");
				int isManager = rs.getInt("USER_ROLE");
				E_User user = new E_User(userID,userName,firstName,lastName,email,isManager);
				users.add(user);
			}
			if(users.isEmpty()){
					throw new InvalidUsernameException("No users registered");
			}}finally{
				try { rs.close(); } catch (Exception ignore) { }
			}	
		}catch(SQLException e){
			e.printStackTrace();
		} 
		return users;
	}

	@Override
	public E_User getUser(int ID) throws InvalidUsernameException {
		// TODO Auto-generated method stub
		//check for -1 if no user set
		if(ID <= 0){
			return null;
		}
		E_User user = null;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql = "SELECT * FROM E_USERS WHERE USER_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			try{
			if(rs.next()){
				int userID = rs.getInt("USER_ID");
				String userName = rs.getString("USER_NAME");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("SECOND_NAME");
				String email = rs.getString("EMAIL");
				int isManager = rs.getInt("USER_ROLE");
				user = new E_User(userID,userName,firstName,lastName,email,isManager);
			}else{
				throw new InvalidUsernameException("User not found");
			}}finally{
				try { rs.close(); } catch (Exception ignore) { }
			}
		}catch(SQLException e){
			e.printStackTrace();
		} 
		return user;
	}

	@Override
	public E_User logIn(String userName, String password) throws InvalidUsernameException, InvalidPasswordException {
		if(userName == null || userName.length() > 32 || userName.length() <= 0){
			throw new InvalidUsernameException("Username is invalid");
		}
		if(password == null || password.length() > 32 || password.length() <=0){
			throw new InvalidPasswordException("Password is invalid");
		}
		E_User user = null;
		userName = userName.toUpperCase();
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql = "SELECT * FROM E_USERS WHERE USER_NAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			try{
			if(rs.next()){
				int userID = rs.getInt("USER_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("SECOND_NAME");
				String pass = rs.getString("USER_PASS");
				String email = rs.getString("EMAIL");
				int isManager = rs.getInt("USER_ROLE");
				if(password.equals(pass)){
					user = new E_User(userID,userName,firstName,lastName,email,isManager);
				} else{
					throw new InvalidPasswordException("Password incorrect");
				}
			} else {
				throw new InvalidUsernameException("User Does Not Exist"); 
			}}finally{
				try { rs.close(); } catch (Exception ignore) { }
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean updateUser(String userName, String firstName,String lastName,String email)
			throws InvalidUsernameException, InvalidPasswordException {
		boolean success = false;
		if(userName.length() > 32 || userName.length() <= 0 || userName.equalsIgnoreCase("JOHNCENA")){
			throw new InvalidUsernameException("Username is invalid");
		}
	try{
		Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
		String sql = "SELECT * FROM E_USERS WHERE USER_NAME = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		userName = userName.toUpperCase();
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
		try{
		if(rs.next()){
			sql = "{call E_USER_UPDATE(?,?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1,userName);
			cs.setString(2, firstName);
			cs.setString(3, lastName);
			cs.setString(4, email);
			cs.registerOutParameter(5, java.sql.Types.INTEGER);	
			cs.execute();
			int i = cs.getInt(5);
			if(i == 1){
				success = true;
			} else {
				throw new InvalidUsernameException("Update has failed");
			}
		} else {
			throw new InvalidUsernameException("User Does Not Exist"); 
		}}finally{
			try { rs.close(); } catch (Exception ignore) { }
		}
	}catch(SQLException e){
		e.printStackTrace();
	} 
	return success;
	}
	
	@Override
	public E_User getUserByName(String ID) throws InvalidUsernameException {
		E_User user = null;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql = "SELECT * FROM E_USERS WHERE USER_NAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ID);
			ResultSet rs = ps.executeQuery();
			try{
			if(rs.next()){
				int userID = rs.getInt("USER_ID");
				String userName = rs.getString("USER_NAME");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("SECOND_NAME");
				String email = rs.getString("EMAIL");
				int isManager = rs.getInt("USER_ROLE");
				user = new E_User(userID,userName,firstName,lastName,email,isManager);
			}else {
				throw new InvalidUsernameException("No user found");
			}
			}finally{
				try { rs.close(); } catch (Exception ignore) { }
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
			
		return user;
	}

	@Override
	public boolean updateUserPass(String userName, String oldPass, String newPass)
			throws InvalidUsernameException, InvalidPasswordException {
		boolean success = false;
		if(newPass.length() > 32 || newPass.length() <= 0){
			throw new InvalidPasswordException("New Password is invalid");
		}
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql = "SELECT * FROM E_USERS WHERE USER_NAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			userName = userName.toUpperCase();
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			try{
			if(rs.next()){
				if(rs.getString("USER_PASS").equals(oldPass)){
				sql = "{call E_USER_PASS_UPDATE(?,?,?)}";
				CallableStatement cs = con.prepareCall(sql);
				cs.setString(1,userName);
				cs.setString(2, newPass);
				cs.registerOutParameter(3, java.sql.Types.INTEGER);	
				cs.execute();
				int i = cs.getInt(3);
				if(i == 1){
					success = true;
				} else {
					throw new InvalidUsernameException("Update has failed");
				}
			} else {
				throw new InvalidPasswordException("Incorrect Current Password");
				
			}
			}else {
				throw new InvalidUsernameException("User Does Not Exist"); 
			}
			}finally{
				try { rs.close(); } catch (Exception ignore) { }
			}
		}catch(SQLException e){
			e.printStackTrace();
		} 
		return success;
	}

}
