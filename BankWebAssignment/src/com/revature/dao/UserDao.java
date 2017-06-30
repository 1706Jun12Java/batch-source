package com.revature.dao;

import java.util.List;

import com.revature.Exceptions.InvalidAccountException;
import com.revature.Exceptions.InvalidPasswordException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.domain.User;

public interface UserDao {
	public boolean createUser(String userName, String password) throws InvalidUsernameException, InvalidPasswordException;
	public boolean deleteUser(String userName) throws InvalidUsernameException;
	public List<User> getAllUsers() throws InvalidAccountException;
	public User getUser(int ID) throws InvalidUsernameException;
	public User logIn(String userName, String password) throws InvalidUsernameException, InvalidPasswordException;
	boolean updateUser(String userName, String newName, String newPass, int setSuper) throws InvalidUsernameException, InvalidPasswordException;
	User getUserByName(String ID) throws InvalidUsernameException;
	public User superlogIn() throws InvalidUsernameException, InvalidPasswordException;
}
