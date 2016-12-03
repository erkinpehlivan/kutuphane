package tr.gov.egm.library.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import tr.gov.egm.library.dao.GenericDAO;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.DeleteException;
import tr.gov.egm.library.exceptions.dao.ReadException;

public abstract class GenericDAOImpl<E, K extends Serializable> implements GenericDAO<E, K> {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Class<? extends E> entityType;
	
	protected Session currentSesison(){
		return sessionFactory.getCurrentSession();
	}
	
	
	/**
	 * 
	 */
	public GenericDAOImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pType = (ParameterizedType)t;
		entityType=(Class<? extends E>) pType.getActualTypeArguments()[0];
	}


	/* (non-Javadoc)
	 * @see tr.gov.egm.library.dao.GenericDAO#add(java.lang.Object)
	 */
	@Override
	public void add(E e) throws CreateException {
		try {
			currentSesison().save(e);
		} catch (Exception ex) {
			throw new CreateException("Kayıt ekleme başarısız",ex);
		}
		
	}


	/* (non-Javadoc)
	 * @see tr.gov.egm.library.dao.GenericDAO#remove(java.lang.Object)
	 */
	@Override
	public void remove(E e) throws DeleteException {
		try {
			currentSesison().delete(e);
		} catch (Exception ex) {
			throw new DeleteException("Silme işlemi başarısız", ex);
		}
		
	}


	/* (non-Javadoc)
	 * @see tr.gov.egm.library.dao.GenericDAO#update(java.lang.Object)
	 */
	@Override
	public void update(E e) {
		currentSesison().update(e);
		
	}


	/* (non-Javadoc)
	 * @see tr.gov.egm.library.dao.GenericDAO#findById(java.lang.Object)
	 */
	@Override
	public E findById(K pk) throws ReadException {
		try {
			return currentSesison().get(entityType, pk);
		} catch (Exception ex) {
			throw new ReadException("Kayıt getirilirken hata oluştu.", ex);
		}
	}


	/* (non-Javadoc)
	 * @see tr.gov.egm.library.dao.GenericDAO#findAll()
	 */
	@Override
	public List<E> findAll() throws ReadException {
		try {
			return currentSesison().createCriteria(entityType).list();
		} catch (Exception ex) {
			throw new ReadException("Kayıt listelenirken hata oluştu.", ex);
		}
	}
	
	
}
