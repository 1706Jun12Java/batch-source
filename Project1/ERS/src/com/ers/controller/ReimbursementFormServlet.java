package com.ers.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.ers.dao.RTypeDao;
import com.ers.dao.RTypeDaoLogic;
import com.ers.dao.ReimbursementDao;
import com.ers.dao.ReimbursementDaoLogic;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns={"/ReimbursementFormServlet"})
@MultipartConfig
public class ReimbursementFormServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7051978212479378929L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession();
		
		int employeeId = (int) session.getAttribute("employeeId");
		
		if (session!=null){
			
			ObjectMapper mapper = new ObjectMapper();
			String employeeFirstName = mapper.writeValueAsString(session.getAttribute("employeeFirstName"));
			resp.getWriter().print(employeeFirstName + " ");
			
			req.getRequestDispatcher("views/html/reimbursementForm.html").include(req, resp);


		}
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession(false);
		ReimbursementDao reim = new ReimbursementDaoLogic();
				
		RTypeDao rTypeimpl = new RTypeDaoLogic();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		
		
		
		if (session!=null){
		int employeeId = (int) session.getAttribute("employeeId");
		
		String amount = req.getParameter("amount");
		BigDecimal amt = new BigDecimal(amount);
		
		System.out.println(amount);
		System.out.println(amt);
		String description = req.getParameter("description");
	
		//converting the uploaded file into inputstream
		Part filePart = req.getPart("receipt"); // get <input type="file" where name="image">
		String filePath = filePart.getSubmittedFileName(); //get complete file name with path and directories
		Path p = Paths.get(filePath); //create a path object
		String fileName = p.getFileName().toString(); //get file name from Path object
		InputStream fileContent = filePart.getInputStream(); //convert Part data to input stream
		
		
		String rType = req.getParameter("selectReimbursementType");
		
		if(session!=null){
			if (amt.compareTo(BigDecimal.valueOf(0))==-1){
				session.setAttribute("error", "You can't ask for a negative amount");
				resp.sendRedirect("reimbursementform");
			}
			else {
				session.setAttribute("employeeId", employeeId);
				reim.submitReimbursementRequest(amt, description, fileContent, timestamp, employeeId, rTypeimpl.getIdOfType(rType));
				resp.sendRedirect("employee-profile");
			}
		}
		
		
		}

	}

}
