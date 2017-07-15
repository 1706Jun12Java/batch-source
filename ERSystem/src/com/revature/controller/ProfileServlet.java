package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.revature.dao.ERUserDao;
import com.revature.dao.ERUserDaoImpl;
import com.revature.domain.User;

public class ProfileServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6417669087954185488L;
	public ProfileServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		resp.setContentType("application/json");
		ERUserDao UD = new ERUserDaoImpl();
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		try{
			User u = UD.getUserById((int)session.getAttribute("userID"));
			String json = mapper.writeValueAsString(u);
			System.out.println(json);
			pw.write(json);
		}catch(NullPointerException e){
			pw.write("{\"redirect\":\"login.html\"}");
		}catch(Exception e){
			pw.write("{\"error\":\""+ e.toString() +"\"}");
			e.printStackTrace();
		}
		
	}
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		resp.setContentType("application/json");
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		ERUserDao UD = new ERUserDaoImpl();
		try{
			int id = (int)session.getAttribute("userID");
			int userID = Integer.parseInt( req.getParameter("userID"));
			if(id!=userID){
				String error = "{\"redirect\": \"login.html\"}";
				pw.write(error);
			}else{
				String firstname = req.getParameter("firstname");
				String lastname = req.getParameter("lastname");
				String password = req.getParameter("password");
				int result = UD.upDateUserInfo(password,firstname,lastname,userID);
				pw.write("{\"status\":\""+result+"\"}");
			}
		}catch(Exception e){
			e.printStackTrace();
			String error = "{\"error\": \"oops something went wrong, try again later\"}";
			pw.write(error);
		}
	}
}
