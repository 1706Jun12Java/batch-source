package com.revature.domain;

import java.io.Serializable;

import javax.persistence.*;

@NamedQueries({ @NamedQuery(name = "findBatByType", query = "from Bat where type = :typevar") })

@Entity
@Table(name="BAT")
@AttributeOverrides({
	@AttributeOverride(name="id",column=@Column(name="BAT_ID")),
	@AttributeOverride(name="name",column=@Column(name="BAT_NAME"))
})
public class Bat extends Animal implements Serializable {

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
