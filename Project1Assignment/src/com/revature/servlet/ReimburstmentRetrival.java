package com.revature.servlet;

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

public class ReimburstmentRetrival extends HttpServlet{

	public ReimburstmentRetrival() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess = request.getSession(false);
		if(sess != null && sess.getAttribute("user") != null){
			E_User user = (E_User) sess.getAttribute("user");
			if(user.isManager()){
				Object obj = sess.getAttribute("tableList");
				if(obj == null){
					ReimburstmentDao ri = new ReimburstmentImpl();
					try {
						List<Reimburstment> all = ri.getAllReimburstments();
						ObjectMapper om = new ObjectMapper();
						response.getWriter().println("Init");
						response.getWriter().println(om.writeValueAsString(all));
						sess.setAttribute("tableList", all);
					} catch (InvalidReimburstmentException | InvalidUsernameException e) {
						// TODO Auto-generated catch block
						response.getWriter().println("Error");
						response.getWriter().println(e.getMessage());
						e.printStackTrace();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}else{
					ReimburstmentDao ri = new ReimburstmentImpl();
					List<Reimburstment> viewTable = (List<Reimburstment>) obj;
					ArrayList<Reimburstment> update = new ArrayList<Reimburstment>();
					
					try {
						List<Reimburstment> databaseTable =  ri.getAllReimburstments();
						for(Reimburstment database:databaseTable){
							boolean flagged = false;
							for(Reimburstment view:viewTable){
								
								boolean matched = false;
								if(view.getId() == database.getId()){
									matched = true;
									if(!view.getStatus().equalsIgnoreCase(database.getStatus())){
										flagged = true;
									}
								}
								if(!matched){
									flagged = true;
								}
							}
							if(flagged){
								update.add(database);
							}
						}
						if(!update.isEmpty()){
						ObjectMapper om = new ObjectMapper();
						response.getWriter().println("List");
						response.getWriter().println(om.writeValueAsString(update));
						} else {
							response.getWriter().println("Good");
						}
					} catch (InvalidReimburstmentException | InvalidUsernameException e) {
						// TODO Auto-generated catch block
						response.getWriter().println("Error");
						response.getWriter().println(e.getMessage());
						e.printStackTrace();
					} catch (SQLException e){
						e.printStackTrace();
					}
				}
			} else {
				Object obj = sess.getAttribute("tableList");
				if(obj == null){
					ReimburstmentDao ri = new ReimburstmentImpl();
					try {
						List<Reimburstment> all = ri.getReimburstmentByUser(user.getUserID());
						ObjectMapper om = new ObjectMapper();
						response.getWriter().println("Init");
						response.getWriter().println(om.writeValueAsString(all));
						sess.setAttribute("tableList", all);
					} catch (InvalidReimburstmentException | InvalidUsernameException e) {
						// TODO Auto-generated catch block
						response.getWriter().println("Error");
						response.getWriter().println(e.getMessage());
						e.printStackTrace();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}else{
					ReimburstmentDao ri = new ReimburstmentImpl();
					List<Reimburstment> viewTable = (List<Reimburstment>) obj;
					ArrayList<Reimburstment> update = new ArrayList<Reimburstment>();
					
					try {
						List<Reimburstment> databaseTable =  ri.getReimburstmentByUser(user.getUserID());
						for(Reimburstment database:databaseTable){
							boolean flagged = false;
							for(Reimburstment view:viewTable){
								
								boolean matched = false;
								if(view.getId() == database.getId()){
									matched = true;
									if(!view.getStatus().equalsIgnoreCase(database.getStatus())){
										flagged = true;
									}
								}
								if(!matched){
									flagged = true;
								}
							}
							if(flagged){
								update.add(database);
							}
						}
						if(!update.isEmpty()){
						ObjectMapper om = new ObjectMapper();
						response.getWriter().println("List");
						response.getWriter().println(om.writeValueAsString(update));
						} else {
							response.getWriter().println("Good");
						}
					} catch (InvalidReimburstmentException | InvalidUsernameException e) {
						// TODO Auto-generated catch block
						response.getWriter().println("Error");
						response.getWriter().println(e.getMessage());
						e.printStackTrace();
					} catch (SQLException e){
						e.printStackTrace();
					}
				}
			}
		} else {
			response.getWriter().println("Login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
