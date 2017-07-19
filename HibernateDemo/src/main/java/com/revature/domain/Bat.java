package com.revature.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="BAT")
public class Bat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3183706718565552959L;

	public Bat(String name, BatType type, BatColony colony) {
		super();
		this.name = name;
		this.type = type;
		this.colony = colony;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="batSequence")
	@SequenceGenerator(allocationSize=1,name="batSequence",sequenceName="BAT_SEQ")
	@Column(name="BAT_ID")
	private int id;
	
	@Column(name="BAT_NAME")
	private String name;
	
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
		return "Bat [id=" + id + ", name=" + name + ", type=" + type + ", colony=" + colony + "]";
	}

}
