package com.revature.domain;

public class Account {

	private int balance;
	private int id;
	private int withdraw;
	public int getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}

	public int getDeposit() {
		return deposit;
	}

	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	private int deposit;
	
	public Account(int id, int balance,int withdraw,int deposit) {
		super();
		this.id = id;
		this.balance = balance;
		this.withdraw = withdraw;
		this.deposit = deposit;
	}
	
	public Account() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Account id: " + id + ", balance: " + balance + ", withdraws: " + withdraw + ", deposit: " + deposit;
	}
}