package com.revature.dao;

import java.util.List;

import com.revature.domain.Users;
import com.revature.domain.Account;

public interface UsersDao {

	public List<Users> getUsers();

	public Users getUsersById(int id);

	public void createUsers(String user, String password);

	public void createAccount(String user);

	public void deleteAccount(String user, int aNumber);

	public List<Account> getAllBalances(String user);

	public void withdraw(String user, int accountId, int withdraw);

	public void deposit(String user, int accountId, int deposit);
}
