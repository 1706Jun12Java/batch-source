package com.revature.dao;

import java.util.List;

import com.revature.domain.BankUser;

public interface BankUserDao {
	public int registerNewBankUser(String username, String password);
	public int login(String username, String password);
	public List<BankUser> getUsers();
	public int isOnline();
	public void logout();

}
