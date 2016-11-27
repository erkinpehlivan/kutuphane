package tr.gov.egm.library.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tr.gov.egm.library.entities.Category;

@Repository
public interface CategoryDAO extends CrudRepository<Category, Integer> {
//
//	@Query("from Category where id=:id")
//	Category getCategoryById(@Param("id") Integer id);
//	
//	
	
	
	
}