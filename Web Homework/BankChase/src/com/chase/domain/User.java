package com.chase.domain;

public class User {

	private int uid;
	private UserType userType;
	private String firstName;
	private String lastName;
	private String phoneNum;
	private String email;
	private String username;
	private String password;
	
	
	public User(int id, UserType userType, String firstName, String lastName,
			String phoneNum, String email,String username, String password) {
		super();
		this.uid = id;
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public User(UserType userType, String firstName, String lastName,
			String phoneNum, String email,String username, String password) {
		super();
		this.userType = userType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public User() {
		super();
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [uid=" + uid + ", userType=" + userType + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNum=" + phoneNum + ", email=" + email + ", username=" + username + ", password=" + password
				+ "]";
	}
}
