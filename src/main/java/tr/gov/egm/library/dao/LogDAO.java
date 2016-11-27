package tr.gov.egm.library.dao;

import org.springframework.data.repository.CrudRepository;

import tr.gov.egm.library.entities.Log;
import tr.gov.egm.library.entities.User;

public interface LogDAO extends CrudRepository<Log, Integer> {

	Log findByUser(User user);

}
