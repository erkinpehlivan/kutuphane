package tr.gov.egm.library.dao.impl;

import org.springframework.stereotype.Repository;

import tr.gov.egm.library.dao.BookDAO;
import tr.gov.egm.library.entities.Book;

@Repository
public class BookDAOImpl extends GenericDAOImpl<Book, Integer> implements BookDAO {

}
