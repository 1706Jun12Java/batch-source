package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import DAO.AccountDAO;
import DAO.AccountImpl;

public class CreateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		AccountDAO acc = new AccountImpl();
		PrintWriter pw = resp.getWriter();
		System.out.println(sess.getAttribute("username"));
		if (acc.createAccount((String) sess.getAttribute("username"))) {
			pw.println("<h1>Account created successful</h1>");
		} else {
			pw.println("<h1>Account creation failed</h1>");
		}
		pw.println("<a href=\"Userpage.html\">return</a>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
