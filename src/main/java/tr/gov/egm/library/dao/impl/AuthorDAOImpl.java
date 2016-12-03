package tr.gov.egm.library.dao.impl;

import org.springframework.stereotype.Repository;

import tr.gov.egm.library.dao.AuthorDAO;
import tr.gov.egm.library.entities.Author;

@Repository
public class AuthorDAOImpl extends GenericDAOImpl<Author, Integer> implements AuthorDAO {

}
