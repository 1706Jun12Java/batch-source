package Servlets;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.codehaus.jackson.map.ObjectMapper;
import DAO.RequestDAO;
import DAO.RequestDAOImpl;
import MISC.PsuedoInt;

public class RejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RejectServlet() {
		super();

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession sess = req.getSession();
		try {
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = req.getReader();
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			String data = buffer.toString();
			ObjectMapper map = new ObjectMapper();
			PsuedoInt appID = map.readValue(data, PsuedoInt.class);
			RequestDAO reqDAO = new RequestDAOImpl();
			reqDAO.reject(appID.getValue(), (String) sess.getAttribute("username"));
		} catch (Exception e) {
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
		}
	}

}
