package tr.gov.egm.library.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import tr.gov.egm.library.dao.CategoryDAO;
import tr.gov.egm.library.entities.Category;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.DeleteException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;
@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Override
	public List<Category> getAllCategories() throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategory(Integer id) throws ReadException {
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

	@Override
	public void add(Category e) throws CreateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Category e) throws DeleteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Category e) throws UpdateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Category findById(Integer pk) throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findAll() throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

}
