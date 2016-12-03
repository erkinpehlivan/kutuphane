package tr.gov.egm.library.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import tr.gov.egm.library.dao.CatalogDAO;
import tr.gov.egm.library.entities.Catalog;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.DeleteException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;
@Repository
public class CatalogDAOImpl implements CatalogDAO {

	@Override
	public List<Catalog> getAllCatalogs() throws ReadException {
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

	@Override
	public void add(Catalog e) throws CreateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Catalog e) throws DeleteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Catalog e) throws UpdateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Catalog findById(Integer pk) throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Catalog> findAll() throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

}
