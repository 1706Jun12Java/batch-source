package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface BankAccountDao {
		public List<BankAccount> getBankAccounts();
		public List<BankAccount> getBankAccountsByUser(User user);
		public BankAccount getBankAccountById(int id);
		public int createBankAccount(User creator);
		public int withdrawFromBank(User creator,int bankId,int amount);
		public int depositToBank(User creator,int bankId,int amount);
}
