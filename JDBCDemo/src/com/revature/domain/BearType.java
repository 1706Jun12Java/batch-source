package com.revature.domain;

public class BearType {
	
	public BearType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public BearType(String name) {
		super();
		this.name = name;
	}

	private int id;
	private String name;

	public BearType() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BearType [id=" + id + ", name=" + name + "]";
	}

}
