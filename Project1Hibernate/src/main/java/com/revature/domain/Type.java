package com.revature.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="REIM_TYPE")
public class Type implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3517669159505297383L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "urSeq")
	@SequenceGenerator(allocationSize = 1, name = "urSeq", sequenceName = "UR_SEQ")
	@Column(name="RT_ID")
	private int id;
	
	@Column(name = "R_TYPE")
	protected String type;
	
	@OneToMany(mappedBy="type",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Reimbursements> members;
	public List<Reimbursements> getMembers() {
		return members;
	}
	public Type() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return type;
	}
	public void setStatus(String type) {
		this.type = type;
	}
	public Type(String type) {
		super();
		this.type = type;
	}
	@Override
	public String toString() {
		return "Type [id=" + id + ", type=" + type + "]";
	}

}
