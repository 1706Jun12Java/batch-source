package com.revature.dao;

import com.revature.models.ReimbursementType;

public interface ReimbursementTypeDao
{
    boolean addReimbursementType(String type);

    ReimbursementType getReimbursementTypeById(int id);
}
