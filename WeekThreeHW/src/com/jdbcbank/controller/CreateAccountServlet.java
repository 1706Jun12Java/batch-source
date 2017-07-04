package com.jdbcbank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jdbcbank.domain.User;

/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet(asyncSupported = true)
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		System.out.println("here");
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("account added");
		HttpSession session = req.getSession(false);
		int userID = (int) session.getAttribute("userid");
		User u = new User(userID);
		try {
			u.addAccount();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.sendRedirect("profile.html");
	}

}
