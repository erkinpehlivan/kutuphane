package tr.gov.egm.library.service;

import java.util.Date;

import tr.gov.egm.library.entities.Book;
import tr.gov.egm.library.entities.Catalog;
import tr.gov.egm.library.entities.Rezervation;
import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.exceptions.service.BusinessException;

public interface RezervationService {
	
	public void makeReservationWithCatalog(Catalog catalog,Date startDate,Date endDate, User user) throws BusinessException;
	public void makeReservationWithBook(Book book,Date startDate,Date endDate, User user)throws BusinessException;
	public void cancelReservation(Rezervation rezervation) throws BusinessException;
	public void getAvailableBookCountForDate(Catalog catalog, Date date) throws BusinessException;

}
