package tr.gov.egm.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.gov.egm.library.dao.BookDAO;
import tr.gov.egm.library.dao.GenericDAO;
import tr.gov.egm.library.entities.Book;
import tr.gov.egm.library.exceptions.service.BusinessException;
import tr.gov.egm.library.exceptions.service.CRUDException;
import tr.gov.egm.library.service.BookService;

@Service
public class BookServiceImpl extends GenericServiceImpl<Book, Integer> implements BookService {

	private BookDAO dao;

	@Autowired
	public BookServiceImpl(@Qualifier("bookDAOImpl") GenericDAO<Book, Integer> genericDAO) {
		super(genericDAO);
		this.dao = (BookDAO) genericDAO;
	}

	public List<Book> getAllBooks() throws BusinessException {
		List<Book> books = null;
		try {
			books = dao.findAll();
		} catch (CRUDException e) {
			throw new BusinessException("Kitaplar getirilemedi", e);
		}
		return books;
	}

	public Book getBook(Integer id) throws BusinessException {
		Book book = null;
		try {
			book = dao.findById(id);
		} catch (CRUDException e) {
			throw new BusinessException(id + " ID 'li kitap getirilemedi", e);
		}
		return book;

	}
	@Transactional
	public void addBook(Book book) throws BusinessException {
		try {
			dao.add(book);
		} catch (CRUDException e) {
			throw new BusinessException("Kitap eklenemedi", e);
		}
	}
	@Transactional
	public void updateBook(Book book) throws BusinessException {
		try {
			dao.update(book);
		} catch (CRUDException e) {
			throw new BusinessException("Kitap guncellenemedi", e);
		}
	}

}