package Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import DAO.*;
import Domain.*;

public class LoginServlet extends HttpServlet {

	public LoginServlet() {

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		BankUserDAO bk = new BankUserImpl();
		for (BankUser b : bk.getBankUsers()) {
			if (sess.getAttribute("username").equals(b.getUsername())
					&& sess.getAttribute("password").equals(b.getPassword())) {
				sess.setAttribute("login", "successful");
				resp.sendRedirect("userpage");

			}
		}
		if (sess.getAttribute("login") == null)
			resp.sendRedirect("404.html");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		BankUserDAO bk = new BankUserImpl();
		for (BankUser b : bk.getBankUsers()) {
			if (sess.getAttribute("username").equals(b.getUsername())
					&& sess.getAttribute("password").equals(b.getPassword())) {
				sess.setAttribute("login", "successful");
				resp.sendRedirect("LoggedIn.html");
			}
		}

	}

}
