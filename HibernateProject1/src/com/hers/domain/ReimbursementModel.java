package com.hers.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name="HERS_REIMBURSEMENT")
public class ReimbursementModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7607504890004882447L;

	public ReimbursementModel(int id, BigDecimal amount, String description, Blob receipt, Timestamp submitted,
			Timestamp resolved, UserModel author, UserModel resolver, ReimbursementTypeModel type, ReimbursementStatusModel status) {
		super();
		this.amount = amount;
		this.description = description;
		this.receipt = receipt;
		this.submitted = submitted;
		this.resolved = resolved;
		this.author = author;
		this.resolver = resolver;
		this.type = type;
		this.status = status;
	}
		
	public ReimbursementModel() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="reimbursementSequence")
	@SequenceGenerator(allocationSize=1, name="reimbursementSequence", sequenceName="REIMBURSEMENT_SEQ")
	@Column(name="R_ID")
	private int id;
	
	@Column(name="R_AMOUNT")
	private BigDecimal amount;
	
	@Column(name="R_DESCRIPTION")
	private String description;
	
	@Column(name="R_RECEIPT", nullable=true)
	private Blob receipt;
	
	@Column(name="R_SUBMITTED")
	private Timestamp submitted;
	
	@Column(name="R_RESOLVED")
	private Timestamp resolved;
	
	@ManyToOne
	@JoinColumn(name="U_AUTHOR")
	private UserModel author;
	
	@ManyToOne
	@JoinColumn(name="U_RESOLVER")
	private UserModel resolver;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="RT_TYPE")
	private ReimbursementTypeModel type;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="RT_STATUS", nullable=false)
	private ReimbursementStatusModel status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Blob getReceipt() {
		return receipt;
	}
	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
	}
	public Timestamp getSubmitted() {
		return submitted;
	}
	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}
	public Timestamp getResolved() {
		return resolved;
	}
	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}
	public UserModel getAuthor() {
		return author;
	}
	public void setAuthor(UserModel author) {
		this.author = author;
	}
	public UserModel getResolver() {
		return resolver;
	}
	public void setResolver(UserModel resolver) {
		this.resolver = resolver;
	}
	public ReimbursementTypeModel getType() {
		return type;
	}
	public void setType(ReimbursementTypeModel type) {
		this.type = type;
	}
	public ReimbursementStatusModel getStatus() {
		return status;
	}
	public void setStatus(ReimbursementStatusModel status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ReimbursementModel [id=" + id + ", amount=" + amount + ", description=" + description + ", submitted=" + submitted + ", resolved=" + resolved + ", author=" + author + ", resolver="
				+ resolver + ", type=" + type + ", status=" + status + "]";
	}

}
