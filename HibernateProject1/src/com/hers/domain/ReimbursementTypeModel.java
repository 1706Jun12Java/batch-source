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
@Table(name="HERS_REIMBURSEMENT_TYPE")
public class ReimbursementTypeModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7753390146268180300L;

	public ReimbursementTypeModel(String type) {
		super();
		this.type = type;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="rTypeSequence")
	@SequenceGenerator(allocationSize=1, name="rTypeSequence", sequenceName="RTYPE_SEQ")
	@Column(name="RT_ID")
	private int id;
	
	@Column(name="RT_TYPE")
	private String type;
	
	@OneToMany(mappedBy="type", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<ReimbursementModel> reimbursements;
	
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
		return "ReimbursementTypeModel [id=" + id + ", type=" + type + ", reimbursements=" + reimbursements + "]";
	}
	
	public List<ReimbursementModel> getReimbursements(){
		return reimbursements;
	}

}
