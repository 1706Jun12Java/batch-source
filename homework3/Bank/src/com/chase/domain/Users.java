package com.chase.domain;

public class Users {
	
	private int uid;
	private UserType userType;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String email;
	
	
	public Users(int id, UserType userType, String firstName, String lastName, String phoneNum, String email) {
		super();
		this.uid = id;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	public Users(UserType userType, String firstName, String lastName, String phoneNum, String email) {
		super();
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.email = email;
	}
	
	public Users() {
		super();
	}

	@Override
	public String toString() {
		return "Users [id=" + uid + ", userType=" + userType + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNum=" + phoneNum + ", email=" + email + "]";
	}

	public int getId() {
		return uid;
	}

	public void setId(int id) {
		this.uid = id;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
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

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
