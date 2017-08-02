package com.revature.domain;

import java.io.*;

public class BatColony implements Serializable {

	public BatColony(String name) {
		super();
		this.name = name;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2626110166251045555L;
	
	private int id;
	
	private String name;
	
	
	public BatColony() {
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
		return "BatColony [id=" + id + ", name=" + name + "]";
	}

}
