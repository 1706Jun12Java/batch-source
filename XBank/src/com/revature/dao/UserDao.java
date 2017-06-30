package com.revature.dao;

import com.revature.domain.User;

public interface UserDao {
	public User getUserByCredential(String username, String password) throws WrongCredentialException;
	public int createUser(User user);
}
