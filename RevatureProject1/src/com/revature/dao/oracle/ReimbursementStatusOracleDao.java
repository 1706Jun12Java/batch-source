package com.revature.dao.oracle;

import com.revature.dao.ReimbursementStatusDao;
import com.revature.models.ReimbursementStatus;
import com.revature.util.ConnectionUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by John on 7/12/2017.
 */
public class ReimbursementStatusOracleDao implements ReimbursementStatusDao
{
    private Connection connection = ConnectionUtil.getConnection();

    public ReimbursementStatusOracleDao() throws IOException, SQLException
    {
    }

    @Override
    public boolean addStatus(String status)
    {
        int result;

        try
        {
            String sql = "INSERT INTO REIMBURSEMENT_STATUS (STATUS) VALUES (?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, status);

            result = ps.executeUpdate();
            connection.close();

            if (result != 0)
                return true;
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public ReimbursementStatus getStatusById(int id)
    {
        //TODO
        return null;
    }
}
