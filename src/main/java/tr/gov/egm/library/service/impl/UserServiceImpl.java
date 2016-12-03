package tr.gov.egm.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.gov.egm.library.dao.GenericDAO;
import tr.gov.egm.library.dao.UserDAO;
import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.exceptions.service.BusinessException;
import tr.gov.egm.library.exceptions.service.CRUDException;
import tr.gov.egm.library.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends GenericServiceImpl<User, Integer> implements UserService {

	private UserDAO userDAO;
	
	@Autowired
	public UserServiceImpl(@Qualifier("userDAOImpl")GenericDAO<User, Integer> genericDAO) {
		super(genericDAO);
		userDAO = (UserDAO)genericDAO;
	}


	/**
	 * Registers new user
	 */
	@Override
	public void register(User user) throws BusinessException {
		try {
			userDAO.register(user);
		} catch (CRUDException e) {
			throw new BusinessException("Kullanıcı olşturulamadı", e);
		}
	}

	/**
	 * changes users's password
	 */
	@Override
	public void changePassword(User user) throws BusinessException {

		try {
			userDAO.changePassword(user);
		} catch (CRUDException e) {
			throw new BusinessException("Parola değiştirilemedi",e);
		}
	}

}