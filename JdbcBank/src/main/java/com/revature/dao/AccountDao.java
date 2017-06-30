package com.revature.dao;

import java.util.List;

import com.revature.domain.Account;

public interface AccountDao {

	public List<Account> getAccount();

	public Account getAccountById(int id);

	public int createAccount(Account account);
	
	public void deleteAccount(String user, int aNumber);
	
	public void deleteAll();

	public void withdraw(int accountId, int withdraw);

	public void deposit(int accountId, int deposit);
}
