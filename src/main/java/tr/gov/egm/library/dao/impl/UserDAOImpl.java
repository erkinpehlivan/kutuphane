package tr.gov.egm.library.dao.impl;

import org.springframework.stereotype.Repository;

import tr.gov.egm.library.dao.UserDAO;
import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.UpdateException;

@Repository
public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO {

	/**
	 * Checks if user exists
	 * Registers new user
	 */
	@Override
	public void register(User user) throws CreateException {
		try {
			// check if user exists?
			if(!isUserExists(user)){
				add(user);
			}else{
				throw new Exception("Kullanıcı mevcut");
			}
		} catch (Exception e) {
			throw new CreateException("Kullanıcı kayıt işlemi başarısız.", e) ;
		} 
		
	}

	/**
	 * Checks if user exists
	 * changes password
	 */
	@Override
	public void changePassword(User user) throws UpdateException {
		try {
			// check if user exists
			if(isUserExists(user)){
				// is password set?
				if(user.getPassword()!=null){
					update(user);
				}else{
					throw new Exception("Parola belirlenmemiş.");
				}
			}
		} catch (Exception e) {
			throw new UpdateException("Parola değiştirme başarısız", e);
		}
		
	}
	
	/**
	 * check if user exists
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private boolean isUserExists(User user) throws Exception{
		if(findById(user.getId())!=null){
			return true;
		}else{
			return false;
		}
	}

	
}
