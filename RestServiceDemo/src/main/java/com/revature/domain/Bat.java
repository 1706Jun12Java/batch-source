package com.revature.domain;

import java.io.Serializable;

public class Bat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3183706718565552959L;

	public Bat(String name, int wingspan, BatType type, BatColony colony) {
		super();
		this.name = name;
		this.wingspan = wingspan;
		this.type = type;
		this.colony = colony;
	}
	
	private int id;
	
	private String name;
	
	private int wingspan;
	
	private BatType type;
	
	private BatColony colony;
	
	public Bat() {
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

	public BatType getType() {
		return type;
	}

	public void setType(BatType type) {
		this.type = type;
	}

	public BatColony getColony() {
		return colony;
	}

	public void setColony(BatColony colony) {
		this.colony = colony;
	}

	@Override
	public String toString() {
		return "Bat [id=" + id + ", name=" + name + ", wingspan=" + wingspan+", type=" + type + ", colony=" + colony + "]";
	}

	public int getWingspan() {
		return wingspan;
	}

	public void setWingspan(int wingspan) {
		this.wingspan = wingspan;
	}

}