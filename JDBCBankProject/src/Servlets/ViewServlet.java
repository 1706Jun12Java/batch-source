package Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import DAO.*;
import Domain.*;

public class ViewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		AccountDAO acc = new AccountImpl();
		PrintWriter pw = resp.getWriter();
		pw.println("<h1>These are your accounts</h1><ul>");
		for (Account a : acc.getAccounts((String) sess.getAttribute("username"))) {
			pw.println("<li>Account #" + a.getID() + " has $" + a.getAmount() + "</li>");
		}
		pw.println("</ul><br><a href=\"Userpage.html\">return</a>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();

	}

}
