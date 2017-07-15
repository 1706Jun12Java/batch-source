package com.revature.dao;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import com.revature.domain.ReimbursementTicket;
import com.revature.domain.User;

public interface ReimbursementDao {
	public List<ReimbursementTicket> getReimbursementTickets();
	public List<ReimbursementTicket> getReimbursementTicketsByEmp(User emp);
	public String getReimbursementTicketStatus(ReimbursementTicket rt);
	public String getReimbursementTicketType(ReimbursementTicket rt);
	public ReimbursementTicket getReimbursementTicketById(int id);
	public List<ReimbursementTicket> getPendingReimbursementTickets();
	List<ReimbursementTicket> getResolvedReimbursementTickets();
	public boolean registerNewTicket(ReimbursementTicket rt,InputStream is);
	public boolean approveTicket(ReimbursementTicket rt, User user);
	public boolean denyTicket(ReimbursementTicket rt,  User user);
	public Blob getBlobById(int id);
}
