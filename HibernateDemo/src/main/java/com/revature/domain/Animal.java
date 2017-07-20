package com.revature.domain;

import javax.persistence.*;

@Entity
@Table(name="ANIMAL")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animSeq")
	@SequenceGenerator(allocationSize = 1, name = "animSeq", sequenceName = "ANIM_SEQ")
	@Column(name = "ANIMAL_ID")
	protected int id;

	@Column(name = "ANIMAL_NAME")
	protected String name;
	

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
}
