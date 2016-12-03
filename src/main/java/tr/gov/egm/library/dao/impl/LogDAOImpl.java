package tr.gov.egm.library.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import tr.gov.egm.library.dao.LogDAO;
import tr.gov.egm.library.entities.Log;
import tr.gov.egm.library.entities.User;

@Repository
public class LogDAOImpl extends GenericDAOImpl<Log, Integer> implements LogDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Log> findByUser(User user) {
		String sql = "from Log where user = :user";
		Query logByUser = currentSession().createQuery(sql);
		logByUser.setParameter("user", user);
		return logByUser.list();
	}
}