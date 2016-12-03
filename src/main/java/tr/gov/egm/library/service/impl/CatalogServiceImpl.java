package tr.gov.egm.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tr.gov.egm.library.dao.CatalogDAO;
import tr.gov.egm.library.dao.GenericDAO;
import tr.gov.egm.library.entities.Catalog;
import tr.gov.egm.library.exceptions.service.BusinessException;
import tr.gov.egm.library.exceptions.service.CRUDException;
import tr.gov.egm.library.service.CatalogService;

@Service
public class CatalogServiceImpl extends GenericServiceImpl<Catalog, Integer> implements CatalogService {

	private CatalogDAO dao;

	@Autowired
	public CatalogServiceImpl(@Qualifier("catalogDAOImpl") GenericDAO<Catalog, Integer> genericDAO) {
		super(genericDAO);
		this.dao = (CatalogDAO) genericDAO;
	}

	public List<Catalog> getAllCatalogs() throws BusinessException {
		List<Catalog> catalog = null;
		try {
			catalog = dao.findAll();
		} catch (CRUDException e) {
			throw new BusinessException("Katalog getirilemedi", e);
		}
		return catalog;
	}

	public Catalog getCatalog(Integer id) throws BusinessException {
		Catalog catalog = null;
		try {
			catalog = dao.findById(id);
		} catch (CRUDException e) {
			throw new BusinessException(id + " ID 'li katalog getirilemedi", e);
		}
		return catalog;

	}

	public void addCatalog(Catalog catalog) throws BusinessException {
		try {
			dao.add(catalog);
		} catch (CRUDException e) {
			throw new BusinessException("Katalog eklenemedi", e);
		}
	}

	public void updateCatalog(Catalog catalog) throws BusinessException {
		try {
			dao.update(catalog);
		} catch (CRUDException e) {
			throw new BusinessException("Katalog guncellenemedi", e);
		}
	}

}