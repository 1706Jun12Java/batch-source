package Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import DAO.*;
import Domain.*;

public class ViewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		AccountDAO acc = new AccountImpl();
		PrintWriter pw = resp.getWriter();
		if ((String) sess.getAttribute("admin") != null) {
			pw.println("<h1>These are all the accounts</h1><ul>");
			for (Account a : acc.getAccounts()) {
				pw.println("<li>Account #" + a.getID() + " has $" + a.getAmount() + "</li>");
			}
			pw.println("</ul><br><a href=\"Userpage.html\">return</a>");
		} else {
			pw.println("<h1>These are your accounts</h1><ul>");
			for (Account a : acc.getAccounts((String) sess.getAttribute("username"))) {
				pw.println("<li>Account #" + a.getID() + " has $" + a.getAmount() + "</li>");
			}
			pw.println("</ul><br><a href=\"Userpage.html\">return</a>");
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();

	}

}
