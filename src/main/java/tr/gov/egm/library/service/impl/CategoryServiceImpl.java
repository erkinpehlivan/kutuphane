package tr.gov.egm.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.gov.egm.library.dao.CategoryDAO;
import tr.gov.egm.library.dao.GenericDAO;
import tr.gov.egm.library.entities.Category;
import tr.gov.egm.library.exceptions.service.BusinessException;
import tr.gov.egm.library.exceptions.service.CRUDException;
import tr.gov.egm.library.service.CategoryService;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category, Integer> implements CategoryService {

	private CategoryDAO dao;

	@Autowired
	public CategoryServiceImpl(@Qualifier("categoryDAOImpl") GenericDAO<Category, Integer> genericDAO) {
		super(genericDAO);
		this.dao = (CategoryDAO) genericDAO;
	}

	public List<Category> getAllCategories() throws BusinessException {
		List<Category> categories = null;
		try {
			categories = dao.findAll();
		} catch (CRUDException e) {
			throw new BusinessException("Kategoriler getirilemedi", e);
		}
		return categories;
	}

	public Category getCategory(Integer id) throws BusinessException {
		Category category = null;
		try {
			category = dao.findById(id);
		} catch (CRUDException e) {
			throw new BusinessException(id + " ID 'li kategori getirilemedi", e);
		}
		return category;

	}
@Transactional
	public void addCategory(Category category) throws BusinessException {
		try {
			dao.add(category);
		} catch (CRUDException e) {
			throw new BusinessException("Kategori eklenemedi", e);
		}
	}
@Transactional
	public void updateCategory(Category category) throws BusinessException {
		try {
			dao.update(category);
		} catch (CRUDException e) {
			throw new BusinessException("Kategori guncellenemedi", e);
		}
	}

}