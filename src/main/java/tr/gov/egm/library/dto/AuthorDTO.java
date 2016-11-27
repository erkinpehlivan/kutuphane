package tr.gov.egm.library.dto;

import java.io.Serializable;
import java.util.List;

import tr.gov.egm.library.entities.Catalog;

public class AuthorDTO implements Serializable {

	private static final long serialVersionUID = -8602028060496085393L;

	private Integer id;
	private String name;
	private String surname;

	private List<Catalog> catalogs;

	public AuthorDTO() {
	}

	public AuthorDTO(String name, String surname, List<Catalog> catalogs) {
		this.name = name;
		this.surname = surname;
		this.catalogs = catalogs;
	}

	public AuthorDTO(Integer id, String name, String surname, List<Catalog> catalogs) {
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