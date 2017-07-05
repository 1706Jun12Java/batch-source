package com.revature.bank.domain;

public class SuperUser extends User{
	public SuperUser(int userID, String username, String password, int userType) {
		super(userID, username, password, 1);
	}
}
