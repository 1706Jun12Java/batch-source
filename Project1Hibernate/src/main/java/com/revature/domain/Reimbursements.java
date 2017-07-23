package com.revature.domain;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

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
@Table(name="REIM")
public class Reimbursements implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7817629225179296786L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "urSeq")
	@SequenceGenerator(allocationSize = 1, name = "urSeq", sequenceName = "UR_SEQ")
	@Column(name="RT_ID")
	private int id;
	
	@Column(name = "AMOUNT")
	private double amount;
	
	@Column(name = "DESCRIPTION")
	private double description;
	
	@Column(name = "RECEIPT")
	private Blob receipt;
	
	@Column(name = "SUBMITTED")
	private Timestamp submitted;
	
	@Column(name = "RESOLVED")
	private Timestamp resolved;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="AUTHOR_ID")
	private User author;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="RESOLVER_ID")
	private User resolver;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="REIM_TYPE")
	private Type type;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="REIM_STATUS")
	private Status status;
	
	public Reimbursements() {
		// TODO Auto-generated constructor stub
	}

}
