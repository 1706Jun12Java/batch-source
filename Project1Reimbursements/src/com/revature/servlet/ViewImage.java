package com.revature.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.ReimbursementTicket;
import com.revature.domain.User;
import com.revature.util.ConnectionUtil;

public class ViewImage extends HttpServlet{

	public ViewImage() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		//PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();

		req.getRequestDispatcher("load/top.html").include(req, resp);
		req.getRequestDispatcher("load/nav.html").include(req, resp);
		String id=req.getParameter("id");
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.userLogin((String) session.getAttribute("username"),
				(String) session.getAttribute("password"));
		ReimbursementDaoImpl rDao = new ReimbursementDaoImpl();
		ReimbursementTicket rt = rDao.getReimbursementTicketById(Integer.parseInt(id));
		if(rt.getR_receipt()==null){
			//pw.println("<h3 class='error'>No image for this ReimbursementTicket</h3");
			req.getRequestDispatcher("load/noIMG.html").include(req, resp);
		}
		else{
			try{
				
	            
				Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
				String sql = "SELECT R_RECEIPT FROM ERS_REIMBURSEMENTS WHERE R_ID = ?";
				PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1,Integer.parseInt(id));
	            ResultSet rs = ps.executeQuery();
	            rs.next();
	            Blob  b = rs.getBlob("R_RECEIPT");
	            resp.setContentType("image");
	            resp.setContentLength( (int) b.length());
	            InputStream is = b.getBinaryStream();
	            ServletOutputStream os = resp.getOutputStream();
	            byte buf[] = new byte[(int) b.length()];
	            is.read(buf);
	            os.write(buf);
	            os.close();
			}
			catch(Exception e){
				//pw.println("<h3 class='error'>"+e.getMessage()+"</h3>");
			}
			
			
		}
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
