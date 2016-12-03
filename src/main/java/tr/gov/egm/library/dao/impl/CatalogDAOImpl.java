package tr.gov.egm.library.dao.impl;

import org.springframework.stereotype.Repository;

import tr.gov.egm.library.dao.CatalogDAO;
import tr.gov.egm.library.entities.Catalog;
@Repository
public class CatalogDAOImpl extends GenericDAOImpl<Catalog, Integer>  implements CatalogDAO {


}
