package com.revature.dao;

import com.revature.domain.Bank_User;

public interface Bank_UserDao {
	public Bank_User getBank_UserByID(String un, String pw);

}
