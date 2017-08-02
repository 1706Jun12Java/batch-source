package com.revature.domain;

import java.io.Serializable;

public class BatType implements Serializable {

	public BatType(String name) {
		super();
		this.name = name;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6986697274544071L;

	private int id;

	private String name;

	public BatType() {
		// TODO Auto-generated constructor stub
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
