package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.Exceptions.InvalidReimburstmentException;
import com.revature.Exceptions.InvalidPasswordException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.domain.E_User;

public interface E_USERSDAO {
	public boolean deleteUser(String userName) throws InvalidUsernameException;
	public List<E_User> getAllUsers() throws InvalidUsernameException;
	public E_User getUser(int ID) throws InvalidUsernameException;
	public E_User logIn(String userName, String password) throws InvalidUsernameException, InvalidPasswordException;
	E_User getUserByName(String ID) throws InvalidUsernameException;
	boolean createUser(String userName, String password, String firstName, String lastName, String email, int isManager)
			throws InvalidUsernameException, InvalidPasswordException, SQLException;
	boolean updateUser(String userName, String firstName, String lastName, String email)
			throws InvalidUsernameException, InvalidPasswordException;
	boolean updateUserPass(String userName, String oldPass, String newPass)
			throws InvalidUsernameException, InvalidPasswordException;
}
