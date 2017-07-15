package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

public class TicketServlet extends HttpServlet{

	/**
	 *
	 */
	private static final long serialVersionUID = 6511528893122386736L;

	public TicketServlet() {
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
			List<Reimbursement> RES = UE.getReimbursementsByUser((int)session.getAttribute("userID"));
			String json = mapper.writeValueAsString(RES);
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
	}
}
