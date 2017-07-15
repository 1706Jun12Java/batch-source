package com.revature.dao;

import com.revature.models.Reimbursement;

import java.io.InputStream;
import java.util.List;

public interface ReimbursementDao
{
    Boolean createReimbursement(int amount, String description, InputStream image, int author, int type);

    Reimbursement getReimbursementById(int id);

    List<Reimbursement> getAllReimbursement();

}
