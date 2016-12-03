package tr.gov.egm.library.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import tr.gov.egm.library.entities.Book;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;

@Repository
public interface BookDAO{

	public List<Book> getAllBooks() throws ReadException ;
	
	public Book getBook(Integer id)throws ReadException;
	
	public void AddBook(Book book )throws CreateException;
	
	public void updateBook(Book book)throws UpdateException;
	
}