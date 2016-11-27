package tr.gov.egm.library.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = 2761426212617693544L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_gen")
	@SequenceGenerator(name = "category_gen", sequenceName = "category_seq")
	private Integer id;
	private String type;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Catalog> catalogs;

	public Category() {
	}

	public Category(String type) {
		this.type = type;
	}

	public Category(Integer id, String type, List<Catalog> catalogs) {
		this.id = id;
		this.type = type;
		this.catalogs = catalogs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}