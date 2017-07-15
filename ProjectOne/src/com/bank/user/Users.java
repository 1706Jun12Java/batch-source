package com.bank.user;

public class Users {
	private int u_ID;
	private String username;

	private String firstName;
	private String lastName;
	private String email;
	private String role;

	public Users(int u_ID, String username, String firstName, String lastName, String email,
			String r_ID) {
		super();
		this.u_ID = u_ID;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.role = r_ID;
	}
	
	public int getU_ID() {
		return u_ID;
	}

	public String getUsername() {
		return username;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "Users [u_ID=" + u_ID + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", r_ID=" + role + "]";
	}
}
