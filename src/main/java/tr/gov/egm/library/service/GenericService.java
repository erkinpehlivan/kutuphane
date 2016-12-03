/**
 * 
 */
package tr.gov.egm.library.service;

import java.util.List;

import tr.gov.egm.library.exceptions.service.BusinessException;

/**
 * @author EGM
 *
 */
public interface GenericService<E,K> {
	void add(E e)throws BusinessException ;
	void remove(E e)throws BusinessException;
	void update(E e)throws BusinessException;
	E findById(K pk)throws BusinessException;
	
	List<E> findAll()throws BusinessException;
}
