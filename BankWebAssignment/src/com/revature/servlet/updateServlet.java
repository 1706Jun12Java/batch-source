package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.Exceptions.InvalidPasswordException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.domain.User;
import com.revature.main.ActionCaller;

public class updateServlet extends HttpServlet {

	public updateServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		req.getRequestDispatcher("Navbar.html").include(req, resp);
		HttpSession sess =req.getSession(false);
		User user = (User) sess.getAttribute("user");
		
			if(user!=null){
				int meep = Integer.parseInt(req.getParameter("optradio2"));
				try {
					ActionCaller.updateUser(req.getParameter("oldusername"), req.getParameter("newusername"), req.getParameter("password"), meep);
					pw.println("Successfully Updated Account");
					req.getRequestDispatcher(req.getRequestURI()).include(req, resp);
				} catch (InvalidUsernameException | InvalidPasswordException e) {
					req.getRequestDispatcher("404.html").include(req, resp);
					pw.println(e.getMessage());
				}
			}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		doGet(req,resp);
	}
}

