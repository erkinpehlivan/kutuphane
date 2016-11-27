package tr.gov.egm.library.service;

import tr.gov.egm.library.entities.User;

public interface UserService {
	
	void register(User user);

	void changePassword(User user);

}
