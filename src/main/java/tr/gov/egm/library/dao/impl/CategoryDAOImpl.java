package tr.gov.egm.library.dao.impl;

import org.springframework.stereotype.Repository;

import tr.gov.egm.library.dao.CategoryDAO;
import tr.gov.egm.library.entities.Category;

@Repository
public class CategoryDAOImpl extends GenericDAOImpl<Category, Integer> implements CategoryDAO {

}