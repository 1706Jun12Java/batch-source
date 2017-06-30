package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.Exceptions.InvalidAccountException;
import com.revature.Exceptions.InvalidPasswordException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.domain.User;
import com.revature.main.ActionCaller;

public class DeleteUser extends HttpServlet{

	public DeleteUser() {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		req.getRequestDispatcher("Navbar.html").include(req, resp);
		HttpSession sess =req.getSession(false);
		User user = (User) sess.getAttribute("user");
		String id = (String)req.getParameter("id");
		if(id !=null && user != null){
			try {
				ActionCaller.deleteUser(id);
				pw.println("Successfully Deleted Account");
				req.getRequestDispatcher(req.getRequestURI()).include(req, resp);
			} catch (InvalidUsernameException e) {
				req.getRequestDispatcher("404.html").include(req, resp);
				pw.println(e.getMessage());
			}
		}else{
			req.getRequestDispatcher("404.html").include(req,resp);
			pw.println("The ID or User was null");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		doGet(req,resp);
	}
}
