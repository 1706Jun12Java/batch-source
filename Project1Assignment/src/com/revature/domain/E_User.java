package com.revature.domain;

public class E_User {
		private int userID;
		private String userName;
		private String firstName;
		private String lastName;
		private String email;
		private int managerStatus;
		
		public E_User(int userID, String userName, String firstName, String lastName, String email, int isManager) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.managerStatus = isManager;
	}
		
		public E_User(String userName, String firstName, String lastName, String email, int isManager) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.managerStatus = isManager;
	}
		
	public E_User() {
		// TODO Auto-generated constructor stub
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIsManager() {
		return managerStatus;
	}
	public void setIsManager(int isManager) {
		this.managerStatus = isManager;
	}
	public boolean isManager(){
		if(this.managerStatus == 0){
			return false;
		}
		return true;
	}
	@Override
	public String toString() {
		return "E_Users [userID=" + userID + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", isManager=" + managerStatus + "]";
	}
	
}
