package com.revature.dao;

import com.revature.models.ReimbursementStatus;

public interface ReimbursementStatusDao
{
    boolean addStatus(String status);

    ReimbursementStatus getStatusById(int id);
}
