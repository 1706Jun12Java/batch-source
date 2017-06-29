package com.revature.domain;

import java.sql.Date;

public class Bear {

	public Bear(int id, String name, Cave cave, String bearType, int weight, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.cave = cave;
		this.bearType = bearType;
		this.weight = weight;
		this.birthdate = birthdate;
	}
	
	
	private int id;
	private String name;
	private Cave cave;
	private String bearType;
	private int weight;
	private Date birthdate;
	

	public Bear() {
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


	public Cave getCave() {
		return cave;
	}


	public void setCave(Cave cave) {
		this.cave = cave;
	}


	public String getBearType() {
		return bearType;
	}


	public void setBearType(String bearType) {
		this.bearType = bearType;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public Date getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "Bear [id=" + id + ", name=" + name + ", cave=" + cave + ", bearType=" + bearType + ", weight=" + weight
				+ ", birthdate=" + birthdate + "]";
	}

}
