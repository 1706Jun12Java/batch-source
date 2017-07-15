package com.bank.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bank.dao.ReimbursementDaoImpl;
import com.bank.dao.UserDaoImpl;

@MultipartConfig(maxFileSize = 16177215)
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UploadServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part file = request.getPart("receipt");
		InputStream image = file.getInputStream();
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		
		int r_id = Integer.parseInt(request.getParameter("r_id"));
		String user = (String) session.getAttribute("username");
		int id = UserDaoImpl.getUserByUsername(user);
		ReimbursementDaoImpl.submitReceipt(image, id,r_id);
		RequestDispatcher rd = request.getRequestDispatcher("UploadImage.jsp");
		rd.include(request, response);
		pw.print("<script>var p1 = document.getElementById('p1');"
				+ "p1.innerHTML = 'Successfully Uploaded Receipt';"
				+ "setTimeout(function(){ p1.innerHTML='' }, 2000);</script>");
		}	
	}

