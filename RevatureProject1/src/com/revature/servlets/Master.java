package com.revature.servlets;

import com.revature.util.RequestHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by John on 7/13/2017.
 */
public class Master extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("MAster post");
        String rh = RequestHelper.process(request, response);
        request.getRequestDispatcher(rh).include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Master get");
        String rh = RequestHelper.process(request, response);
        System.out.println("rh is: " + rh);
        request.getRequestDispatcher(rh).include(request, response);
    }
}
