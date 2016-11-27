package tr.gov.egm.library.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Catalog implements Serializable {

	private static final long serialVersionUID = -8539421375981281267L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_gen")
	@SequenceGenerator(name = "category_gen", sequenceName = "category_seq")
	private Integer id;
	private String name;
	private String title;
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "catalogs")
	private List<Author> authors;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CATEGORY_ID")
	private Category category;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "catalog")
	private List<Book> books;

	public Catalog() {
	}

	public Catalog(String name, String title, List<Author> authors, Category category) {
		this.name = name;
		this.title = title;
		this.authors = authors;
		this.category = category;
	}

	public Catalog(Integer id, String name, String title, List<Author> authors, Category category, List<Book> books) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.authors = authors;
		this.category = category;
		this.books = books;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}