package com.revature.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Exceptions.InvalidReimburstmentException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.dao.ReimburstmentDao;
import com.revature.dao.ReimburstmentImpl;
import com.revature.domain.E_User;
import com.revature.domain.Reimburstment;

public class ViewByUser extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doPost(request,response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession sess = request.getSession(false);
		BufferedReader reader = request.getReader();
	    int ID = Integer.parseInt(reader.readLine());

		if(sess != null && sess.getAttribute("user") != null){
			E_User user = (E_User) sess.getAttribute("user");
			if(user.isManager()){
					ReimburstmentDao ri = new ReimburstmentImpl();
					try {
						List<Reimburstment> all = ri.getReimburstmentByUser(ID);
						ObjectMapper om = new ObjectMapper();
						response.getWriter().println("List");
						response.getWriter().println(om.writeValueAsString(all));
					} catch (InvalidReimburstmentException | InvalidUsernameException e) {
						// TODO Auto-generated catch block
						response.getWriter().println("Error");
						response.getWriter().println(e.getMessage());
						e.printStackTrace();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				
			}
		} else {
			response.getWriter().println("Login");
		}
	}
	}

