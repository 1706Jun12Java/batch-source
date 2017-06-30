package com.revature.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by John on 6/29/2017.
 */
public class RequestHelper
{
    public static String process(HttpServletRequest req, HttpServletResponse res)
    {
        // needs fixing
        switch (req.getParameter("destination"))
        {
            case "login":
                return "/login";
            default:
                return "404.html";
        }
    }
}
