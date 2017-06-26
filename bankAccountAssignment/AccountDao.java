package com.revature.leibniz.bankAccountAssignment;

import java.util.ArrayList;

public interface AccountDao {
	public ArrayList<Account> getAllAccounts();
	public Account getAccount(int accountID);
	public void deleteAccount(int accountID);
}
