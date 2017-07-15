package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.bank.dao.ReimbursementDaoImpl;
import com.bank.dao.UserDaoImpl;

public class ReimbursementRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReimbursementRequestServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		
		double amount = Double.parseDouble(request.getParameter("amount"));
		String description = request.getParameter("description");
		int type = Integer.parseInt(request.getParameter("type"));
		
		String user = (String) session.getAttribute("username");
		int id = UserDaoImpl.getUserByUsername(user);
		
		try{
			ReimbursementDaoImpl.reimburseRequest(amount, description, id, type);
			RequestDispatcher rd = request.getRequestDispatcher("ReimbursementSubmit.jsp");
			rd.include(request, response);
			pw.print("<script>var p1 = document.getElementById('p1');"
					+ "p1.innerHTML = 'Successfully Submitted Request';"
					+ "setTimeout(function(){ p1.innerHTML='' }, 2000);</script>");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
