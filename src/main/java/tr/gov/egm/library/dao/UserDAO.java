package tr.gov.egm.library.dao;

import tr.gov.egm.library.entities.User;

public interface UserDAO {

	void register(User user);

	void changePassword(User user);
	
}
