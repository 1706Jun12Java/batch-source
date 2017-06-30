package com.revature.dao;

import java.util.List;

import com.revature.domain.Transaction;

public interface TransactionDao {
	public List<Transaction> getTransactions(int acID);
}
