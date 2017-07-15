package com.revature.leibniz.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.leibniz.ers.dao.ReimbursementRequestImpDao;
import com.revature.leibniz.ers.domain.Employee;
import com.revature.leibniz.ers.domain.ReimbursementRequest;
import com.revature.leibniz.ers.util.DataUtil;

public class ProcessRRServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		PrintWriter pw = resp.getWriter();
		if(req.getParameter("quantity").equals("")) {
			DataUtil.printMessagePage(pw, "WRONG INPUT", "makeRR", "Go back");
		}
		else {
			Employee emp = (Employee) req.getSession().getAttribute("employee"); 
			int id = DataUtil.getMaxInt("R_REQUEST_TABLE", "R_REQUEST_ID");
			double quantity = Double.parseDouble(req.getParameter("quantity"));
			ReimbursementRequest rr = new ReimbursementRequest()
					.setId(++id)
					.setQuantity(quantity)
					.setStatus(ReimbursementRequest.PENDING_STATUS)
					.setEmployeeID(emp.getID());
			
			new ReimbursementRequestImpDao().createReimbursementRequest(rr);
			DataUtil.printMessagePage(pw, "REQUEST SENT", "employee", "Go back");
		}
		
		
	}
}
