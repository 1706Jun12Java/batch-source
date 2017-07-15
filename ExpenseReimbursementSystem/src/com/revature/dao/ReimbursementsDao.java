package com.revature.dao;

import java.util.List;

import com.revature.domain.Reimbursements;

public interface ReimbursementsDao {

	public List<Reimbursements> getReimbursements();

	public Reimbursements getReimbursementsById(int r_Id);

	public void createReimbursement(int r_amount,String r_description,int u_Id_author,
	int rt_type);

	public void approveReimbursement(int r_Id);
	
	public void denyReimbursement(int r_Id);
	
}
