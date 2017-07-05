package com.chase.domain;

public class BankAccount {

	private int baid;
	private double currentBalance;
	
	public BankAccount(int id, double currentBalance) {
		super();
		this.baid = id;
		this.currentBalance = currentBalance;
	}

	public BankAccount(double currentBalance) {
		super();
		this.currentBalance = currentBalance;
	}

	public BankAccount() {
		super();
	}

	@Override
	public String toString() {
		return ""+currentBalance +"";
	}

	public int getId() {
		return baid;
	}

	public void setId(int id) {
		this.baid = id;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
}
