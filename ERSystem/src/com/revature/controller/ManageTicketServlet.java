package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.revature.dao.EReimbursementDao;
import com.revature.dao.EReimbursementDaoImpl;
import com.revature.domain.Reimbursement;

public class ManageTicketServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6511528893122386736L;

	public ManageTicketServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		resp.setContentType("application/json");
		EReimbursementDao UE = new EReimbursementDaoImpl();
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try{
			int userID = (int)session.getAttribute("userID");
			Reimbursement re = UE.getReimbursementById(Integer.parseInt(req.getParameter("id")));
			re.setReceiptURL("http://localhost:8080/ERSystem/master?destination=getimage&id="+re.getId());
			String json = mapper.writeValueAsString(re);
			System.out.println(json);
			pw.write(json);
		}catch(NullPointerException e){
			pw.write("{\"redirect\":\"login.html\"}");
		}catch(Exception e){
			pw.write("{\"error\":\""+ e.toString() +"\"}");
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		resp.setContentType("application/json");
		EReimbursementDao UE = new EReimbursementDaoImpl();
		System.out.println("in getticket dopost");
		try{
			int userID = (int) session.getAttribute("userID");
			int result = 0;
			if(userID<2){
				int id = Integer.parseInt(req.getParameter("id"));
				System.out.println(id);
				String action = req.getParameter("action");
				System.out.println(action);
				if(action.equals("approve")){
					result = UE.approveReimbursement(id,userID);
					
				}else if(action.equals("deny")){
					result = UE.denyReimbursement(id,userID);
				}
				System.out.println(result);
				if(result==1){
					pw.write("{\"status\":\"OK\"}");
				}else{
					pw.write("{\"error\":\"Unable to process at this time.\"}");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}
