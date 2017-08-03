package com.revature.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="BAT_TYPE")
public class BatType implements Serializable{

	public BatType(String name) {
		super();
		this.name = name;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -6986697274544071L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="typeSequence")
	@SequenceGenerator(allocationSize=1,name="typeSequence",sequenceName="BAT_TYPE_SEQ")
	@Column(name="BAT_TYPE_ID")
	private int id;
	
	@Column(name="BAT_TYPE_NAME")
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
