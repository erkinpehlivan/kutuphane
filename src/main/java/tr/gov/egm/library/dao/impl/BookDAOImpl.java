package tr.gov.egm.library.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import tr.gov.egm.library.dao.BookDAO;
import tr.gov.egm.library.entities.Book;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.DeleteException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;

@Repository
public class BookDAOImpl implements BookDAO {

	@Override
	public List<Book> getAllBooks() throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBook(Integer id) throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AddBook(Book book) throws CreateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBook(Book book) throws UpdateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Book e) throws CreateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Book e) throws DeleteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Book e) throws UpdateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Book findById(Integer pk) throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findAll() throws ReadException {
		// TODO Auto-generated method stub
		return null;
	}

}
