package com.revature.domain;

public class User {
	private int u_id;
	private String u_username;
	private String u_password;
	private String u_fname;
	private String u_lname;
	private String u_email;
	private  int ur_id;
	public User() {
		super();
	}
	public User( String u_username, String u_password, String u_fname, String u_lname, String u_email,
			int ur_id) {
		super();
		this.u_username = u_username;
		this.u_password = u_password;
		this.u_fname = u_fname;
		this.u_lname = u_lname;
		this.u_email = u_email;
		this.ur_id = ur_id;
	}
	public User(int u_id, String u_username, String u_password, String u_fname, String u_lname, String u_email,
			int ur_id) {
		super();
		this.u_id = u_id;
		this.u_username = u_username;
		this.u_password = u_password;
		this.u_fname = u_fname;
		this.u_lname = u_lname;
		this.u_email = u_email;
		this.ur_id = ur_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_username() {
		return u_username;
	}
	public void setU_username(String u_username) {
		this.u_username = u_username;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_fname() {
		return u_fname;
	}
	public void setU_fname(String u_fname) {
		this.u_fname = u_fname;
	}
	public String getU_lname() {
		return u_lname;
	}
	public void setU_lname(String u_lname) {
		this.u_lname = u_lname;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public int getUr_id() {
		return ur_id;
	}
	public void setUr_id(int ur_id) {
		this.ur_id = ur_id;
	}
	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_username=" + u_username + ", u_password=" + u_password + ", u_fname="
				+ u_fname + ", u_lname=" + u_lname + ", u_email=" + u_email + ", ur_id=" + ur_id + "]";
	}

}
