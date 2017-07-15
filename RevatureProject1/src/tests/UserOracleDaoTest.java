package tests;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;

/**
 * Created by John on 7/12/2017.
 */
public class UserOracleDaoTest
{
    private Connection connection;

    @org.junit.Before
    public void setUp() throws Exception
    {
//        connection = ConnectionUtil.getConnectionFromH2("jdbc:h2:mem:");
    }

    @org.junit.After
    public void tearDown() throws Exception
    {
        connection.close();
    }

    @Test
    public void testH2Connection() throws Exception
    {
        assertNotNull(connection);
    }

    @Test
    public void createEmployeeUser() throws Exception
    {

    }

    @Test
    public void getUserByUsername() throws Exception
    {
    }

    @Test
    public void getUsers() throws Exception
    {
    }

    @Test
    public void getUserById() throws Exception
    {
    }

    @Test
    public void deleteUser() throws Exception
    {
    }

    @Test
    public void hashPassword() throws Exception
    {
    }

    @Test
    public void login() throws Exception
    {
    }

    @Test
    public void update() throws Exception
    {
    }

}