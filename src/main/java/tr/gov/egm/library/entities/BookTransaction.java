/**
 * 
 */
package tr.gov.egm.library.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class BookTransaction implements Serializable {

	private static final long serialVersionUID = 4958402659334960904L;
	
	public static final String GIVE = "give";
	public static final String BACK = "back";
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="debit_gen")
	@SequenceGenerator(name="debit_gen",sequenceName="debit_seq")
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date givenDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date backDate;
	
	@ManyToOne
	@JoinColumn(name="BOOK_ID") 
	private Book book;

	@ManyToOne
	@JoinColumn(name="REZERVATION_ID",nullable=true)
	private Rezervation rezervation;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	
	private String state;

	/**
	 * 
	 */
	public BookTransaction() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the givenDate
	 */
	public Date getGivenDate() {
		return givenDate;
	}

	/**
	 * @param givenDate the givenDate to set
	 */
	public void setGivenDate(Date givenDate) {
		this.givenDate = givenDate;
	}

	/**
	 * @return the backDate
	 */
	public Date getBackDate() {
		return backDate;
	}

	/**
	 * @param backDate the backDate to set
	 */
	public void setBackDate(Date backDate) {
		this.backDate = backDate;
	}

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}

	/**
	 * @return the rezervation
	 */
	public Rezervation getRezervation() {
		return rezervation;
	}

	/**
	 * @param rezervation the rezervation to set
	 */
	public void setRezervation(Rezervation rezervation) {
		this.rezervation = rezervation;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	

}
