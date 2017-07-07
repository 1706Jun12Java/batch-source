package com.jdbcbank.domain;

import java.util.List;

public class TransactionBalance {
	public TransactionBalance(float balance, List<Transaction> listTransaction) {
		super();
		this.balance = balance;
		this.listTransaction = listTransaction;
	}
	
	public float balance;
	public List<Transaction> listTransaction;
	 
}

