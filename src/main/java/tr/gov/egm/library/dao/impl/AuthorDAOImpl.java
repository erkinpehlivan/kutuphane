package tr.gov.egm.library.dao.impl;

import java.util.List;

import tr.gov.egm.library.dao.AuthorDAO;
import tr.gov.egm.library.entities.Author;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;

public class AuthorDAOImpl implements AuthorDAO {

	@Override
	public List<Author> getAllAuthors() throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Author getAuthor(Integer id) throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AddAuthor(Author author) throws CreateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAuthor(Author author) throws UpdateException {
		// TODO Auto-generated method stub
		
	}

}
