package com.revature.leibniz.bankAccountAssignment;


/**
 * 
 * @author Leibniz Berihuete
 * This account class will contain the accountNumber and balance of a user,
 * the userID will be included as a foreign key
 */
public class Account {
	private int accountID;
	private int userID;
	private double balance;
	
	
	// CONSTRUCTOR(int, String, double)
	public Account(int accountID, int userID, double balance) {
		this.accountID = accountID;
		this.userID = userID;
		this.balance = balance;
	}

	// ============ GETTERS ================//
	public int getAccountID() {
		return accountID;
	}
	
	public int getUserID() {
		return userID;
	}

	public double getBalance() {
		return balance;
	}

	
	//============= SETTERS =================//
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}
