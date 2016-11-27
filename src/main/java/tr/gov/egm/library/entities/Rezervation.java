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
public class Rezervation implements Serializable {

	private static final long serialVersionUID = 4222917304192861199L;

	public static final String STARTED = "started";
	public static final String FINISHED = "finished";
	public static final String CANCELED = "canceled";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rezervation_gen")
	@SequenceGenerator(name = "rezervation_gen", sequenceName = "rezervation_seq")
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	@ManyToOne
	@JoinColumn(name = "BOOK_ID")
	private Book book;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;
	private String state;

	public Rezervation() {
	}

	public Rezervation(Date startDate, Date endDate, Book book, User user, String state) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.book = book;
		this.user = user;
		this.state = state;
	}

	public Rezervation(Integer id, Date startDate, Date endDate, Book book, User user, String state) {
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.book = book;
		this.user = user;
		this.state = state;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}