package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AccountDAO;
import DAO.AccountImpl;

public class DeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		AccountDAO acc = new AccountImpl();
		PrintWriter pw = resp.getWriter();
		if ((String) sess.getAttribute("admin") != null) {
			if (acc.deleteAccount(Integer.parseInt((String) sess.getAttribute("account")))) {
				pw.println("<h1>Deletion successful</h1>");
			} else {
				pw.println("<h1>Deletion failed</h1>");
			}
			pw.println("<a href=\"Userpage.html\">return</a>");
			sess.setAttribute("account", null);
		} else {
			if (acc.deleteAccount(Integer.parseInt((String) sess.getAttribute("account")),
					(String) sess.getAttribute("username"))) {
				pw.println("<h1>Deletion successful</h1>");
			} else {
				pw.println("<h1>Deletion failed</h1>");
			}
			pw.println("<a href=\"Userpage.html\">return</a>");
			sess.setAttribute("account", null);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
