package tr.gov.egm.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tr.gov.egm.library.dao.AuthorDAO;
import tr.gov.egm.library.dao.GenericDAO;
import tr.gov.egm.library.entities.Author;
import tr.gov.egm.library.exceptions.service.BusinessException;
import tr.gov.egm.library.exceptions.service.CRUDException;
import tr.gov.egm.library.service.AuthorService;

@Service
public class AuthorServiceImpl extends GenericServiceImpl<Author, Integer> implements AuthorService {

	private AuthorDAO dao;

	@Autowired
	public AuthorServiceImpl(@Qualifier("authorDAOImpl") GenericDAO<Author, Integer> genericDAO) {
		super(genericDAO);
		this.dao = (AuthorDAO) genericDAO;
	}

	public List<Author> getAllAuthors() throws BusinessException {
		List<Author> authors = null;
		try {
			authors = dao.findAll();
		} catch (CRUDException e) {
			throw new BusinessException("Yazarlar getirilemedi", e);
		}
		return authors;
	}

	public Author getAuthor(Integer id) throws BusinessException {
		Author author = null;
		try {
			author = dao.findById(id);
		} catch (CRUDException e) {
			throw new BusinessException(id + " ID 'li yazar getirilemedi", e);
		}
		return author;

	}
	@Transactional
	public void addAuthor(Author author) throws BusinessException {
		try {
			dao.add(author);
		} catch (CRUDException e) {
			throw new BusinessException("Yazar eklenemedi", e);
		}
	}
	@Transactional
	public void updateAuthor (Author author) throws BusinessException {
		try {
			dao.update(author);
		} catch (CRUDException e) {
			throw new BusinessException("Yazar guncellenemedi", e);
		}
	}

}