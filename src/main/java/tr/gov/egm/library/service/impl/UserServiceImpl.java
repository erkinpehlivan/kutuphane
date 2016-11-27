package tr.gov.egm.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.gov.egm.library.dao.UserDAO;
import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void register(User user) {
		userDAO.register(user);
	}

	@Override
	public void changePassword(User user) {
		userDAO.changePassword(user);
	}

}
