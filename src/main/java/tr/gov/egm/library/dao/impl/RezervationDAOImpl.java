package tr.gov.egm.library.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tr.gov.egm.library.dao.RezervationDAO;
import tr.gov.egm.library.entities.Book;
import tr.gov.egm.library.entities.Catalog;
import tr.gov.egm.library.entities.Rezervation;
import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.service.CRUDException;

@NoRepositoryBean
public class RezervationDAOImpl implements RezervationDAO {

//	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 
	 * @param catalog
	 * @param user
	 * @param startDate
	 * @param endDate
	 * @throws CRUDException
	 */
	@Override
	public void rezerveBookToAUserFromCatalog(Catalog catalog, User user, Date startDate, Date endDate) throws CRUDException {
		try {
			Book book = findAvailableBookForDates(catalog, startDate, endDate);
			boolean status = checkStatus(book, user, startDate, endDate);
			if (status) {
				makeReservation(book, user, startDate, endDate);
			}
		} catch (Exception e) {
			throw new CRUDException("rezerveBookToAUserFromCatalog hatası", e);
		}
	}

	/**
	 * 
	 * @param book
	 * @param user
	 * @param startDate
	 * @param endDate
	 */
	@Override
	public void rezerveCertainBookToAUser(Book book, User user, Date startDate, Date endDate) throws CRUDException {

		try {
			if (checkStatus(book, user, startDate, endDate)) {
				makeReservation(book, user, startDate, endDate);
			}
		} catch (Exception e) {
			throw new CRUDException("Rezervasyon Yapılamadı", e);
		}
	}

	/**
	 * 
	 * @param catalog
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws NullPointerException
	 */
	@SuppressWarnings("unchecked")
	private Book findAvailableBookForDates(Catalog catalog, Date startDate, Date endDate) throws ReadException {
		try {
			String sql = "select b from book b where b.id not in (" + "select BOOK_ID from rezervation r where r.startDate=:startDate and r.endDate=:endDate and r.state='started'" + ") and b.id in :idList";

			Query availableBooks = sessionFactory.openSession().createSQLQuery(sql).addEntity(Book.class);

			availableBooks.setParameter("startDate", startDate);
			availableBooks.setParameter("endDate", endDate);
			availableBooks.setParameterList("idList", BookIdsFromCatalog(catalog));

			List<Book> books = availableBooks.list();

			Book book;
			if (books != null && books.size() > 0) {
				book = books.get(0);
				return book;
			} else {
				throw new SQLException("Uygun kitap bulunamadı.");
			}
		} catch (Exception e) {
			throw new ReadException("Uygun kitap bulunamadı.", e);
		}

	}

	/**
	 * 
	 * @param book
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private boolean isBookAvailable(Book book, Date startDate, Date endDate) throws ReadException {
		try {
			boolean result = false;

			// if book is available ?
			String isBookAvailableSql = "select r from rezervation r where r.BOOK_ID=:book_id and r.startDate>=:startDate and r.endDate<=:endDate and r.state!='cancelled'";
			Query isBookAvailableQuery = sessionFactory.openSession().createSQLQuery(isBookAvailableSql).addEntity(Rezervation.class);
			isBookAvailableQuery.setParameter("book_id", book.getId());
			isBookAvailableQuery.setParameter("startDate", startDate);
			isBookAvailableQuery.setParameter("endDate", endDate);

			int bookReservationCount = isBookAvailableQuery.list().size();

			if (bookReservationCount <= 0) {
				result = true;
			}

			return result;
		} catch (Exception e) {
			throw new ReadException("Kitap uygun değil.", e);
		}
	}

	/**
	 * 
	 * @param user
	 * @param catalog
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ReadException
	 */
	private boolean isUserAvailableForCatalogAndDates(User user, Catalog catalog, Date startDate, Date endDate) throws ReadException {
		try {
			boolean result = false;
			String sql = "select r from rezervation r where r.USER_ID=:user_id and r.startDate>=:startDate and r.endDate<=:endDate and r.r.BOOK_ID in (" + "select book.id from book where book.CATALOG_ID=:catalog_id" + ") and r.status!='cancelled'";
			Query userHasBook = sessionFactory.openSession().createSQLQuery(sql).addEntity(Rezervation.class);
			userHasBook.setParameter("user_id", user.getId());
			userHasBook.setParameter("startDate", startDate);
			userHasBook.setParameter("endDate", endDate);

			int count = userHasBook.list().size();

			if (count <= 0) {
				result = true;
			}

			return result;
		} catch (Exception e) {
			throw new ReadException("Kullanıcı uygun değil.", e);
		}
	}

	/**
	 * 
	 * @param book
	 * @param user
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws CreateException
	 */
	@Transactional
	private boolean makeReservation(Book book, User user, Date startDate, Date endDate) throws CreateException {

		try {
			boolean result = false;

			Rezervation rezervation = new Rezervation();
			rezervation.setBook(book);
			rezervation.setUser(user);
			rezervation.setStartDate(startDate);
			rezervation.setEndDate(endDate);

			rezervation.setState(Rezervation.REGISTERED);

			try {
				sessionFactory.openSession().save(rezervation);
				result = true;
			} catch (Exception e) {
				result = false;
			}

			return result;
		} catch (Exception e) {
			throw new CreateException("Rezervasyon yapılırken hata oldu", e);
		}
	}

	/**
	 * 
	 * @param book
	 * @param user
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ReadException
	 */
	private boolean checkStatus(Book book, User user, Date startDate, Date endDate) throws ReadException {
		try {
			boolean status = false;

			boolean bookStatus = isBookAvailable(book, startDate, endDate);

			boolean userStatus = isUserAvailableForCatalogAndDates(user, book.getCatalog(), startDate, endDate);

			if (bookStatus && userStatus) {
				status = true;
			}

			return status;
		} catch (Exception e) {
			throw new ReadException("checkStatus ta hata ", e);
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

	/**
	 * 
	 * @param rezervation
	 * @throws CreateException
	 */
	@Override
	public void cancelRezervation(Rezervation rezervation) throws CreateException {
		try {
			rezervation.setState(Rezervation.CANCELLED);
			sessionFactory.openSession().save(rezervation);
		} catch (Exception e) {
			throw new CreateException("cancelRezervation hatası", e);
		}
	}

	@Override
	public int availableBookCountForDate(Catalog catalog, Date date) throws ReadException {
		try {
			String isBookAvailableSql = "select r from rezervation r where r.BOOK_ID in :book_id and (" + "((" + "r.startDate>:date or r.endDate<:date" + ") and r.state!='cancelled') or ((r.startDate<:date or r.endDate>:date) and r.state='cancelled')" + ")'";
			Query isBookAvailableQuery = sessionFactory.openSession().createSQLQuery(isBookAvailableSql).addEntity(Rezervation.class);
			isBookAvailableQuery.setParameter("book_id", BookIdsFromCatalog(catalog));
			isBookAvailableQuery.setParameter("date", date);

			int bookReservationCount = isBookAvailableQuery.list().size();
			return bookReservationCount;
		} catch (Exception e) {
			throw new ReadException("availableBookCountForDate hatası", e);
		}
	}

}
