package com.revature.bank.dao;

import java.util.List;

import com.revature.bank.domain.Account;

public interface AccountDao {
	public List<Account> getAccounts();
	public List<Account> getAccountByUserId(int userId);
	public int createAccount(int userId);
	public int deleteAccount(int userId, int id);
	public int deposite(int acc, Double amount);
	public int withdraw(int acc, Double amount);
}
