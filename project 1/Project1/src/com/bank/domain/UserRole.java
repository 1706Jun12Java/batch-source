package com.bank.domain;

public class UserRole {
	
	private int ur_id;
	private String role;

	public UserRole() {
	}

	public UserRole(int ur_id, String role) {
		super();
		this.ur_id = ur_id;
		this.role = role;
	}

	public int getUr_id() {
		return ur_id;
	}

	public void setUr_id(int ur_id) {
		this.ur_id = ur_id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRole [ur_id=" + ur_id + ", role=" + role + "]";
	}
	
}
