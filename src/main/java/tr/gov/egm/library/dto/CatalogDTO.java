package tr.gov.egm.library.dto;

import java.io.Serializable;
import java.util.List;

import tr.gov.egm.library.entities.Author;

public class CatalogDTO implements Serializable {

	private static final long serialVersionUID = -8539421375981281267L;

	private Integer id;
	private String name;
	private String title;

	private List<Author> authors;

	private CategoryDTO category;

	private List<BookDTO> books;

	public CatalogDTO() {
	}

	public CatalogDTO(String name, String title, List<Author> authors, CategoryDTO category) {
		this.name = name;
		this.title = title;
		this.authors = authors;
		this.category = category;
	}

	public CatalogDTO(Integer id, String name, String title, List<Author> authors, CategoryDTO category,
			List<BookDTO> books) {
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

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public List<BookDTO> getBooks() {
		return books;
	}

	public void setBooks(List<BookDTO> books) {
		this.books = books;
	}

}