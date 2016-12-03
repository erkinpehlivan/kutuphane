package tr.gov.egm.library.dao;

import java.util.List;

import tr.gov.egm.library.entities.Catalog;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;

public interface CatalogDAO extends GenericDAO<Catalog, Integer> {

	public List<Catalog> getAllCatalogs() throws ReadException ;
	
	public Catalog getCatalog(Integer id)throws ReadException;
	
	public void AddCatalog(Catalog catalog)throws CreateException;
	
	public void updateCatalog(Catalog catalog)throws UpdateException;
	
}