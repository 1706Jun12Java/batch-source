package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.domain.User;
import com.revature.main.ActionCaller;


@WebServlet("/CreateBankAccountServlet")
public class CreateBankAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CreateBankAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess = request.getSession(false);
		User user = (User) sess.getAttribute("user");
		PrintWriter pw = response.getWriter();
		if(user!=null){
			String option = (String) request.getParameter("optradio");
		if(option != null){	
			if(option.equalsIgnoreCase("checking")){
				ActionCaller.createAccount(user, 1);
				response.sendRedirect("signIn");
			}else if(option.equalsIgnoreCase("saving")){
				ActionCaller.createAccount(user, 0);
				response.sendRedirect("signIn");
			}else{
				System.out.println("Something is wrong");
			}
		}else{
			request.getRequestDispatcher("404.html").include(request, response);
			pw.println("No option was selected");
		}
			
		}else{
			request.getRequestDispatcher("404.html").include(request, response);
			pw.println("User was null");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
