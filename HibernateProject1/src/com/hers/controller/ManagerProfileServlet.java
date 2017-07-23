package com.hers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hers.dao.RStatusDao;
import com.hers.dao.RStatusDaoLogic;
import com.hers.dao.ReimbursementDao;
import com.hers.dao.ReimbursementDaoLogic;
import com.hers.domain.ReimbursementModel;

public class ManagerProfileServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);
		
		if (session!=null){
			try{
//				String username = (String) session.getAttribute("managerUserName");
				int managerId = (int) session.getAttribute("managerId");
//				String managerUserName = (String) session.getAttribute("managerUserName");
//				String managerFirstName = (String) session.getAttribute("managerFirstName");
//				String managerLastName = (String) session.getAttribute("managerLastName");
//				String managerEmail = (String) session.getAttribute("managerEmail");
				
				ReimbursementDao employeeRListGetter = new ReimbursementDaoLogic();
				
				RStatusDao rStatus = new RStatusDaoLogic();
				int pendingStatusId = rStatus.getIdOfStatus("Pending");
				int approvedStatusId = rStatus.getIdOfStatus("Approved");
				int deniedStatusId = rStatus.getIdOfStatus("Denied");
				
				ObjectMapper mapper = new ObjectMapper();
//				int managerId = (int) mapper.writeValueAsString((int) session.getAttribute("managerId"));
				
				String managerFirstName = mapper.writeValueAsString(session.getAttribute("managerFirstName"));
				String managerLastName = mapper.writeValueAsString(session.getAttribute("managerLastName"));
				String managerEmail = mapper.writeValueAsString(session.getAttribute("managerEmail"));

				resp.getWriter().print(managerFirstName + " ");
				resp.getWriter().print(managerLastName + "<br>");
				resp.getWriter().println(managerEmail + "<br>");
//				List<ReimbursementModel> rList = employeeRListGetter.getEmployeeAllReimbursementRequests(employeeId, pendingStatusId).;
//				System.out.println(rList);
				
//public List<ReimbursementModel> getAllEmployeesReimbursementRequests(int managerId, int rStatusId);
				for(ReimbursementModel employeeRList: employeeRListGetter.getAllEmployeesReimbursementRequests(managerId, pendingStatusId)){
					resp.getWriter().print("REIMBURSEMENT ID: " + (int) employeeRList.getId() + " "+ "<br>");
					resp.getWriter().print("REIMBURSEMENT AMOUNT: " + (BigDecimal) employeeRList.getAmount() + " "+ "<br>");
					resp.getWriter().print("EMPLOYEE ID: " + (int) employeeRList.getAuthorId() + " "+ "<br>");
					resp.getWriter().print("REIMBURSEMENT DESCRIPTION: " + (String) employeeRList.getDescription() + " "+ "<br>");
					resp.getWriter().print("REIMBURSEMENT TYPE: " + (int) employeeRList.getStatus() + " " + "<br><br><br>\n\n");
					
				}
				
				req.getRequestDispatcher("views/html/managerProfile.html").include(req, resp);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
//		req.getRequestDispatcher("views/html/managerProfile.html").include(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
