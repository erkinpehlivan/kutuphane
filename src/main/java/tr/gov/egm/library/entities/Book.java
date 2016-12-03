package tr.gov.egm.library.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Book implements Serializable {

	private static final long serialVersionUID = 4693704114778734588L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_gen")
	@SequenceGenerator(name = "book_gen", sequenceName = "book_seq")
	private Integer id;
	@Column
	private String isbn;
	@ManyToOne
	@JoinColumn(name = "CATALOG_ID")
	private Catalog catalog;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
	private List<Rezervation> rezervations;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="book")
	private List<BookTransaction> debits;

	public Book() {
	}

	public Book(String isbn, Catalog catalog, List<Rezervation> rezervations) {
		this.isbn = isbn;
		this.catalog = catalog;
		this.rezervations = rezervations;
	}

	public Book(Integer id, String isbn, Catalog catalog, List<Rezervation> rezervations) {
		this.id = id;
		this.isbn = isbn;
		this.catalog = catalog;
		this.rezervations = rezervations;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public List<Rezervation> getRezervations() {
		return rezervations;
	}

	public void setRezervations(List<Rezervation> rezervations) {
		this.rezervations = rezervations;
	}

	/**
	 * @return the debits
	 */
	public List<BookTransaction> getDebits() {
		return debits;
	}

	/**
	 * @param debits the debits to set
	 */
	public void setDebits(List<BookTransaction> debits) {
		this.debits = debits;
	}

}