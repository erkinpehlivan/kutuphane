package tr.gov.egm.library.service;

import tr.gov.egm.library.entities.Book;
import tr.gov.egm.library.entities.BookTransaction;
import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.exceptions.service.BusinessException;

public interface BookTransactionService extends GenericService<BookTransaction, Integer> {

	public void giveBookToAUser(Book book, User user) throws BusinessException;
	public void takeBackBook(Book book) throws BusinessException;
}
