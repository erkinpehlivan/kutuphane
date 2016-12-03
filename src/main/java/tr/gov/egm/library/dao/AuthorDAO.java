package tr.gov.egm.library.dao;

import java.util.List;

import tr.gov.egm.library.entities.Author;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;

public interface AuthorDAO extends GenericDAO<Author, Integer> {

	public List<Author> getAllAuthors()  throws ReadException ;
	
	public Author getAuthor(Integer id)throws ReadException;
	
	public void AddAuthor(Author author)throws CreateException;
	
	public void updateAuthor(Author author)throws UpdateException;
	
}