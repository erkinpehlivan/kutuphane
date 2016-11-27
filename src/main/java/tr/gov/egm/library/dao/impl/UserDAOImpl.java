package tr.gov.egm.library.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tr.gov.egm.library.dao.UserDAO;
import tr.gov.egm.library.entities.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void register(User user) {
		currentSession().save(user);
	}

	@Override
	public void changePassword(User user) {
		currentSession().update(user);
	}

}
