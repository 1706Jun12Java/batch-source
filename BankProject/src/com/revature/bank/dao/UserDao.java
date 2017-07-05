package com.revature.bank.dao;


import com.revature.bank.domain.User;
import com.revature.bank.exception.UniqueIDException;
import com.revature.bank.exception.WrongCredentialException;

public interface UserDao {

	public User getUserByCredential(String username, String password) throws WrongCredentialException;
	public int createUser(User user) throws UniqueIDException;
	
}
