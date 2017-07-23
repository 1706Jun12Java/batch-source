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

public class EmployeeProfileServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2005779915007622196L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);
		
		if (session!=null){
			try{
				String username = (String) session.getAttribute("employeeUserName");
				int employeeId = (int) session.getAttribute("employeeId");
				
				System.out.println(employeeId);
//				String employeeUserName = (String) session.getAttribute("employeeUserName");
//				String employeeLastName = (String) session.getAttribute("employeeLastName");
//				String employeeEmail = (String) session.getAttribute("employeeEmail");
				
//				req.getRequestDispatcher("views/html/employeeProfile.html").include(req, resp);

				
				ObjectMapper mapper = new ObjectMapper();
				String employeeFirstName = mapper.writeValueAsString(session.getAttribute("employeeFirstName"));
				String employeeLastName = mapper.writeValueAsString(session.getAttribute("employeeLastName"));
				String employeeEmail = mapper.writeValueAsString(session.getAttribute("employeeEmail"));
//				String employee

				resp.getWriter().print(employeeFirstName + " ");
				resp.getWriter().print(employeeLastName + "<br>");
				resp.getWriter().println(employeeEmail + "<br>");
				
				RStatusDao rStatus = new RStatusDaoLogic();
				int pendingStatusId = rStatus.getIdOfStatus("Pending");
				int approvedStatusId = rStatus.getIdOfStatus("Approved");
				int deniedStatusId = rStatus.getIdOfStatus("Denied");
				
				ReimbursementDao employeeRListGetter = new ReimbursementDaoLogic();
				
//				List<ReimbursementModel> rList = employeeRListGetter.getEmployeeAllReimbursementRequests(employeeId, pendingStatusId).;
//				System.out.println(rList);
				
				for(ReimbursementModel employeeRList: employeeRListGetter.getEmployeeAllReimbursementRequests(employeeId, pendingStatusId)){
					resp.getWriter().print("REIMBURSEMENT ID: " + (int) employeeRList.getId() + " "+ "<br>");
					resp.getWriter().print("REIMBURSEMENT AMOUNT: " + (BigDecimal) employeeRList.getAmount() + " "+ "<br>");
					resp.getWriter().print("EMPLOYEE ID: " + (int) employeeRList.getAuthorId() + " "+ "<br>");
					resp.getWriter().print("REIMBURSEMENT DESCRIPTION: " + (String) employeeRList.getDescription() + " "+ "<br>");
					resp.getWriter().print("REIMBURSEMENT TYPE: " + (int) employeeRList.getStatus() + " " + "<br><br><br>\n\n");
					
				}

				
				
				
//				String employeeRList = mapper.writeValueAsString(rList);
//				resp.getWriter().write(employeeRList);
				
				
//				resp.sendRedirect("views/html/employeeProfile.html");

				req.getRequestDispatcher("views/html/employeeProfile.html").include(req, resp);
				
			} catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		
		int employeeId = (int) session.getAttribute("employeeId");
		
		session.setAttribute("employeeId", employeeId);
		
		RStatusDao rStatus = new RStatusDaoLogic();
		int pendingStatusId = rStatus.getIdOfStatus("Pending");
		int approvedStatusId = rStatus.getIdOfStatus("Approved");
		int deniedStatusId = rStatus.getIdOfStatus("Denied");
		
		
		
		

		
		
		ReimbursementDao employeeRListGetter = new ReimbursementDaoLogic();
		
//		public List<ReimbursementModel> getEmployeeAllReimbursementRequests(int employeeId, int rStatusId); 
		List<ReimbursementModel> rList = employeeRListGetter.getEmployeeAllReimbursementRequests(employeeId, pendingStatusId);
		String employeeRList = mapper.writeValueAsString(rList);
		resp.getWriter().write(employeeRList);
		
		
//		for(ReimbursementModel employeeRList: employeeRListGetter.getEmployeeAllReimbursementRequests(employeeId, pendingStatusId)){
//			employeeRList.getId();
//			employeeRList.getAmount();
//			employeeRList.getDescription();
//			employeeRList.getReceipt();
//			employeeRList.getSubmitted();
//			employeeRList.getResolved();
//			employeeRList.getAuthorId();
//			employeeRList.getResolverId();
//			employeeRList.getType();
//			employeeRList.getStatus();
//			
//			
//			
//			String rAmount = mapper.writeValueAsString(employeeRList.getAmount());
//			resp.getWriter().write(rAmount);
//			
//		}
		
		
//		pw.println(employeeId);
//		someClass value = mapper.readValue(src, valueType)
//		someclass value = mapper.readValue(src, valueType) //readvalue is to read from a json file/json info and convert it to java object(s)
//		someclass object = mapper.readValue(jsoninString, someclass.class);
				
//		someclass value = mapper.writeValue(resultFile, value);	 //to convert java object to json	in file
//		String reimbursements = mapper.writeValueAsString(user); //to write the object to json in string
				
				//give src your list of lets say reimbursements, someclass.class
		
	}

}
