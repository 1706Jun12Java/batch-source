package com.revature.leibniz.ers.dao;

import java.util.List;

import com.revature.leibniz.ers.domain.ReimbursementRequest;
/**
 * 
 * @author Leibniz Berihuete
 * ReimbursementRequest DAO Interface,
 * will be implemented by ReimbursementRequestImpDao
 */
public interface ReimbursementRequestDao {
	public List<ReimbursementRequest> getReimbursementRequests();
	public ReimbursementRequest findReimbursementRequestByID(int id);
	public int createReimbursementRequest(ReimbursementRequest reimbursementRequest);
}
