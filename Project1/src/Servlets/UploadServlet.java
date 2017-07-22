package Servlets;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DAO.RequestDAO;
import DAO.RequestDAOImpl;
import Domain.RRequest;

@MultipartConfig(maxFileSize = 16177215)
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadServlet() {
		super();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		InputStream in = null;
		Part filePart = req.getPart("image");
		in = filePart.getInputStream();
		Double amount = Double.parseDouble(req.getParameter("amount"));
		DecimalFormat format = new DecimalFormat("0.00");
		String amtStr = format.format(amount);
		RRequest newReq = new RRequest(Float.parseFloat(amtStr), req.getParameter("desc"),
				(String) sess.getAttribute("username"), req.getParameter("type"), in);
		RequestDAO rqDAO = new RequestDAOImpl();
		rqDAO.push(newReq);
		resp.sendRedirect("user.html");
	}
}
