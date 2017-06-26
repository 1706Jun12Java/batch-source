package com.revature.dao;

import java.util.List;

import com.revature.Exceptions.InvalidAccountException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.Exceptions.OverDraftException;
import com.revature.domain.Account;
import com.revature.domain.User;

public interface AccountDao {
	public boolean createAccount(int accountType, User owner);
	public Account getAccount(int ID) throws InvalidUsernameException, InvalidAccountException;
	public List<Account> getAllAccountsByUser(User owner) throws InvalidUsernameException, InvalidAccountException;
	boolean deleteAccount(int accountID, User owner) throws InvalidAccountException;
	boolean updateAccount(int accountNum, double value, User owner) throws InvalidAccountException, OverDraftException;
}
