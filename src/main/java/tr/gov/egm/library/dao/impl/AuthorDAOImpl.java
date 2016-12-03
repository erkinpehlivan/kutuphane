package tr.gov.egm.library.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import tr.gov.egm.library.dao.AuthorDAO;
import tr.gov.egm.library.entities.Author;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.DeleteException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;

@Repository
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

	@Override
	public void add(Author e) throws CreateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Author e) throws DeleteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Author e) throws UpdateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Author findById(Integer pk) throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Author> findAll() throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

}
