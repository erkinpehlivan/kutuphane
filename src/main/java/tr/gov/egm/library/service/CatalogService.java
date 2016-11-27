package tr.gov.egm.library.service;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tr.gov.egm.library.dao.CatalogDAO;
import tr.gov.egm.library.entities.Catalog;

@Service
public class CatalogService {
	@Autowired
CatalogDAO ctd ;
	public List<Catalog> getCatalogs(){
		return null;
	}
	public void ekle(Catalog catalog) {
	
	  
	}
}