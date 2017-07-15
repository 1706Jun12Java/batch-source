package com.bank.user;

public class UpdateReimburse {
	private int reimburseId;
	private String reimburseInfo;
	public int getReimburseId() {
		return reimburseId;
	}
	public String getReimburseInfo() {
		return reimburseInfo;
	}

	public UpdateReimburse(String reimburseInfo, int reimburseId) {
		this.reimburseId = reimburseId;
		this.reimburseInfo = reimburseInfo;
	}
}
