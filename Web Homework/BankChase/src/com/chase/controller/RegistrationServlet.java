package com.chase.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chase.dao.*;

import com.chase.util.ConnectionUtil;


public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RegistrationServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");  
	    PrintWriter pw = response.getWriter();
	    
	    String firstname = request.getParameter("f_name");
	    String lastname = request.getParameter("l_name");
	    String phoneNum = request.getParameter("phoneNum");
	    String email = request.getParameter("email");
	    String username =request.getParameter("username");  
	    String password =request.getParameter("password"); 
	    
	    try{
	    	ConnectionUtil.getConnectionFromFile();
	    	RegisterDaoImpl.signUp(firstname,lastname,phoneNum,email,username,password);
	    	RequestDispatcher rd = request.getRequestDispatcher("registrationcomplete.html");
	    	rd.forward(request, response);
	    	pw.println("registration complete");
	    } 
	    catch (Exception e) {
			e.printStackTrace();
		}

	}

}
