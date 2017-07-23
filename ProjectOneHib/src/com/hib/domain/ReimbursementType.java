package com.hib.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="REIMBURSEMENT_TYPE")
public class ReimbursementType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1125530940421153137L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="typeSequence")
	@SequenceGenerator(allocationSize=1, name="typeSequence", sequenceName="REIMBURSEMENT_TYPE_SEQ")
	@Column(name="RT_ID")
	private int id;
	
	@Column(name="RT_TYPE")
	private String type;

	public ReimbursementType(String type) {
		super();
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ReimbursementType [id=" + id + ", type=" + type + "]";
	}	
	
}
