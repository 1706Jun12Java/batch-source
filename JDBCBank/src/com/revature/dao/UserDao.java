package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

	public interface UserDao {
	public List<User> getUsers();
	public User getUserById(int id);
	public User userLogin(String username, String pass);
	public int createUser(User superUser);
	
	/*
	 * Must delete bank accounts associated with user first
	 * Then we can delete it in ht User_Bank table
	 * then delete user
	 */
	public int deleteUser(User superUser);
	public void viewUsers(User superUser);
	public User registerUser();
	public int updateUser(User superUser);
	public void logout(User user);
	
}
