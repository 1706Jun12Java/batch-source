package com.bank.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.bank.domain.Account;

public interface AccountDao {
	
	public List<Account> getAccounts() throws SQLException, IOException;
	public Account getAccountById(int id);	
	public int createAccount() throws IOException;
	public int deleteAccount() throws IOException;
	public int addToAccount(int accId);
	public int withDrawFromAccount(int accId);
}
