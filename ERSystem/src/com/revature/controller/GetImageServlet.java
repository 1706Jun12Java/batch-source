package com.revature.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EReimbursementDao;
import com.revature.dao.EReimbursementDaoImpl;

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
		resp.setContentType("image/jpeg");
		try{
			int id = (int) req.getAttribute("id");
			EReimbursementDao ED = new EReimbursementDaoImpl();
			Blob img = ED.getImageById(id);
			InputStream is = img.getBinaryStream();
            OutputStream os = resp.getOutputStream();
            byte buf[] = new byte[(int) img.length()];
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
