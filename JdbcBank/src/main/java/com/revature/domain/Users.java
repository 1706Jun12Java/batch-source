package com.revature.domain;

public class Users {

	private int id;
	private String name;
	private String password;
	private String email;

	public Users(int id, String name, String password, String email) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		
	}

	public Users(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Users() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return " User ID: " + id + "Username: " + name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}