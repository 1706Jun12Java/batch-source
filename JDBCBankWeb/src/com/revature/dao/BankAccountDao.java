package com.revature.dao;

import java.math.BigDecimal;
import java.util.List;

import com.revature.domain.BankAccount;

public interface BankAccountDao {
	public List<BankAccount> getBankAccountList(int userId); //get the user's list of bank accounts
	public int getBankAccountBalance(int userId, int bankAccountId);
	public void createBankAccount(int userId);
	public int deposit(int userId, int bankAccountId, BigDecimal amount);
	public int withdraw(int userId, int bankAccountId, BigDecimal amount);
	public int deleteBankAccount(int userId, int bankAccountId);	

}
