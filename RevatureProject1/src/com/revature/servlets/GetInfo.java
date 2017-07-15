package com.revature.servlets;

import com.revature.dao.oracle.ReimbursementOracleDao;
import com.revature.models.Reimbursement;
import play.libs.Json;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * Created by John on 7/15/2017.
 */
public class GetInfo extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("In GetInfo get");
        ArrayList<Reimbursement> list;

        try
        {
            ReimbursementOracleDao controller = new ReimbursementOracleDao();

            list = controller.getAllReimbursement();
            response.getWriter().println(Json.toJson(list));

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
