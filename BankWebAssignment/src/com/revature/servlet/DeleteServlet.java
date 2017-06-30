package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.Exceptions.InvalidAccountException;
import com.revature.domain.User;
import com.revature.main.ActionCaller;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String)request.getParameter("id");
		HttpSession sess = request.getSession(false);
		User user = (User) sess.getAttribute("user");
		PrintWriter pw = response.getWriter();
		if(id !=null && user != null){
			int i = Integer.parseInt(id);
			try {
				ActionCaller.deleteBankAccount(user, i);
				response.sendRedirect("signIn");
			} catch (InvalidAccountException e) {
				request.getRequestDispatcher("404.html").include(request, response);
				pw.println(e.getMessage());
			}
		}else{
			request.getRequestDispatcher("404.html").include(request, response);
			pw.println("The ID or User was null");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
