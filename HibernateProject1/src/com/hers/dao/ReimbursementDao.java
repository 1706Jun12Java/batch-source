package com.hers.dao;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.hers.domain.ReimbursementModel;
import com.hers.domain.ReimbursementStatusModel;
import com.hers.domain.ReimbursementTypeModel;
import com.hers.domain.UserModel;

public interface ReimbursementDao {
	public List<ReimbursementModel> getEmployeeAllReimbursementRequests(int employeeId, ReimbursementStatusModel rStatus); 
	//employee/manager can get this
	//if arg[1] is null, return all requests, otherwise, return pending or resolved list
	
	public List<ReimbursementModel> getAllEmployeesReimbursementRequests(ReimbursementStatusModel rStatus);
	public void approveOrDenyReimbursementRequest(int reimbursementId, Timestamp resolved, UserModel resolver, ReimbursementStatusModel status);
	public void submitReimbursementRequest(BigDecimal rAmount, String rDescription, InputStream rReceipt, Timestamp rSubmitted,
			UserModel author, ReimbursementTypeModel rtType); //for employees		
	

}
