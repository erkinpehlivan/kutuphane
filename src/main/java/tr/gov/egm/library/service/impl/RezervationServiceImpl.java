/**
 * 
 */
package tr.gov.egm.library.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.gov.egm.library.dao.RezervationDAO;
import tr.gov.egm.library.entities.Book;
import tr.gov.egm.library.entities.Catalog;
import tr.gov.egm.library.entities.Rezervation;
import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.exceptions.service.BusinessException;
import tr.gov.egm.library.exceptions.service.CRUDException;
import tr.gov.egm.library.service.RezervationService;

/**
 * @author EGM
 *
 */
@Service
public class RezervationServiceImpl implements RezervationService {
	
	@Autowired
	private RezervationDAO rezervationDAO;

	@Override
	public void makeReservationWithCatalog(Catalog catalog, Date startDate, Date endDate, User user) throws BusinessException {
		try {
			rezervationDAO.rezerveBookToAUserFromCatalog(catalog, user, startDate, endDate);
		} catch (CRUDException ex) {
			throw new BusinessException("Rezervasyon yapılamadı.", ex);
		}
	}

	@Override
	public void makeReservationWithBook(Book book, Date startDate, Date endDate, User user) throws BusinessException {
		try {
			rezervationDAO.rezerveCertainBookToAUser(book, user, startDate, endDate);
		} catch (CRUDException e) {
			throw new BusinessException("Rezervasyon yapılamadı", e);
		}
		
	}

	@Override
	public void cancelReservation(Rezervation rezervation) throws BusinessException {
		try {
			rezervationDAO.cancelRezervation(rezervation);
		} catch (CRUDException e) {
			throw new BusinessException("Rezervasyon iptaql edilemedi", e);
		}
		
	}

	@Override
	public void getAvailableBookCountForDate(Catalog catalog, Date date) throws BusinessException {
		try {
			rezervationDAO.availableBookCountForDate(catalog, date);
		} catch (CRUDException e) {
			throw new BusinessException("Uygun kitap sayısı alınamadı.", e);
		}
		
	}

}
