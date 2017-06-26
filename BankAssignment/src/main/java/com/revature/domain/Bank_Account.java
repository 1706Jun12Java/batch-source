package com.revature.domain;

public class Bank_Account {
	
	public Bank_Account(int bank_account_id, float balance, int account_user_id) {
		super();
		this.bank_account_id = bank_account_id;
		this.balance = balance;
		this.account_user_id = account_user_id;
	}

	private int bank_account_id; 
	private float balance; 
	private int account_user_id;

	public Bank_Account() {
		
	}

	public int getBank_account_id() {
		return bank_account_id;
	}

	public void setBank_account_id(int bank_account_id) {
		this.bank_account_id = bank_account_id;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getAccount_user_id() {
		return account_user_id;
	}

	public void setAccount_user_id(int account_user_id) {
		this.account_user_id = account_user_id;
	}

	@Override
	public String toString() {
		return "Bank_Account [bank_account_id=" + bank_account_id + ", balance=" + balance + ", account_user_id="
				+ account_user_id + "]";
	}

}
