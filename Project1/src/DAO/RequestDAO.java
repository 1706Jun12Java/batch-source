package DAO;

import java.sql.SQLRecoverableException;
import java.util.List;
import Domain.RRequest;

public interface RequestDAO {
	public void push(RRequest req);

	public void approve(int reqID, String username);
	
	public void reject(int reqID, String username);
	
	public List<RRequest> getRequests() throws SQLRecoverableException;
	
	public List<RRequest> getRequests(String username) throws SQLRecoverableException;
}
