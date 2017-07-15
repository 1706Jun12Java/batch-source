package com.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ManagerCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ManagerCheckServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		response.setContentType("text/html"); 
          
        HttpSession session = request.getSession(false);  
        if(session!=null){  
        if(session.getAttribute("musername") != null){ 
        response.sendRedirect("ManagerHomePage.jsp"); 
        }  
        }
        else{    
            response.sendRedirect("ManagerLogin.html");
        }   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

	}

}
