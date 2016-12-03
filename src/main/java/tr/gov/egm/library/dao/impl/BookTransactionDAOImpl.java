package tr.gov.egm.library.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import tr.gov.egm.library.dao.BookTransactionDAO;
import tr.gov.egm.library.entities.Book;
import tr.gov.egm.library.entities.BookTransaction;
import tr.gov.egm.library.entities.Catalog;
import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.exceptions.service.CRUDException;

@Repository
public class BookTransactionDAOImpl extends GenericDAOImpl<BookTransaction, Integer> implements BookTransactionDAO {

	@Override
	public void giveBook(Book book, User user) throws CRUDException {
		try {
			if (isThereAnyRezervationWithThisBookForNow(book)) {
				throw new Exception("Kitap rezerve edilmiş durumda.");
			} else if (userHasAnyOtherCopyOfThisBook(book, user)) {
				throw new Exception("Kullanıcıda bu kitaptan var.");
			} else if (isBookStateAvailableToBeGivenToAUser(book)) {
				BookTransaction bts = new BookTransaction();
				bts.setBook(book);
				bts.setGivenDate(new Date());
				bts.setState(BookTransaction.GIVE);
				bts.setUser(user);

				add(bts);
			} else {
				throw new Exception("Kitap müdait değil.");
			}
		} catch (Exception e) {
			throw new CRUDException("Kitap verme işlemi başarısız.", e);
		}

	}

	@Override
	public void takebackBook(Book book) throws CRUDException {
		try {
			String sql = "select bts from booktransactions bts where bts.BOOK_ID=:book_id and bts.state=:state";
			Query query = currentSession().createSQLQuery(sql).addEntity(BookTransaction.class);
			;
			query.setParameter("book_id", book.getId());
			query.setParameter("state", BookTransaction.GIVE);

			BookTransaction bts = (BookTransaction) query.list().get(0);

			bts.setState(BookTransaction.BACK);
			bts.setBackDate(new Date());

			update(bts);
		} catch (Exception e) {
			throw new CRUDException("Kitap teslim edilemedi", e);
		}
	}

	private boolean isBookStateAvailableToBeGivenToAUser(Book book) throws CRUDException {
		try {
			boolean result = false;
			String sql = "select bts from booktransactions bts where bts.BOOK_ID=:book_id and bts.state=:state";
			Query query = currentSession().createSQLQuery(sql).addEntity(BookTransaction.class);
			query.setParameter("book_id", book.getId());
			query.setParameter("state", BookTransaction.GIVE);
			if (query.list().size() > 0) {
				result = false;
			} else {
				result = true;
			}
			return result;
		} catch (Exception e) {
			throw new CRUDException("error at isBookStateAvailableToBeGiven", e);
		}
	}

	private boolean isThereAnyRezervationWithThisBookForNow(Book book) throws CRUDException {
		try {
			boolean result = false;
			String sql = "select rez from rezervation rez where rez.BOOK_ID=:book_id and rez.startDate<=:date and rez.endDate>:date";
			Query query = currentSession().createSQLQuery(sql).addEntity(BookTransaction.class);
			query.setParameter("book_id", book.getId());
			query.setParameter("date", new Date());
			if (query.list().size() > 0) {
				result = true;
			} else {
				result = false;
			}
			return result;
		} catch (Exception e) {
			throw new CRUDException("error at isThereAnyRezervationWithThisBookForNow", e);
		}
	}

	private boolean userHasAnyOtherCopyOfThisBook(Book book, User user) throws CRUDException {
		try {
			boolean result = false;
			String sql = "select bts from bts from booktransactions bts where bts.BOOK_ID in :book_ids and bts.state=:state and bts.USER_ID=:user_id";
			Query query = currentSession().createSQLQuery(sql).addEntity(BookTransaction.class);
			query.setParameter("book_id", BookIdsFromCatalog(book.getCatalog()));
			query.setParameter("state", BookTransaction.GIVE);
			query.setParameter("user_id", user.getId());

			if (query.list().size() > 0) {
				result = true;
			} else {
				result = false;
			}

			return result;
		} catch (Exception e) {
			throw new CRUDException("error at userHasAnyOtherCopyOfThisBook", e);
		}
	}

	/**
	 * 
	 * @param catalog
	 * @return
	 */
	private List<Integer> BookIdsFromCatalog(Catalog catalog) {
		List<Integer> ids = new ArrayList<>();
		for (Book book : catalog.getBooks()) {
			ids.add(book.getId());
		}

		return ids;
	}

}
