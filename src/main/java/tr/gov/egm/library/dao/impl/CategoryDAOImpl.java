package tr.gov.egm.library.dao.impl;

import java.util.List;

import tr.gov.egm.library.dao.CategoryDAO;
import tr.gov.egm.library.entities.Author;
import tr.gov.egm.library.entities.Category;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;

public class CategoryDAOImpl implements CategoryDAO {

	@Override
	public List<Category> getAllCategories() throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author getCategory(Integer id) throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AddCategory(Category category) throws CreateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCategory(Category category) throws UpdateException {
		// TODO Auto-generated method stub
		
	}

}
