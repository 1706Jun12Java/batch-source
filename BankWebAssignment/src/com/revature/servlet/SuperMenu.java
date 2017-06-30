package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.Exceptions.InvalidAccountException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.domain.Account;
import com.revature.domain.TransLog;
import com.revature.domain.User;
import com.revature.main.ActionCaller;

public class SuperMenu extends HttpServlet {

	public SuperMenu() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		doPost(req,resp);
		

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		req.getRequestDispatcher("Navbar.html").include(req, resp);
		HttpSession sess =req.getSession(false);
		User user = (User) sess.getAttribute("user");
		if(user!=null && user.isSuper()){
			try {
				pw.println("<div class=\"panel panel-default\"> \n <div class=\"panel-heading\">\n <h2 class=\"panel-title\">All Registered Users</h2> \n </div>");
				List<User> users = ActionCaller.viewAllUsers();
				if(!users.isEmpty()){
					pw.println("<div class=\"table-responsive\">\n <table class=\"table\">");
					pw.println("<thead><tr><th>User ID</th> <th>Is Super</th> <th>Username</th></tr> </thead>");
					pw.println("<tbody>");
					
					for(User u :users){
						pw.println("<tr>");
						pw.println("<td>"+u.getUserID()+"</td>");
						pw.println("<td>"+u.isSuper()+"</td>");
						pw.println("<td>"+u.getUserName()+"</td>");
						pw.println("<td><a href=\"deleteUser?id="+u.getUserName()+"\" class=\"confirm-delete btn mini red-stripe\" role=\"button\" data-title=\"DELETE\">Delete</a></td>");
						pw.println("</tr>");
					}
					pw.println(" </table> </div>");
				}
				pw.println("</div>");
				
				pw.println("<div class=\"panel panel-default\"> \n <div class=\"panel-heading\">\n <h2 class=\"panel-title\">Create New User</h2> \n </div>");
				pw.println("<div class = \"panel-body\"> \n");
				pw.println("<form action=\"createUser\" method=\"post\">");
				pw.println("<fieldset> Username <input type=\"text\" name=\"username\"><br> <br>Password <input type=\"text\" name=\"password\"></fieldset>");
				pw.println("<input type=\"submit\" value=\"Submit\">");
				pw.println("</form>");
				pw.println("</div>");
				pw.println("</div>");
				
				pw.println("<div class=\"panel panel-default\"> \n <div class=\"panel-heading\">\n <h2 class=\"panel-title\">Update User</h2> \n </div>");
				pw.println("<div class = \"panel-body\"> \n");
				pw.println("<form action=\"updateUser\" method=\"post\">");
				pw.println("<label class=\"radio-inline\"><input type=\"radio\" value=\"0\" name=\"optradio2\">Super OFF</label><label class=\"radio-inline\"><input type=\"radio\" value=\"1\" name=\"optradio2\">Super ON</label><br>");
				pw.println("<fieldset> Old Username <input type=\"text\" name=\"oldusername\"><br> <br>New Username <input type=\"text\" name=\"newusername\"><br><br>Password <input type=\"text\" name=\"password\"></fieldset>");
				pw.println("<input type=\"submit\" value=\"Submit\">");
				pw.println("</form>");
				pw.println("</div>");
				pw.println("</div>");
			} catch (InvalidAccountException e) {
				pw.println("<div class = \"panel-body\"> \n"+e.getMessage()+"</div>");
				pw.println("</div>");
			}
		}else{
			resp.sendRedirect("404.html");
		}
	}
}

