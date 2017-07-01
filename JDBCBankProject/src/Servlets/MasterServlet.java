package Servlets;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import Util.ServletUtil;

import java.io.*;;

public class MasterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		String toGo = ServletUtil.process(req, resp);
		resp.sendRedirect(toGo);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		// These cannot be null
		if (req.getParameter("username") != null) {
			sess.setAttribute("username", req.getParameter("username"));
			sess.setAttribute("password", req.getParameter("password"));
		}
		// these can
		sess.setAttribute("amount", req.getParameter("amount_of_money"));
		sess.setAttribute("account", req.getParameter("account"));
		sess.setAttribute("login", null);
		String toGo = ServletUtil.process(req, resp);
		resp.sendRedirect(toGo);
	}

}
