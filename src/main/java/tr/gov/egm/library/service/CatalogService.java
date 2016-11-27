package tr.gov.egm.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tr.gov.egm.library.dao.CatalogDAO;
import tr.gov.egm.library.entities.Catalog;

@Service
public class CatalogService {
CatalogDAO ctd = new CatalogDAO();
	public List<Catalog> getCatalogs(){
		return catalogs;
	}
	public void ekle(Catalog catalog) {
		catalogs.add(catalog);
	
	}
}