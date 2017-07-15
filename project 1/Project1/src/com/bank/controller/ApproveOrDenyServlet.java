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

public class ApproveOrDenyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ApproveOrDenyServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		
		int r_id = Integer.parseInt(request.getParameter("r_id"));
		int status = Integer.parseInt(request.getParameter("choice"));
		
		String user = (String) session.getAttribute("musername");
		int id = UserDaoImpl.getUserByUsername(user);
		
		try{
			ReimbursementDaoImpl.updateStatus(r_id, id, status);
			RequestDispatcher rd = request.getRequestDispatcher("ApproveOrDeny.jsp");
			rd.include(request, response);
			pw.print("<script>var p1 = document.getElementById('p1');"
					+ "p1.innerHTML = 'Request has been handled';"
					+ "setTimeout(function(){ p1.innerHTML='' }, 2000);</script>");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
