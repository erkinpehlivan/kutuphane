package tr.gov.egm.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.gov.egm.library.dao.CategoryDAO;
import tr.gov.egm.library.entities.Category;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;

@Service
public class CategoryService {

	@Autowired
	private CategoryDAO dao;

	public List<Category> getAllCategories() {
		List<Category> categories = null;
		try {
			categories = dao.getAllCategories();
		} catch (ReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return categories;
	}

	public Category getCategory(Integer id) {

		Category category = null;
		try {
			category = dao.getCategory(id);
		} catch (ReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return category;

	}
	
	public void addCategory(Category category) {

		try {
			 dao.AddCategory(category);
		} catch (CreateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateCategory(Category category) {

		try {
			 dao.updateCategory(category);
		} catch (UpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
