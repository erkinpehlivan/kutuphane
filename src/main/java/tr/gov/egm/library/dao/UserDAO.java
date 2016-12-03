package tr.gov.egm.library.dao;

import org.springframework.stereotype.Repository;

import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.UpdateException;

@Repository
public interface UserDAO extends GenericDAO<User, Integer> {

	void register(User user) throws CreateException;

	void changePassword(User user) throws UpdateException;
	
}
