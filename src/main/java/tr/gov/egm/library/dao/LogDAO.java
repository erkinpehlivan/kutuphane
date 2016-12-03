package tr.gov.egm.library.dao;

import java.util.List;

import tr.gov.egm.library.entities.Log;
import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.exceptions.dao.ReadException;

public interface LogDAO extends GenericDAO<Log, Integer> {

	List<Log> findByUser(User user) throws ReadException;

}