package com.revature.dao;

import java.sql.Blob;
import java.util.List;

import com.revature.domain.Reimbursement;

public interface EReimbursementDao {

	public List<Reimbursement> getReimbursements();
	public List<Reimbursement> getReimbursementsByUser(int userId);
	public int approveReimbursement(int id);
	public int denyReimbursement(int id);
	public int addReimbursement(Reimbursement r);
	public int updateReStatus(int reId, int resolver, int status);
	public Blob getImageById(int id);
}
