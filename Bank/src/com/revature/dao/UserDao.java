package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

	public interface UserDao {
	public List<User> getUsers();
	public User getUserById(int id);
	public User userLogin(String username, String pass);
	public int createUser(User superUser, User user);
	
	/*
	 * Must delete bank accounts associated with user first
	 * Then we can delete it in ht User_Bank table
	 * then delete user
	 */
	public int deleteUser(User superUser,User user);
	public void viewUsers(User superUser);
	public User registerUser(User user);
	public int updateUser(User superUser,User user);
	public void logout(User user);
	
}
