package com.jdbcbank.domain;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

import com.jdbcbank.dao.*;

public class Transaction {

	public void addTransactionToDB() throws SQLException, IOException{
		TransactionDao td = new TransactionDaoImpl();
		td.addTransaction(this); 
	}
	
	
	public Transaction(int transaction_id, int account_id, String transaction_type, float transaction_amt,
			LocalDate transaction_date) {
		super();
		this.transaction_id = transaction_id;
		this.account_id = account_id;
		this.transaction_type = transaction_type;
		this.transaction_amt = transaction_amt;
		this.transaction_date = transaction_date;
	}
	
	public Transaction(int account_id, String transaction_type, float transaction_amt, LocalDate today) {
		 this(0,account_id, transaction_type,transaction_amt,today);
	}
	

	private int transaction_id;
	private int account_id;
	private String transaction_type;
	private float transaction_amt;
	private LocalDate transaction_date;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transaction_id + ", account_id=" + account_id + ", transaction_type="
				+ transaction_type + ", transaction_amt=" + transaction_amt + ", transaction_date=" + transaction_date
				+ "]";
	}

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public float getTransaction_amt() {
		return transaction_amt;
	}

	public void setTransaction_amt(float transaction_amt) {
		this.transaction_amt = transaction_amt;
	}

	public LocalDate getTransaction_date() {
		return transaction_date;
	}

	public void setTransaction_date(LocalDate transaction_date) {
		this.transaction_date = transaction_date;
	}

}