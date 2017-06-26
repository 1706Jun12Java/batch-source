package com.jdbcbank.domain;

public class Account {

	public Account(int account_id, int user_id, float balance) {
		super(); 
		this.account_id = account_id;
		this.user_id = user_id;
		this.balance = balance;
	}

	private int account_id;
	private int user_id;
	private float balance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Account [account_id=" + account_id + ", user_id=" + user_id + ", balance=" + balance + "]";
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

}
