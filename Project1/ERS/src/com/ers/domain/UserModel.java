package com.ers.domain;

public class UserModel {
	
	public UserModel(int userId, String username, String password, String firstName, String lastName, String email,
			int userRoleId) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRoleId = userRoleId;
	}
	
	public UserModel(int userId, String username, String firstName, String lastName, String email, int userRoleId) {
		super();
		this.userId = userId;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userRoleId = userRoleId;
	}

	private int userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private int userRoleId;
	
	public int userId() {
		return userId;
	}
	public void setId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public int getRoleId() {
		return userRoleId;
	}
	public void setRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}
	@Override
	public String toString() {
		return "ErsUser [id=" + userId + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", userRoleId=" + userRoleId + "]";
	}
	
}
