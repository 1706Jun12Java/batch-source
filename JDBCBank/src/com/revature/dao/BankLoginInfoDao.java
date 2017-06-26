package com.revature.dao;

import java.util.List;

import com.revature.domain.BankLoginInfo;

public interface BankLoginInfoDao {
	public int registerNewBankUser(String username, String password);
	public int login(String username, String password);
	public List<BankLoginInfo> getUsers();
	public int isOnline();
	public void logout();

}
