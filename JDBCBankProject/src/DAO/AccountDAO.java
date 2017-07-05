package DAO;

import java.util.List;

import Domain.Account;

public interface AccountDAO {
	public List<Account> getAccounts(String username);

	public boolean withdraw(int ID, double amount);

	public boolean withdraw(int ID, double amount, String username);

	public boolean deposit(int ID, double amount);

	public boolean deposit(int ID, double amount, String username);

	public boolean createAccount(String username);

	public boolean deleteAccount(int ID, String username);

	boolean deleteAccount(int ID);

	List<Account> getAccounts();

}
