package tr.gov.egm.library.dao;

import java.util.List;

import tr.gov.egm.library.entities.Category;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;


public interface CategoryDAO extends GenericDAO<Category, Integer>{

	public List<Category> getAllCategories() throws ReadException ;
	
	public Category getCategory(Integer id)throws ReadException;
	
	public void AddCategory(Category category)throws CreateException;
	
	public void updateCategory(Category category)throws UpdateException;
	
}