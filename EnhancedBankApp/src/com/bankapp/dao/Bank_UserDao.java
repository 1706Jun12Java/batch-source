package com.bankapp.dao;

import com.bankapp.domain.Bank_User;

public interface Bank_UserDao {
	public Bank_User getBank_UserByID(String un, String pw);

}
