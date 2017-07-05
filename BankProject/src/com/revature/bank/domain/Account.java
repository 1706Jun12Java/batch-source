package com.revature.bank.domain;

public class Account {
	
	private int acID;
	private int userID;
	private Number bal;
	
	
	public Account(int acID, int userID, Number bal) {
		super();
		this.acID = acID;
		this.userID = userID;
		this.bal = bal;
	}
	public int getAcID() {
		return acID;
	}
	public void setAcID(int acID) {
		this.acID = acID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public Number getBal() {
		return bal;
	}
	public void setBal(Number bal) {
		this.bal = bal;
	}
	@Override
	public String toString() {
		return "Account [acID=" + acID + ", userID=" + userID + ", bal=" + bal + "]";
	}

	
	
}
