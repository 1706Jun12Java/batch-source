package com.jdbcbank.domain;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import com.jdbcbank.dao.*;

public  class SuperUser {

	private static final String super_username = "SUPER";
	private static final String super_password = "SUPER";
	
	public SuperUser() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean isSuperUser(User u){
		return SuperUser.super_username.equals(u.getUser_username()) && SuperUser.super_password.equals(u.getUser_password());
	}
	
	public List<User> getUsers() throws SQLException, IOException{
		UserDao ud = new UserDaoImpl(); 
		return ud.getUsers();
	}

	public void createUser(User u) throws SQLException, IOException{
		u.createUserToDB();
	}
	
	public void updateUser(User u) throws SQLException, IOException{
		u.updateUserToDB();
	}
	
	public void deleteUser(User u) throws SQLException, IOException{
		u.deleteUserFromDB();
	}
}
