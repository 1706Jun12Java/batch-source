package DAO;

import java.util.List;
import Domain.BankUser;

public interface BankUserDAO {
	public List<BankUser> getBankUsers();
	
	public boolean addUser(String username, String password);
}
