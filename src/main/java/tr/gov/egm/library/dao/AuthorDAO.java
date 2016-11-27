package tr.gov.egm.library.dao;

import org.springframework.data.repository.CrudRepository;

import tr.gov.egm.library.entities.Author;

public interface AuthorDAO extends CrudRepository<Author, Integer> {

}
