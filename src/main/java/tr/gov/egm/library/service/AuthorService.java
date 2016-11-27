package tr.gov.egm.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tr.gov.egm.library.dao.AuthorDAO;
import tr.gov.egm.library.entities.Author;

@Service
public class AuthorService {

	@Autowired
	private AuthorDAO dao;

	public List<Author> getAuthor(Author author) {
		List<Author> authors = (List<Author>) dao.findAuthorByName(author.getName());

		return authors;
	}

	public List<Author> getAllAuthors() {

		List<Author> authors = (List<Author>) dao.findAll();

		return authors;

	}

}
