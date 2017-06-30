package com.revature.domain;

public class Account {
	private int accountID;
	private String accountType;
	private double balance;
	private User accountOwner;
	
	public Account(int accountID, String accountType, double balance, User accountOwner) {
		super();
		this.accountID = accountID;
		this.accountType = accountType;
		this.balance = balance;
		this.accountOwner = accountOwner;
	}
	
	public Account(String accountType, double balance, User accountOwner) {
		super();
		this.accountType = accountType;
		this.balance = balance;
		this.accountOwner = accountOwner;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(User accountOwner) {
		this.accountOwner = accountOwner;
	}

	@Override
	public String toString() {
		return "Account ID:" + accountID + "     Account Type:" + accountType + "    balance:" + balance;
	}

}
