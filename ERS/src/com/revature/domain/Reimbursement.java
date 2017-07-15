package com.revature.domain;

public class Reimbursement {
	
	private int rid;
	private int ramount;
	private String rdescr;
	private String rreceipt;
	private String rsubmitted;
	private String rresolved;
	private int uidauthor;
	private int uidresolver;
	private int rttype;
	private int rtstatus;
	private String rtType;
	private String rtStatus;
	
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public int getRamount() {
		return ramount;
	}

	public void setRamount(int ramount) {
		this.ramount = ramount;
	}

	public String getRdescr() {
		return rdescr;
	}

	public void setRdescr(String rdescr) {
		this.rdescr = rdescr;
	}

	public String getRreceipt() {
		return rreceipt;
	}

	public void setRreceipt(String rreceipt) {
		this.rreceipt = rreceipt;
	}

	public String getRsubmitted() {
		return rsubmitted;
	}

	public void setRsubmitted(String rsubmitted) {
		this.rsubmitted = rsubmitted;
	}

	public String getRresolved() {
		return rresolved;
	}

	public void setRresolved(String rresolved) {
		this.rresolved = rresolved;
	}

	public int getUidauthor() {
		return uidauthor;
	}

	public void setUidauthor(int uidauthor) {
		this.uidauthor = uidauthor;
	}

	public int getUidresolver() {
		return uidresolver;
	}

	public void setUidresolver(int uidresolver) {
		this.uidresolver = uidresolver;
	}

	public int getRttype() {
		return rttype;
	}

	public void setRttype(int rttype) {
		this.rttype = rttype;
	}

	public int getRtstatus() {
		return rtstatus;
	}

	public void setRtstatus(int rtstatus) {
		this.rtstatus = rtstatus;
	}
	
	public String getRtStatus() {
		return rtStatus;
	}

	public void setRtStatus(String rtStatus) {
		this.rtStatus = rtStatus;
	}
	
	public String getRtType() {
		return rtType;
	}

	public void setRtType(String rtType) {
		this.rtType = rtType;
	}

	public Reimbursement(int rid, int ramount, String rdescr, String rreceipt, String rsubmitted, String rresolved,
			int uidauthor, int uidresolver, int rttype, int rtstatus, String rtStatus, String rtType) {
		super();
		this.rid = rid;
		this.ramount = ramount;
		this.rdescr = rdescr;
		this.rreceipt = rreceipt;
		this.rsubmitted = rsubmitted;
		this.rresolved = rresolved;
		this.uidauthor = uidauthor;
		this.uidresolver = uidresolver;
		this.rttype = rttype;
		this.rtstatus = rtstatus;
		this.rtStatus = rtStatus;
		this.rtType = rtType;
	}

	@Override
	public String toString() {
		return "Reimbursement [rid=" + rid + ", ramount=" + ramount + ", rdescr=" + rdescr + ", rreceipt=" + rreceipt
				+ ", rsubmitted=" + rsubmitted + ", rresolved=" + rresolved + ", uidauthor=" + uidauthor
				+ ", uidresolver=" + uidresolver + ", rttype=" + rttype + ", rtstatus=" + rtstatus + ", rtStatus=" + rtStatus + ", rtType=" + rtType + "]";
	}
}
