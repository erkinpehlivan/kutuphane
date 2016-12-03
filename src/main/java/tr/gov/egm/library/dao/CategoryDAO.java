package tr.gov.egm.library.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import tr.gov.egm.library.entities.Author;
import tr.gov.egm.library.entities.Category;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;

@Repository
public interface CategoryDAO{

	public List<Category> getAllCategories() throws ReadException ;
	
	public Author getCategory(Integer id)throws ReadException;
	
	public void AddCategory(Category category)throws CreateException;
	
	public void updateCategory(Category category)throws UpdateException;
	
}