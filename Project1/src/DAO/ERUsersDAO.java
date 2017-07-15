package DAO;

import java.util.List;

import CustomExceptions.InvalidNameException;
import CustomExceptions.UserNameTakenException;
import Domain.ERUser;

public interface ERUsersDAO {
	public List<ERUser> getUsers();

	public boolean updateUser(String username, String toChange, String change)
			throws UserNameTakenException, InvalidNameException;

	public boolean addUser(ERUser newUser) throws UserNameTakenException, InvalidNameException;

	ERUser getUsersByEmail(String email);
}
