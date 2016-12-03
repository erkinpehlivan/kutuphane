package tr.gov.egm.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.gov.egm.library.dao.AuthorDAO;
import tr.gov.egm.library.entities.Author;
import tr.gov.egm.library.exceptions.dao.ReadException;

@Service
public class AuthorService {

	@Autowired
	private AuthorDAO dao;

	public List<Author> getAllAuthors() {
		List<Author> authors = null;
		try {
			authors = dao.getAllAuthors();
		} catch (ReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return authors;
	}

	public Author getAuthor(Integer id) {

		Author author = null;
		try {
			author = dao.getAuthor(id);
		} catch (ReadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return author;

	}

}
