package com.revature.leibniz.bankAccountAssignment;

import java.util.ArrayList;

public class AccountImpDao implements AccountDao {
	private ArrayList<Account> accountList;
	
	
	public AccountImpDao() {
		accountList = new ArrayList<>();
	}
	
	@Override
	public ArrayList<Account> getAllAccounts() {
		return accountList;
	}

	@Override
	public Account getAccount(int accountID) {
		Account account = null;
		for(int i = 0; i < accountList.size(); i++) {
			if(accountID == accountList.get(i).getAccountID()) {
				account = accountList.get(i);
			}
		}
		return account;
	}

	@Override
	public void deleteAccount(int accountID) {
		int index = accountList.indexOf(getAccount(accountID));
		if(index >= 0) {
			accountList.remove(index);
		}
	}

}
