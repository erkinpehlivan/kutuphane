package tr.gov.egm.library.dto;

import java.io.Serializable;
import java.util.List;

import tr.gov.egm.library.entities.Rezervation;

public class BookDTO implements Serializable {

	private static final long serialVersionUID = 4693704114778734588L;

	private Integer id;

	private String isbn;

	private CatalogDTO catalog;

	private List<Rezervation> rezervations;

	public BookDTO() {
	}

	public BookDTO(String isbn, CatalogDTO catalog, List<Rezervation> rezervations) {
		this.isbn = isbn;
		this.catalog = catalog;
		this.rezervations = rezervations;
	}

	public BookDTO(Integer id, String isbn, CatalogDTO catalog, List<Rezervation> rezervations) {
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

	public CatalogDTO getCatalog() {
		return catalog;
	}

	public void setCatalog(CatalogDTO catalog) {
		this.catalog = catalog;
	}

	public List<Rezervation> getRezervations() {
		return rezervations;
	}

	public void setRezervations(List<Rezervation> rezervations) {
		this.rezervations = rezervations;
	}

}