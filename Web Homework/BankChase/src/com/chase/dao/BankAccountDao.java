package com.chase.dao;

import com.chase.domain.BankAccount;

public interface BankAccountDao {

	public static BankAccount getBankAccountbyId(int id) {
		return null;
	}
	public static void withdraw(int userId,int bankAccountId,int amount) {
	}
	public static void deposit(int userId,int bankAccountId,int amount) {
	}
	public static void createBankAccount(double amount) {
	}
}
