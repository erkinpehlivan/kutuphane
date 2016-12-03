package tr.gov.egm.library.service;

import java.util.List;

import tr.gov.egm.library.entities.Log;
import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.exceptions.service.BusinessException;

public interface LogService {

	List<Log> getByUser(User user) throws BusinessException;

	List<Log> getAllLog() throws BusinessException;

}