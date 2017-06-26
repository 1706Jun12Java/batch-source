package com.revature.domain;

public class TransLog {
	private int logID;
	private Account accountID;
	private double update;
	private User owner;
	
	public TransLog(int logID, Account accountID, double update,User owner) {
		super();
		this.logID = logID;
		this.accountID = accountID;
		this.update = update;
		this.owner = owner;
	}
	public TransLog(Account accountID, double update,User owner) {
		super();
		this.accountID = accountID;
		this.update = update;
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Transaction ID:" + logID + "  Account Number: " +accountID.getAccountID() + "   Account Type: "+ accountID.getAccountType() + "    Balance Change: " + update;
	}

	public int getLogID() {
		return logID;
	}

	public void setLogID(int logID) {
		this.logID = logID;
	}

	public Account getAccountID() {
		return accountID;
	}

	public void setAccountID(Account accountID) {
		this.accountID = accountID;
	}

	public double getUpdate() {
		return update;
	}

	public void setUpdate(double update) {
		this.update = update;
	}

	public TransLog() {
			
	}

}
