package com.revature.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.revature.Exceptions.InvalidAccountException;
import com.revature.Exceptions.InvalidPasswordException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.Util.ConnectionUtil;
import com.revature.domain.User;

public class UserImpl implements UserDao {

	public UserImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean createUser(String userName, String password) throws InvalidUsernameException, InvalidPasswordException {
		boolean success = false;
		if(userName.length() > 32 || userName.length() <= 0){
			throw new InvalidUsernameException("Username is invalid");
		}
		if(password.length() > 32 || password.length() <=0 ){
			throw new InvalidPasswordException("Password is invalid");
		}
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql = "SELECT * FROM \"USER\" WHERE USERNAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			userName = userName.toUpperCase();
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if(!rs.next()){
				sql = "INSERT INTO \"USER\" (USERNAME,\"password\",SUPER) VALUES (?,?,DEFAULT)";
				ps = con.prepareStatement(sql);
				ps.setString(1, userName);
				ps.setString(2, password);
				int i = ps.executeUpdate();
				if(i > 0){
					success = true;
				}
			} else{
				throw new InvalidUsernameException("Username is taken.");
			}			
		}catch(SQLException e){
			e.printStackTrace();
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
			String sql = "SELECT * FROM \"USER\" WHERE USERNAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			userName = userName.toUpperCase();
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				sql = "DELETE FROM \"USER\" WHERE USERNAME = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, userName);
				int i = ps.executeUpdate();
				if(i > 0){
					success = true;
				} 
			} else {
				throw new InvalidUsernameException("User not found");
			}			
		}catch(SQLException e){
			e.printStackTrace();
		} 
		return success;
	}

	@Override
	public boolean updateUser(String userName,String newName,String newPass,int setSuper) throws InvalidUsernameException, InvalidPasswordException {
		boolean success = false;
		if(userName.length() > 32 || userName.length() <= 0 || userName.equalsIgnoreCase("JOHNCENA")){
			throw new InvalidUsernameException("Username is invalid");
		}
		if(newName.length() > 32 || newName.length() <= 0){
			throw new InvalidUsernameException("New Username is invalid");
		}
		if(newPass.length() > 32 || newPass.length() <=0 ){
			throw new InvalidPasswordException("Password is invalid");
		}
	try{
		Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
		String sql = "SELECT * FROM \"USER\" WHERE USERNAME = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		userName = userName.toUpperCase();
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			int userID = rs.getInt("USER_ID");
			sql = "{call UPDATE_USER(?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			newName = newName.toUpperCase();
			cs.setInt(1,userID);
			cs.setString(2, newName);
			cs.setString(3, newPass);
			cs.setInt(4, setSuper);
			cs.execute();
			success = true;
		} else {
			throw new InvalidUsernameException("User Does Not Exist"); 
		}
	}catch(SQLException e){
		e.printStackTrace();
	} 
	return success;
	}
	
	@Override
	public List<User> getAllUsers() throws InvalidAccountException {
		ArrayList<User> users = new ArrayList();
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql = "SELECT * FROM \"USER\"";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				int userID = rs.getInt("USER_ID");
				String userName = rs.getString("USERNAME");
				int isSuper = rs.getInt("SUPER");
				User user;
				if(isSuper == 0){
					user = new User (userID,userName,false);
					users.add(user);
				} else{
					user = new User (userID,userName,true);
					users.add(user);
				}	
			}
			if(users.isEmpty()){
					throw new InvalidAccountException("No users registered");
			}	
		}catch(SQLException e){
			e.printStackTrace();
		} 
		return users;
	}
	
	@Override
	public User logIn(String userName, String password) throws InvalidUsernameException, InvalidPasswordException {
		if(userName.length() > 32 || userName.length() <= 0){
			throw new InvalidUsernameException("Username is invalid");
		}
		if(password.length() > 32 || password.length() <=0 ){
			throw new InvalidPasswordException("Password is invalid");
		}
		User user = null;
		userName = userName.toUpperCase();
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql = "SELECT * FROM \"USER\" WHERE USERNAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int userID = rs.getInt("USER_ID");
				String uName = rs.getString("USERNAME");
				String pass = rs.getString("password");
				int isSuper = rs.getInt("SUPER");
				if(password.equals(pass)){
					if(isSuper == 0){
						user = new User (userID,userName,false);
					} else{
						user = new User (userID,userName,true);
					}	
				} else{
					throw new InvalidPasswordException("Password incorrect");
				}
			} else {
				throw new InvalidUsernameException("User Does Not Exist"); 
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}

	public User superlogIn() throws InvalidUsernameException, InvalidPasswordException {
		User user = null;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			Properties prop = new Properties();	
			InputStream is = new FileInputStream("Connection.properties");
			prop.load(is);
			String userName  = prop.getProperty("superusername");
			String password = prop.getProperty("superpassword");
			String sql = "SELECT * FROM \"USER\" WHERE USERNAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int userID = rs.getInt("USER_ID");
				String uName = rs.getString("USERNAME");
				String pass = rs.getString("password");
				int isSuper = rs.getInt("SUPER");
				if(password.equals(pass)){
					if(isSuper == 0){
						user = new User (userID,userName,false);
					} else{
						user = new User (userID,userName,true);
					}	
				} else{
					throw new InvalidPasswordException("Password incorrect");
				}
			} else {
				throw new InvalidUsernameException("User Does Not Exist"); 
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	@Override
	public User getUser(int ID) throws InvalidUsernameException {
		User user = null;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql = "SELECT * FROM \"USER\" WHERE USER_ID = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int userID = rs.getInt("USER_ID");
				String userName = rs.getString("USERNAME");
				int isSuper = rs.getInt("SUPER");
				if(isSuper == 0){
					user = new User (userID,userName,false);
				} else{
					user = new User (userID,userName,true);
				}	
			} else {
				throw new InvalidUsernameException("User does not exist");
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		} 
		return user;
	}

	@Override
	public User getUserByName(String ID) throws InvalidUsernameException {
		User user = null;
		try{
			Connection con = ConnectionUtil.getConnectionFromFile("Connection.properties");
			String sql = "SELECT * FROM \"USER\" WHERE USERNAME = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ID = ID.toUpperCase();
			ps.setString(1, ID);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int userID = rs.getInt("USER_ID");
				String userName = rs.getString("USERNAME");
				int isSuper = rs.getInt("SUPER");
				if(isSuper == 0){
					user = new User (userID,userName,false);
				} else{
					user = new User (userID,userName,true);
				}	
			} else {
				throw new InvalidUsernameException("User does not exist");
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		} 
		return user;
	}
}
