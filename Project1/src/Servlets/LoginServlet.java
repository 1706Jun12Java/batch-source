package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ERUsersDAO;
import DAO.ERUsersDAOImpl;
import Domain.ERUser;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ERUsersDAO users = new ERUsersDAOImpl();
		HttpSession sess = req.getSession();
		boolean found = false;
		for (ERUser u : users.getUsers()) {
			if (sess.getAttribute("username").equals(u.getEmail())
					&& sess.getAttribute("password").equals(u.getPassword())) {
				sess.setAttribute("password", null);
				sess.setAttribute("firstname", u.getFirstname());
				sess.setAttribute("lastname", u.getLastname());
				sess.setAttribute("role", u.getRole());
				if (u.getRole().equalsIgnoreCase("employee")) {
					resp.sendRedirect("user.html");
				} else {
					resp.sendRedirect("manager.html");
				}
				found = true;
			}
		}
		if (!found) {
			PrintWriter pw = resp.getWriter();
			pw.println("<p color=\"red\">FAIL</p>");
			resp.sendRedirect("index.html");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ERUsersDAO users = new ERUsersDAOImpl();
		HttpSession sess = req.getSession();
		boolean found = false;
		for (ERUser u : users.getUsers()) {
			if (sess.getAttribute("username") == u.getEmail() && sess.getAttribute("password") == u.getPassword()) {
				sess.setAttribute("password", null);
				resp.sendRedirect("user.html");
				found = true;
			}
		}
		if (!found) {
			PrintWriter pw = resp.getWriter();
			pw.println("<p color=\"red\">FAIL</p>");
			resp.sendRedirect("index.html");
		}
	}

}
