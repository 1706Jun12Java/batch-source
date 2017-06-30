package com.revature.leibniz.bank.domain;

import java.io.Serializable;

/**
 * 
 * @author Leibniz Berihuete
 * Account, holds the balance of regular users, it includes:
 * accountID
 * balance
 * userID
 * 
 */
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8576974207747978380L;
	private int accountID;
	private double balance;
	private int userID;
	
	// DEFAULT CONSTRUCTOR
	public Account() {}
	
	// CONSTRUCTOR(int, double, int)
	public Account(int accountID, double balance, int userID) {
		this.accountID = accountID;
		this.balance = balance;
		this.userID = userID;
	}

	
	// ========== GETTERS =============//
	public int getAccountID() {
		return accountID;
	}

	public double getBalance() {
		return balance;
	}

	public int getUserID() {
		return userID;
	}

	
	// ============= SETTERS =============//
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	

}
