package com.revature.bank.dao;

import java.util.List;

import com.revature.bank.domain.Transaction;

public interface TransactionDao {
	public List<Transaction> getTransactions(int acID);
}
