package com.bank.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bank.user.Reimbursements;
import com.bank.user.Users;


public interface UserDao {
    List<Users> getUsers();
    Users getUserById(int id);
    boolean submitReimbursement(Users user, String amount, String category, String description, InputStream inputStream);
    boolean updateUser(int u_ID, String firstname, String lastname, String email, String password);
    public String getFLName(Connection con, int u_Id_Author) throws SQLException;
    public String getStatus(Connection con, int rs_Status_Id) throws SQLException;
    public String getType(Connection con, int rt_Type_Id) throws SQLException;
    public List<Reimbursements> getReimbursements(int u_ID, String role);
    public boolean updateReimbursements(int reimburseInfo, int reimburseId, int userID);
}
