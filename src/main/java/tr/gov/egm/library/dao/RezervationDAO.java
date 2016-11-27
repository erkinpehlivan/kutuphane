/**
 * 
 */
package tr.gov.egm.library.dao;

import java.util.Date;

import org.springframework.data.repository.Repository;

import tr.gov.egm.library.entities.Book;
import tr.gov.egm.library.entities.Catalog;
import tr.gov.egm.library.entities.Rezervation;
import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.exceptions.dao.CreateException;
import tr.gov.egm.library.exceptions.dao.ReadException;
import tr.gov.egm.library.exceptions.service.CRUDException;

/**
 * @author EGM
 *
 */
public interface RezervationDAO extends Repository<Rezervation, Integer> {
	
	/**
	 * Bir katalogdan boştaki uygun kitabı bularak istenilen tarihte kişiye rezervasyon yapar.
	 * Kişide aynı katalogdaki kitaptan olup olmadığının kontrolü DAO katmanında yapılır.
	 * @param catalog
	 * @param user
	 * @param startDate
	 * @param endDate
	 */
	public void rezerveBookToAUserFromCatalog(Catalog catalog,User user,Date startDate,Date endDate ) throws CRUDException ;
	

	
	/**
	 * Belirli bir kitabı istenilen tarihte kişiye rezervasyon yapar.
	 * Kişide aynı katalogdaki kitaptan olup olmadığının kontrolü DAO katmanında yapılır
	 * @param book
	 * @param user
	 * @param startDate
	 * @param endDate
	 */
	public void rezerveCertainBookToAUser(Book book,User user,Date startDate,Date endDate )throws CRUDException;
	
	public void cancelRezervation(Rezervation rezervation)throws CreateException;
	
	public int availableBookCountForDate(Catalog catalog,Date date)throws ReadException;

	
	
	

}
