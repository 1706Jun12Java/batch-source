package com.revature.bank.domain;

public class Account {
	private int ac_id;
	private int user_id;
	private Number bal;
	
	
	public Account(int ac_id, int user_id, Number bal) {
		super();
		this.ac_id = ac_id;
		this.user_id = user_id;
		this.bal = bal;
	}
	
	public Account(int user_id, Number bal) {
		super();
		this.user_id = user_id;
		this.bal = bal;
	}
	
	
	public int getAc_id() {
		return ac_id;
	}
	public void setAc_id(int ac_id) {
		this.ac_id = ac_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public Number getBal() {
		return bal;
	}
	public void setBal(Number bal) {
		this.bal = bal;
	}

	@Override
	public String toString() {
		return "Account [ac_id=" + ac_id + ", user_id=" + user_id + ", bal=" + bal + "]";
	}
	
	
	
}
