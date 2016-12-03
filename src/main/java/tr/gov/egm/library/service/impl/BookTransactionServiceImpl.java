/**
 * 
 */
package tr.gov.egm.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tr.gov.egm.library.dao.BookTransactionDAO;
import tr.gov.egm.library.dao.GenericDAO;
import tr.gov.egm.library.entities.Book;
import tr.gov.egm.library.entities.BookTransaction;
import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.exceptions.service.BusinessException;
import tr.gov.egm.library.exceptions.service.CRUDException;
import tr.gov.egm.library.service.BookTransactionService;


@Service
public class BookTransactionServiceImpl extends GenericServiceImpl<BookTransaction, Integer>
		implements BookTransactionService {
	
	private BookTransactionDAO bookTransactionDAO;

	@Autowired
	public BookTransactionServiceImpl(@Qualifier("bookTransactionDAO")GenericDAO<BookTransaction, Integer> genericDAO) {
		super(genericDAO);
		bookTransactionDAO = (BookTransactionDAO) genericDAO;
	}

	@Override
	public void giveBookToAUser(Book book, User user) throws BusinessException {
		try {
			bookTransactionDAO.giveBook(book, user);
		} catch (CRUDException e) {
			throw new BusinessException("Kitap teslim işlemi başarız", e);
		}
		
	}

	@Override
	public void takeBackBook(Book book) throws BusinessException {
		try {
			bookTransactionDAO.takebackBook(book);
		} catch (CRUDException e) {
			throw new BusinessException("Kitap teslim alma işlemi başarız", e);
		}
		
	}

}
