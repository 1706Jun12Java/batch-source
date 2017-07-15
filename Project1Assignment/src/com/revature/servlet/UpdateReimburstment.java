package com.revature.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.Exceptions.InvalidReimburstmentException;
import com.revature.dao.ReimburstmentImpl;
import com.revature.domain.E_User;

public class UpdateReimburstment extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			doPost(request,response);
		}
		
		@Override
		protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
			ReimburstmentImpl ri = new ReimburstmentImpl();
		    BufferedReader reader = request.getReader();
		    int ID = Integer.parseInt(reader.readLine());
		    String app = reader.readLine();
		    HttpSession sess = request.getSession(false);
		    if(sess!= null && sess.getAttribute("user") !=null){
		    	E_User user = (E_User) sess.getAttribute("user");
		    try {
				ri.updateReimburstment(ID, app, user.getUserID());
				response.getWriter().println("SUCCESS");
			} catch (InvalidReimburstmentException e) {
				response.getWriter().println("ERROR");
				response.getWriter().println(e.getMessage());
			} catch(SQLException e){
				e.printStackTrace();
			}
		    } else {
		    	response.getWriter().println("Login");
		    }
		}
}
