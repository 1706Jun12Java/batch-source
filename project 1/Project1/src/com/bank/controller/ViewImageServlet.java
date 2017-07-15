package com.bank.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.UserDaoImpl;
import com.bank.util.ConnectionUtil;

@WebServlet("/ViewImageServlet")
public class ViewImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewImageServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("username");
		int id = UserDaoImpl.getUserByUsername(user);
		
		try{
		Connection con = ConnectionUtil.getConnectionFromFile();
		PreparedStatement ps = con.prepareStatement("SELECT R_RECEIPT FROM ERS_REIMBURSEMENTS WHERE R_ID = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
		Blob b = rs.getBlob("R_RECEIPT");
		response.setContentType("image/jpeg");
		response.setContentLength((int) b.length());
		InputStream is = b.getBinaryStream();
		OutputStream os = response.getOutputStream();
		byte buf[] = new byte[(int) b.length()];
		is.read(buf);
		os.write(buf);
		os.close();
		}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}
