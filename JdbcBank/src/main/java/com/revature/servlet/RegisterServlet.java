package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.util.ConnectionUtil;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String un = req.getParameter("userName");
		String fn = req.getParameter("firstname");
		String ln = req.getParameter("lastname");
		String pw = req.getParameter("password");
		String em = req.getParameter("email");

		try {
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			PreparedStatement ps = con.prepareStatement("INSERT INTO USERS (U_ID,U_USERNAME,U_PASSWORD,"
					+ "U_FIRSTNAME,U_LASTNAME,U_EMAIL,UR_ID)" + " VALUES(seq_auto.nextval,?,?,?,?,?,seq_auto.nextval)");

			ps.setString(1, un);
			ps.setString(2, pw);
			ps.setString(3, fn);
			ps.setString(4, ln);
			ps.setString(1, em);

			int i = ps.executeUpdate();
			if (i > 0)
				out.print("You are successfully registered...");

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		out.close();
	}
}