package tr.gov.egm.library.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import tr.gov.egm.library.dao.GenericDAO;
import tr.gov.egm.library.dao.RezervationDAO;
import tr.gov.egm.library.entities.Book;
import tr.gov.egm.library.entities.Catalog;
import tr.gov.egm.library.entities.Rezervation;
import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.exceptions.service.BusinessException;
import tr.gov.egm.library.exceptions.service.CRUDException;
import tr.gov.egm.library.service.RezervationService;

@Service
public class RezervationServiceImpl extends GenericServiceImpl<Rezervation, Integer> implements RezervationService {

	private RezervationDAO rezervationDAO;

	@Autowired
	public RezervationServiceImpl(@Qualifier("rezervationDAOImpl") GenericDAO<Rezervation, Integer> genericDAO) {
		super(genericDAO);
		rezervationDAO = (RezervationDAO) genericDAO;
	}

	/**
	 * katalog ile rezervasyon yapar
	 */
	@Override
	public void makeReservationWithCatalog(Catalog catalog, Date startDate, Date endDate, User user) throws BusinessException {
		try {
			rezervationDAO.rezerveBookToAUserFromCatalog(catalog, user, startDate, endDate);
		} catch (CRUDException ex) {
			throw new BusinessException("Rezervasyon yapılamadı.", ex);
		}
	}

	/**
	 * kitap ile rezervasyon yapar
	 */
	@Override
	public void makeReservationWithBook(Book book, Date startDate, Date endDate, User user) throws BusinessException {
		try {
			rezervationDAO.rezerveCertainBookToAUser(book, user, startDate, endDate);
		} catch (CRUDException e) {
			throw new BusinessException("Rezervasyon yapılamadı", e);
		}

	}

	/**
	 * rezervasyon iptal işlemi
	 */
	@Override
	public void cancelReservation(Rezervation rezervation) throws BusinessException {
		try {
			rezervationDAO.cancelRezervation(rezervation);
		} catch (CRUDException e) {
			throw new BusinessException("Rezervasyon iptaql edilemedi", e);
		}

	}

	/*
	 * Tarihler için kaç kitabın rezervasyona uygun oluğunu gösterir
	 * (non-Javadoc)
	 * 
	 * @see tr.gov.egm.library.service.RezervationService#
	 * getAvailableBookCountForDate(tr.gov.egm.library.entities.Catalog,
	 * java.util.Date)
	 */
	@Override
	public void getAvailableBookCountForDate(Catalog catalog, Date date) throws BusinessException {
		try {
			rezervationDAO.availableBookCountForDate(catalog, date);
		} catch (CRUDException e) {
			throw new BusinessException("Uygun kitap sayısı alınamadı.", e);
		}

	}

}
