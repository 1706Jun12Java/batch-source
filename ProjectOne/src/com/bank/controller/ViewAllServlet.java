package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.UserDao;
import com.bank.dao.UserImpl;
import com.bank.user.Users;

@SuppressWarnings("serial")
public class ViewAllServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);

		if(session != null) {
			Users user = (Users) session.getAttribute("user");

			if (user.getRole().equals("Manager")){
				req.getRequestDispatcher("header.html").include(req, resp);

				UserDao users = new UserImpl();

				List<Users> list = users.getUsers();
				pw.println("<div class=\"container\">");
					pw.println("<div class=\"table-responsive\">");
	
						pw.println("<table class=\"table table-bordered table-striped\">");
							pw.println("<tr>");
								pw.println("<th>");
									pw.println("Username");
								pw.println("</th>");
								pw.println("<th>");
									pw.println("First Name");
								pw.println("</th>");
								pw.println("<th>");
									pw.println("Last Name");
								pw.println("</th>");
								pw.println("<th>");
									pw.println("Email");
								pw.println("</th>");
								pw.println("<th>");
									pw.println("Role");
								pw.println("</th>");
							pw.println("</tr>");
							for (int i = 0; i < list.size(); i++){
								pw.println("<tr>");
									pw.println("<td>" + list.get(i).getUsername() + "</td>");
		
									pw.println("<td>" + list.get(i).getFirstName() + "</td>");
		
									pw.println("<td>" + list.get(i).getLastName() + "</td>");
									
									pw.println("<td>" + list.get(i).getEmail() + "</td>");
									
									pw.println("<td>" + list.get(i).getRole() + "</td>");
									
								pw.println("</tr>");
							}
						pw.println("</table>");
					pw.println("</div>");
				pw.println("</div>");
				req.getRequestDispatcher("footer.html").include(req, resp);
			} else{
				resp.sendRedirect("logout");
			}
		} else {
			resp.sendRedirect("login");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
