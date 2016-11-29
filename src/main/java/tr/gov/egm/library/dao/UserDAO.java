package tr.gov.egm.library.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tr.gov.egm.library.entities.User;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {

//	void register(User user);

//	void changePassword(User user);
	
}
