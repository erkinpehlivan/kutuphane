package tr.gov.egm.library.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tr.gov.egm.library.entities.Catalog;

@Repository
public interface CatalogDAO extends CrudRepository<Catalog, Integer> {

}