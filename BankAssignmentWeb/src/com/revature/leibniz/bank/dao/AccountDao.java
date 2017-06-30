package com.revature.leibniz.bank.dao;

import java.util.List;

import com.revature.leibniz.bank.domain.Account;

/**
 * 
 * @author Leibniz Berihuete
 * Account Dao
 */
public interface AccountDao {
	public List<Account> getAccounts();
	public Account getAccountByID(int id);
	public int createAccount(Account account);
}
