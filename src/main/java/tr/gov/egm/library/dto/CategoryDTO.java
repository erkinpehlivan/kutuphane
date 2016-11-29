package tr.gov.egm.library.dto;

import java.io.Serializable;
import java.util.List;

public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = 2761426212617693544L;

	private Integer id;
	private String type;
	private List<CatalogDTO> catalogs;

	public CategoryDTO() {
	}

	public CategoryDTO(String type) {
		this.type = type;
	}

	public CategoryDTO(Integer id, String type, List<CatalogDTO> catalogs) {
		this.id = id;
		this.type = type;
		this.setCatalogs(catalogs);
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

	public List<CatalogDTO> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(List<CatalogDTO> catalogs) {
		this.catalogs = catalogs;
	}

}