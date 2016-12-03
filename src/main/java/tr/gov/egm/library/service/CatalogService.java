package tr.gov.egm.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.gov.egm.library.dao.CatalogDAO;
import tr.gov.egm.library.entities.Catalog;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;

@Service
public class CatalogService {

	@Autowired
	private CatalogDAO dao;

	public List<Catalog> getAllCatalogs() {
		List<Catalog> catalogs = null;
		try {
			catalogs = dao.getAllCatalogs();
		} catch (ReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return catalogs;
	}

	public Catalog getCatalog(Integer id) {

		Catalog catalog = null;
		try {
			catalog = dao.getCatalog(id);
		} catch (ReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return catalog;

	}
	
	public void addCatalog(Catalog catalog) {

		try {
			 dao.AddCatalog(catalog);
		} catch (CreateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateCatalog(Catalog catalog) {

		try {
			 dao.updateCatalog(catalog);
		} catch (UpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}