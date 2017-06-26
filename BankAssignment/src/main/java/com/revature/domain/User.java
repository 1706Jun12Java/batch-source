package com.revature.domain;

public class User {

	private int userID;
	private String userName;
	private boolean isSuper = false;

	public User(int userID, String userName, boolean isSuper) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.isSuper = isSuper;
	}
	public User(String userName, boolean isSuper) {
		super();
		this.userName = userName;
		this.isSuper = isSuper;
	}
	
	public User() {

	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public boolean isSuper() {
		return isSuper;
	}
	public void setSuper(boolean isSuper) {
		this.isSuper = isSuper;
	}
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", isSuper=" + isSuper + "]";
	}

}
