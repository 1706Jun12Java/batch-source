package com.chase.domain;

public class UserType {
	
	private int utid;
	private String access;
	
	public UserType(int id, String access) {
		super();
		this.utid = id;
		this.access = access;
	}

	public UserType() {
		super();
	}

	@Override
	public String toString() {
		return "UserType [id=" + utid + ", access=" + access + "]";
	}

	public int getId() {
		return utid;
	}

	public void setId(int id) {
		this.utid = id;
	}

	public String getAccess() {
		return access;
	}

	public void setAccess(String access) {
		this.access = access;
	}
	
	

}
