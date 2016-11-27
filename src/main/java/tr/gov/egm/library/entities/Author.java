package tr.gov.egm.library.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Author implements Serializable {

	private static final long serialVersionUID = -8602028060496085393L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_gen")
	@SequenceGenerator(name = "author_gen", sequenceName = "author_seq")
	private Integer id;
	private String name;
	private String surname;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "CATALOG_AUTHOR", joinColumns = @JoinColumn(name = "CATALOG_ID"), inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
	private List<Catalog> catalogs;

	public Author() {
	}

	public Author(String name, String surname, List<Catalog> catalogs) {
		this.name = name;
		this.surname = surname;
		this.catalogs = catalogs;
	}

	public Author(Integer id, String name, String surname, List<Catalog> catalogs) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.catalogs = catalogs;
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Catalog> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(List<Catalog> catalogs) {
		this.catalogs = catalogs;
	}

}