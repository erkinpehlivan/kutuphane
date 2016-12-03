package tr.gov.egm.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.gov.egm.library.dao.BookDAO;
import tr.gov.egm.library.entities.Book;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.dao.UpdateException;

@Service
public class BookService {

	@Autowired
	private BookDAO dao;

	public List<Book> getAllBooks() {
		List<Book> books = null;
		try {
			books = dao.getAllBooks();
		} catch (ReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return books;
	}

	public Book getBook(Integer id) {

		Book book = null;
		try {
			book = dao.getBook(id);
		} catch (ReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return book;

	}
	
	public void addBook(Book book) {

		try {
			 dao.AddBook(book);
		} catch (CreateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateBook(Book book) {

		try {
			 dao.updateBook(book);
		} catch (UpdateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
