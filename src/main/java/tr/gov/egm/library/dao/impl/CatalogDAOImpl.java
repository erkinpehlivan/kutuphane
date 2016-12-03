package tr.gov.egm.library.dao.impl;

import java.util.List;

import tr.gov.egm.library.dao.CatalogDAO;
import tr.gov.egm.library.entities.Book;
import tr.gov.egm.library.entities.Catalog;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;

public class CatalogDAOImpl implements CatalogDAO {

	@Override
	public List<Book> getAllCatalogs() throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Catalog getCatalog(Integer id) throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AddCatalog(Catalog catalog) throws CreateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCatalog(Catalog catalog) throws UpdateException {
		// TODO Auto-generated method stub
		
	}

}
