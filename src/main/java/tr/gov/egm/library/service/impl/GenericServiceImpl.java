package tr.gov.egm.library.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.gov.egm.library.dao.GenericDAO;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.DeleteException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;
import tr.gov.egm.library.exceptions.service.BusinessException;
import tr.gov.egm.library.service.GenericService;

@Service
@Transactional
public abstract class GenericServiceImpl<E,K> implements GenericService<E, K> {

	private GenericDAO<E, K> genericDAO;
	public GenericServiceImpl(GenericDAO<E, K> genericDAO) {
		this.genericDAO=genericDAO; 
	}
	/* (non-Javadoc)
	 * @see tr.gov.egm.library.service.GenericService#add(java.lang.Object)
	 */
	@Override
	public void add(E e) throws BusinessException {
		try {
			genericDAO.add(e);
		} catch (CreateException ex) {
			throw new BusinessException("Ekleme işleminde hata oluştu.", ex);
		}
		
	}
	/* (non-Javadoc)
	 * @see tr.gov.egm.library.service.GenericService#remove(java.lang.Object)
	 */
	@Override
	public void remove(E e) throws BusinessException {
		try {
			genericDAO.remove(e);
		} catch (DeleteException ex) {
			throw new BusinessException("Silme işleminde hata oluştu.", ex);
		}
		
	}
	/* (non-Javadoc)
	 * @see tr.gov.egm.library.service.GenericService#update(java.lang.Object)
	 */
	@Override
	public void update(E e) throws BusinessException {
		try {
			genericDAO.update(e);
		} catch (UpdateException ex) {
			throw new BusinessException("Güncelleme işleminde hata oluştu.", ex);
		}
		
	}
	/* (non-Javadoc)
	 * @see tr.gov.egm.library.service.GenericService#findById(java.lang.Object)
	 */
	@Override
	public E findById(K pk) throws BusinessException {
		try {
			return genericDAO.findById(pk);
		} catch (ReadException ex) {
			throw new BusinessException("Kayıt bulma işleminde hata oluştu.", ex);
		}
	}
	/* (non-Javadoc)
	 * @see tr.gov.egm.library.service.GenericService#findAll()
	 */
	@Override
	public List<E> findAll() throws BusinessException {
		try {
			return genericDAO.findAll();
		} catch (ReadException ex) {
			throw new BusinessException("Kayıt listeleme işleminde hata oluştu.", ex);
		}
	}
	
	
}
