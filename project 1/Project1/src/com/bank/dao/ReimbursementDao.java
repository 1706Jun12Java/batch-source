package com.bank.dao;

import java.util.List;

import com.bank.domain.Reimbursement;

public interface ReimbursementDao {

	
	public static void reimburseRequest(double amount, String description, int uid, int type) {
	}
	public static List<Reimbursement> viewPendingReimbursements(int id) {
		return null;
	}
	public static List<Reimbursement> viewResolvedReimbursements(int id) {
		return null;
	}
	public static List<Reimbursement> viewAllPendingReimbursements() {
		return null;
	}
	public static List<Reimbursement> viewAllResolvedReimbursements() {
		return null;
	}
	public static void updateStatus(int r_id,int u_id,int status){
	}
	public static List<Reimbursement> getReimbursementByUsername(int id){
		return null;
	}
}
