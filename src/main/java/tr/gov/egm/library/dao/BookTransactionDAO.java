/**
 * 
 */
package tr.gov.egm.library.dao;

import tr.gov.egm.library.entities.Book;
import tr.gov.egm.library.entities.BookTransaction;
import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.exceptions.service.CRUDException;

public interface BookTransactionDAO extends GenericDAO<BookTransaction, Integer> {
	
	/**
	 * kitap ver
	 * @param book
	 */
	public void giveBook(Book book,User user) throws CRUDException;
	
	/**
	 * kitabı geri al
	 * @param book
	 */
	public void takebackBook(Book book) throws CRUDException;
}
