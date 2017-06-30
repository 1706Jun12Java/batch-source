package com.revature.dao;

import java.util.List;

import com.revature.domain.Account;

public interface AccountDao {

	public void insertAccount();
	public List<Account> getAccounts();
	
}
