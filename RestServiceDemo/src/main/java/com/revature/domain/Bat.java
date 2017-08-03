package com.revature.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BAT")
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animalSeq")
	@SequenceGenerator(allocationSize = 1, name = "animalSeq", sequenceName = "ANIMAL_SEQ")
	@Column(name = "ANIMAL_ID")
	private int id;
	
	@Column(name="ANIMAL_NAME")
	private String name;
	
	@Column(name="BAT_SPAN")
	private int wingspan;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BAT_TYPE")
	private BatType type;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="BAT_COLONY")
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