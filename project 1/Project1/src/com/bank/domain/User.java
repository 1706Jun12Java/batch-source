package com.bank.domain;

public class User {

	private int u_id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private UserRole role;

	public User() {
	}

	public User(int u_id, String username, String password, String firstName, String lastName, String email, UserRole role) {
		super();
		this.u_id = u_id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}

	public User(String username, String password, String firstName, String lastName, String email, UserRole role) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = role;
	}
	

	public User(int u_id, String username, String firstName, String lastName, String email) {
		super();
		this.u_id = u_id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public User(String username, String password, String firstName, String lastName, String email) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
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

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", username=" + username + ",  password=" + password + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", role=" + role + "]";
	}

}
