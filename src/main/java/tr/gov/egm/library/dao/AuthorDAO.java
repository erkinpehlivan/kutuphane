package tr.gov.egm.library.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tr.gov.egm.library.entities.Author;

@Repository
public interface AuthorDAO extends CrudRepository<Author, Integer> {

	@Query("from Author where name like '%:adi%'")
	List<Author> findAuthorByName(@Param("name") String name);

}