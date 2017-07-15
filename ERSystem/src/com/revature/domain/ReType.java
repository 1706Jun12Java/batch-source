package com.revature.domain;

public class ReType {
	
	private int id;
	private String type;
	
	public ReType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	
	public ReType(String type) {
		super();
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
