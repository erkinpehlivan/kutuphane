package tr.gov.egm.library.service;

import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.exceptions.service.BusinessException;

public interface UserService extends GenericService<User, Integer> {
	
	void register(User user) throws BusinessException;

	void changePassword(User user) throws BusinessException;

}
