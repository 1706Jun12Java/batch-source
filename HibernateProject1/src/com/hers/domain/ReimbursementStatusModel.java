package com.hers.domain;

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
@Table(name="HERS_REIMBURSEMENT_STATUS")
public class ReimbursementStatusModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -221568970543053713L;

	public ReimbursementStatusModel(int id, String status) {
		super();
		this.status = status;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rStatusSequence")
	@SequenceGenerator(allocationSize=1, name="rStatusSequence", sequenceName="RSTATUS_SEQ")
	@Column(name="RS_ID")
	private int id;
	
	@Column(name="RS_STATUS")
	private String status;
	
	@OneToMany(mappedBy="status", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<ReimbursementModel> reimbursements;
	
	public Number getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "ReimbursementStatus [id=" + id + ", status=" + status + "]";
	}
	
	public List<ReimbursementModel> getReimbursements(){
		return reimbursements;
	}

}
