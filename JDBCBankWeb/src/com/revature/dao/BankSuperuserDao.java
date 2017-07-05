package com.revature.dao;

import java.util.List;

import com.revature.domain.BankUser;

public interface BankSuperuserDao {
		public int login(String username, String password);
		public int registerNewBankUser(String username, String password);
		public List<BankUser> getUsers();
		public int deleteAllBankUsers();
		public void logout();
	

}
