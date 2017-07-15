package com.revature.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.ReimbursementTicket;
import com.revature.domain.User;

public class ViewImage extends HttpServlet{

	public ViewImage() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();

		req.getRequestDispatcher("load/top.html").include(req, resp);
		req.getRequestDispatcher("load/nav.html").include(req, resp);
		String id=req.getParameter("id");
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.userLogin((String) session.getAttribute("username"),
				(String) session.getAttribute("password"));
		ReimbursementDaoImpl rDao = new ReimbursementDaoImpl();
		ReimbursementTicket rt = rDao.getReimbursementTicketById(Integer.parseInt(id));
		if(rt.getR_receipt()==null){
			pw.println("<h3 class='error'>No image for this ReimbursementTicket</h3");
		}
		else{
			try{
				
				Blob photo = rDao.getBlobById(Integer.parseInt(id));
			      InputStream in = photo.getBinaryStream();
			      int length = (int) photo.length();
			      int bufferSize = 1024;
			      byte[] buffer = new byte[bufferSize];

			      while ((length = in.read(buffer)) != -1) {
			        System.out.println("writing " + length + " bytes");
			        ServletOutputStream out = resp.getOutputStream();
			        out.write(buffer, 0, length);
			      }
			}
			catch(Exception e){
				pw.println("<h3 class='error'>"+e.getMessage()+"</h3>");
			}
			
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
