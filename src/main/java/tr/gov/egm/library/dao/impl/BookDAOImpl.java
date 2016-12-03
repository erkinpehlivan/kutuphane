package tr.gov.egm.library.dao.impl;

import java.util.List;

import tr.gov.egm.library.dao.BookDAO;
import tr.gov.egm.library.entities.Book;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;

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

}
