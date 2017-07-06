package com.revature.domain;

public class Users {

	private int id;
	private String fname;
	private String lname;
	private String password;
	private String email;
	private String username;
	private int urid;
	
	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getUrid() {
		return urid;
	}

	public void setUrid(int urid) {
		this.urid = urid;
	}

	

	
	public Users() {
	}

	public Users(int uId, String username, String password, String fn, String ln, int isAdmin) {
		this.id = uId;
		this.username = username;
		this.password = password;
		this.lname = ln;
		this.fname = fn;
		
	}

	public Users(int userID, String username2, String pw, String email2) {
		this.id = userID;
		this.username = username2;
		this.password = pw;
		this.email = email2;
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

	@Override
	public String toString() {
		return " User ID: " + id + ", Username: " + username +", Password: " + password + ", Email: "+ email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}