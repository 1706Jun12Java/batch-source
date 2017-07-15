package com.revature.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.ReimbursementTicket;
import com.revature.domain.User;

@MultipartConfig(maxFileSize = 16177215)
public class NewRT extends HttpServlet{

	public NewRT() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*System.out.println("DO GET NEWRT");
		//resp.setContentType("text/html");

		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();

		req.getRequestDispatcher("load/top.html").include(req, resp);
		req.getRequestDispatcher("load/nav.html").include(req, resp);

		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.userLogin((String) session.getAttribute("username"),
				(String) session.getAttribute("password"));
		pw.println("<div class='container col-md-12'>");
		pw.println("<div class='col-md-3 .col-md-offset-3 centerDiv padTop'><b class='borderMe'>"
				+ "<span>User ID: </span><span id='empId'>" + user.getU_id() + "</span>" + "; Welcome, "
				+ user.getU_fname() + "</b></div>");
		pw.println("</div><br><br><br><br>");
		*/
		String amount = req.getParameter("nfname");
        //String description = req.getParameter("description");
        //String rtType = req.getParameter("rtType");
        System.out.println(amount);
		
		//req.getRequestDispatcher("load/bot.html").include(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("DO GET NEWRT");
		//resp.setContentType("text/html");

		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();

		req.getRequestDispatcher("load/top.html").include(req, resp);
		req.getRequestDispatcher("load/nav.html").include(req, resp);

		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.userLogin((String) session.getAttribute("username"),
				(String) session.getAttribute("password"));
		pw.println("<div class='container col-md-12'>");
		pw.println("<div class='col-md-3 .col-md-offset-3 centerDiv padTop'><b class='borderMe'>"
				+ "<span>User ID: </span><span id='empId'>" + user.getU_id() + "</span>" + "; Welcome, "
				+ user.getU_fname() + "</b></div>");
		pw.println("</div><br><br><br><br>");
		
		String amount = req.getParameter("amount");
        String description = req.getParameter("description");
        String rtType = req.getParameter("rtType");
        System.out.println(amount+description+rtType);
		
        System.out.println(amount);
        if(amount.equals("")){
        	pw.println("<h3 class='error'>You must enter an amount</h3");
			//resp.sendRedirect("newRTPage");
		}
        else if(!amount.equals("") && Double.parseDouble(amount)<=0 ){
            	pw.println("<h3 class='error'>Amount must be a number > 0</h3");
        	
        }
		else {
			System.out.println("in else");
			ReimbursementDaoImpl rDao = new ReimbursementDaoImpl();
			InputStream inputStream = null;
			//String file = req.getParameter("photo");
			//Blob b = file.get
			Part filePart = req.getPart("photo");
			System.out.println(filePart.toString());
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	        }
			ReimbursementTicket nrt = new ReimbursementTicket(Double.parseDouble(amount),description,null,user.getU_id(),Integer.parseInt(rtType),1);
			rDao.registerNewTicket(nrt, inputStream);
			pw.println("<h3 class='centerDic borderMe'>New ticket uplaoded</h3");
			
		}
        req.getRequestDispatcher("load/myRT.html").include(req, resp);
		req.getRequestDispatcher("load/bot.html").include(req, resp);
	}
}
