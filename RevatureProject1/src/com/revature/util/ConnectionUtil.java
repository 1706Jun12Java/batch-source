package com.revature.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * A simple utility that help connect to a database through JDBC
 * <p>
 * Created by John on 6/24/2017.
 */
public class ConnectionUtil
{
    public static Connection getConnection() throws IOException, SQLException
    {
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        Properties properties = new Properties();
        InputStream in = ConnectionUtil.class.getResourceAsStream("connection.properties");
        properties.load(in);

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        return DriverManager.getConnection(url, username, password);
    }
}
