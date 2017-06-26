package com.revature.domain;

public class Account {

	private int balance;
	private int id;
	
	public Account(int id, int balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	
	public Account() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Account id: " + id + ", balance: " + balance ;
	}
}