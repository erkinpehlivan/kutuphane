package tr.gov.egm.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.gov.egm.library.dao.LogDAO;
import tr.gov.egm.library.entities.Log;
import tr.gov.egm.library.entities.User;

@Service
public class LogService {

	@Autowired
	private LogDAO dao;

	public List<Log> getir(User user) {
		List<Log> logs = (List<Log>) dao.findByUser(user);

		return logs;
	}

	public List<Log> getAllLog() {

		List<Log> logs = (List<Log>) dao.findAll();
		
		return logs;

	}

}
