package com.revature.leibniz.bankAccountAssignment;

import java.util.ArrayList;

public interface UserDao {
	public ArrayList<User> getAllUsers();
	public User getUser(int userID);
	public void deleteUser(int userID);
	
}
