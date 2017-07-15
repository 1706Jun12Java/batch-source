package com.revature.domain;

public class UserType {
	private int id;
	private String role;
	
	public UserType(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	
	public UserType(String role) {
		super();
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
