package com.revature.bank.dao;


import com.revature.bank.domain.User;

public interface UserDao {
	public User getUserByCredential(String username, String password) throws WrongCredentialException;
	public int createUser(User user) throws UniqueConstraintException;
}
