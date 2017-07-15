package com.bank.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bank.dao.UserDao;
import com.bank.dao.UserImpl;
import com.bank.user.Users;

@SuppressWarnings("serial")
@MultipartConfig(maxFileSize = 16177215)
public class ReimbursementServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		HttpSession session = req.getSession(false);
		PrintWriter pw = resp.getWriter();

		if(session != null) {
			try {
				req.getRequestDispatcher("header.html").include(req, resp);

				Users user = (Users) session.getAttribute("user");

				pw.println("<div class=\"container\">");
		
					pw.println("<div class=\"row\">");
						pw.println("<div class=\"col-md-offset-4 col-md-4 col-lg-4\">");
							pw.println("<p> Hello " + "<span id=\"reimburseRole\">" + user.getRole() + "</span>" + " " + user.getUsername() + "! </p>");
						pw.println("</div>");
					pw.println("</div>");
				
					req.getRequestDispatcher("reimbursement.html").include(req, resp);
				
				pw.println("</div>");

				req.getRequestDispatcher("footer.html").include(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
				resp.sendRedirect("login");
			}	
		} else {
			resp.sendRedirect("login");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		
		if(session != null) {

			Users currentUser = (Users) session.getAttribute("user");
			UserDao user = new UserImpl();
			
			String amount = req.getParameter("amount");
	        String category = req.getParameter("category");
	        String description = req.getParameter("description");
	         
	        Part filePart = req.getPart("picture");
	        
	        InputStream inputStream = filePart.getInputStream();
	        
	        if (filePart != null) {
//	             prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            
	            inputStream = filePart.getInputStream();
	            
	            if (user.submitReimbursement(currentUser, amount, category, description, inputStream)){
	    			resp.sendRedirect("profile");
	            	System.out.println("successful");
	            }
	        }

			
		} else {
			resp.sendRedirect("login");
		}
	}

}
