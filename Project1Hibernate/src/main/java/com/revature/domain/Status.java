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
@Table(name="REIM_STATUS")
public class Status implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1277920321697232035L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "urSeq")
	@SequenceGenerator(allocationSize = 1, name = "urSeq", sequenceName = "UR_SEQ")
	@Column(name="RS_ID")
	private int id;
	
	@Column(name = "R_STATUS")
	protected String status;
	
	@OneToMany(mappedBy="status",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Reimbursements> members;
	public List<Reimbursements> getMembers() {
		return members;
	}
	public Status() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
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
		return "Status [id=" + id + ", status=" + status + "]";
	}
	
}
