package tr.gov.egm.library.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import tr.gov.egm.library.entities.Book;
import tr.gov.egm.library.entities.Catalog;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;

@Repository
public interface CatalogDAO {

	public List<Book> getAllCatalogs() throws ReadException ;
	
	public Catalog getCatalog(Integer id)throws ReadException;
	
	public void AddCatalog(Catalog catalog)throws CreateException;
	
	public void updateCatalog(Catalog catalog)throws UpdateException;
	
}