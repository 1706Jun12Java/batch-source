package com.bank.util;

import com.bank.dao.ReimbursementDaoImpl;
import com.bank.dao.ReimbursementStatusDaoImpl;
import com.bank.dao.ReimbursementTypeDaoImpl;
import com.bank.dao.UserDaoImpl;
import com.bank.dao.UserRoleDaoImpl;

public class test {

	public static void main(String[] args) {

		//ReimbursementDaoImpl.reimburseRequest(10, "business", 2, 1);
		//System.out.println(UserDaoImpl.getAllEmployees());
		//System.out.println(UserDaoImpl.viewEmployeeInfo(2));
		//System.out.println(ReimbursementDaoImpl.viewPendingReimbursements(6));
		//System.out.println("______________________");
		//System.out.println(ReimbursementDaoImpl.viewResolvedReimbursements(6));
		//System.out.println(UserRoleDaoImpl.geUserRoleById(1));
		//System.out.println(UserDaoImpl.getUserById(6));
		//System.out.println(ReimbursementDaoImpl.viewAllPendingReimbursements());
		//System.out.println(ReimbursementTypeDaoImpl.getReimbursementTypeById(1));
		//System.out.println(ReimbursementStatusDaoImpl.getReimbursementStatusById(1));
		//System.out.println(ReimbursementDaoImpl.getReimbursementByUsername(6));
		System.out.println(UserDaoImpl.getUserByUsername("Patrick"));
	}

}
