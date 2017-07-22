package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Util.ServletUtil;

public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MasterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String toGo = ServletUtil.process(req, resp);
		resp.sendRedirect(toGo);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		if (req.getParameter("password") != null) {
			sess.setAttribute("username", req.getParameter("username"));
			sess.setAttribute("password", req.getParameter("password"));
		}
		String toGo = ServletUtil.process(req, resp);
		resp.sendRedirect(toGo);
	}

}
