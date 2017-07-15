package com.revature.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.ConnectionUtil;

public class GetImageServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8239474402944303029L;

	public GetImageServlet() {
		// TODO Auto-generated constructor stub
	}

	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
//		resp.setContentType("document");
		try{
			int id = Integer.parseInt(req.getParameter("id"));
			Connection con = ConnectionUtil.getConnectionFromFile();
            PreparedStatement ps = con.prepareStatement("SELECT R_RECEIPE FROM ERS_REIMBURSEMENT WHERE R_ID = ?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Blob  b = rs.getBlob("R_RECEIPE");
            resp.setContentType("image/jpeg");
            resp.setContentLength( (int) b.length());
            InputStream is = b.getBinaryStream();
            OutputStream os = resp.getOutputStream();
            byte buf[] = new byte[(int) b.length()];
            is.read(buf);
            os.write(buf);
            os.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		doGet(req,resp);
	}
}
