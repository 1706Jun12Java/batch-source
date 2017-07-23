package com.revature.dao;

import java.util.List;

import com.revature.domain.*;

public interface ReimbursementDao {
	public List<Reimbursements> getReimbursements();
	public User getReimbursementById(int id);
	public int saveReimbursement(Reimbursements b);
}
