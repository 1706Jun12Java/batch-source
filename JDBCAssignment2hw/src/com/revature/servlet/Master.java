package com.revature.servlet;

import com.revature.util.RequestHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by John on 6/29/2017.
 */
public class Master extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String rh = RequestHelper.process(req, resp);
        req.getRequestDispatcher(rh).include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String rh = RequestHelper.process(req, resp);
        req.getRequestDispatcher(rh).include(req, resp);
    }
}
