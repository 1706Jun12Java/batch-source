package com.revature.domain;

import org.springframework.stereotype.Component;

@Component
public class BatType {
	private int id;

	private String name;

	public BatType() {
		// TODO Auto-generated constructor stub
	}

	public BatType(String name) {
		this();
		this.name = name;
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
		return "BatType [id=" + id + ", name=" + name + "]";
	}
}
