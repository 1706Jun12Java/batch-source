package com.revature.domain;

import java.io.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BAT_COLONY")
public class BatColony implements Serializable {

	public BatColony(String name) {
		super();
		this.name = name;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2626110166251045555L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="colonySequence")
	@SequenceGenerator(allocationSize=1,name="colonySequence",sequenceName="COLONY_SEQ")
	@Column(name="BAT_COLONY_ID")
	private int id;
	
	@Column(name="BAT_COLONY_NAME")
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
