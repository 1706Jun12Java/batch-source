package com.revature.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.revature.dao.EReimbursementDao;
import com.revature.dao.EReimbursementDaoImpl;
import com.revature.domain.Reimbursement;

@MultipartConfig
public class TicketsServlet extends HttpServlet{

	/**
	 *
	 */
	private static final long serialVersionUID = 6511528893122386736L;

	public TicketsServlet() {
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
		List<Reimbursement> RES;
		try{
			int userID = (int)session.getAttribute("userID");
			int userType = (int)session.getAttribute("userType");
			if(userType>1){
				RES = UE.getReimbursementsByUser(userID);
			}else{
				RES = UE.getReimbursements();
			}
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
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		resp.setContentType("document");
		EReimbursementDao UE = new EReimbursementDaoImpl();
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try{
			Double amount = Double.parseDouble(req.getParameter("amount"));
			int id = (int) session.getAttribute("userID");
			Map<String, String[]> m = req.getParameterMap();
			for (String key : m.keySet()) {
			    System.out.println(key);
			}
			String description = req.getParameter("description");
			int type = Integer.parseInt(req.getParameter("ertype"));
			Part filePart = req.getPart("img");
			InputStream fileContent = filePart.getInputStream();
			Reimbursement re = new Reimbursement(amount,description,fileContent,id,type);
			int result = UE.addReimbursement(re);
			resp.setContentType("application/json");
			if(result==1){
				pw.write("{\"status\":\"OK\"}");
			}else{
				pw.write("{\"error\"}:\"Unable to process at this time.\"");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
}
