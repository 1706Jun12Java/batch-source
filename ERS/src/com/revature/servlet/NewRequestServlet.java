package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.util.ConnectionUtil;

public class NewRequestServlet extends HttpServlet{

	public NewRequestServlet() {
		
	}
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Insert obj = new Insert();
		//obj.InsertRecord();
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session=request.getSession(false);  
        String n=(String)session.getAttribute("uname");
        out.println("<h2>your username is: "+n+"</h2>");
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			
			//HttpSession session=request.getSession(false);  
	        //String n=(String)session.getAttribute("uname");
			
			int amount = Integer.parseInt(request.getParameter("amount"));
			String description = request.getParameter("descr");
			//int userid = Integer.parseInt(request.getParameter("uid"));
			String expensetype = request.getParameter("expensetype");
			int rttype=0;
			switch(expensetype){
			case "BUSINESS": rttype = 1; break;
			case "TRAVEL": rttype = 2; break;
			case "LEISURE": rttype = 3; break;
			default: rttype = 1;
			}
			
			PreparedStatement ps = null;
			
			String sql = "INSERT INTO ers_reimbursements (R_AMOUNT,R_DESCRIPTION,R_SUBMITTED,U_ID_AUTHOR,RT_TYPE,RS_STATUS) VALUES (?,?,SYSDATE,(SELECT U_ID from ERS_USERS where U_USERNAME=?),?,?)";
			ps = con.prepareStatement(sql);
			ps.setInt(1, amount);
			ps.setString(2, description);
			ps.setString(3, n);
			ps.setInt(4, rttype);
			ps.setInt(5, 1);
			int i = ps.executeUpdate();
			
			if(i>0){			
			RequestDispatcher rd1 = request.getRequestDispatcher("RequestCreatedServlet");
			rd1.forward(request, response);			
			} else {
				out.println("<font color='red'><b>Please enter all information</b></font>");
                RequestDispatcher rd = request.getRequestDispatcher("newrequest.html");
                rd.include(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
}
	
