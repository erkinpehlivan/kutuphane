package tr.gov.egm.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.gov.egm.library.dao.LogDAO;
import tr.gov.egm.library.entities.Log;
import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.exceptions.service.BusinessException;
import tr.gov.egm.library.exceptions.service.CRUDException;
import tr.gov.egm.library.service.LogService;

@Service
public class LogServiceImpl implements LogService {

	@Autowired
	private LogDAO dao;

	@Override
	public List<Log> getByUser(User user) throws BusinessException {
		List<Log> logs;
		try {
			logs = (List<Log>) dao.findByUser(user);
		} catch (CRUDException e) {
			throw new BusinessException("Kullanici loglari getirilemedi", e);
		}
		return logs;
	}

	@Override
	public List<Log> getAllLog() throws BusinessException {
		List<Log> logs = null;
		try {
			logs = (List<Log>) dao.findAll();
		} catch (CRUDException e) {
			throw new BusinessException("Loglar getirilemedi", e);
		}
		return logs;
	}

}
