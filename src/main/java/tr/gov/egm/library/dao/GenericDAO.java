package tr.gov.egm.library.dao;

import java.util.List;

import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.DeleteException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;

public interface GenericDAO<E,K> {

	void add(E e)throws CreateException ;
	void remove(E e)throws DeleteException;
	void update(E e)throws UpdateException;
	E findById(K pk)throws ReadException;
	
	List<E> findAll()throws ReadException;
}
