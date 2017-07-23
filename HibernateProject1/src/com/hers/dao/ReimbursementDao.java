package com.hers.dao;

import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.hers.domain.ReimbursementModel;

public interface ReimbursementDao {
	public List<ReimbursementModel> getEmployeeAllReimbursementRequests(int employeeId, int rStatusId); 
	//employee/manager can get this
	//if arg[1] is null, return all requests, otherwise, return pending or resolved list
	public void submitReimbursementRequest(BigDecimal rAmount, String rDescription, InputStream fileContent, Timestamp rSubmitted, int uIdAuthor, int rtType); 
	//only employees submit these requests 
	
	public List<ReimbursementModel> getAllEmployeesReimbursementRequests(int managerId, int rStatusId);
	public boolean approveOrDenyReimbursementRequest(int reimbursementId, Timestamp resolved, int resolverId, int statusId);
	
	//to create a separate function to handle the photo, the blob part?
	//question: best to pass objects as arguments or int id
	
	
	

}
