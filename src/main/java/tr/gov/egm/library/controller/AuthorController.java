package tr.gov.egm.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tr.gov.egm.library.entities.Author;
import tr.gov.egm.library.service.AuthorService;

@Controller
@RequestMapping(method = RequestMethod.GET)
public class AuthorController {

	@Autowired
	private AuthorService service;

	@RequestMapping("/authors")
	public String allAuthors(Model model) {
		List<Author> author = service.getAllAuthors();
		model.addAttribute("authors", author);
		return "authors";
	}

	@RequestMapping("/author/{id}")
	public String author(Model model, @PathVariable("id")Integer id) {
		Author author = service.getAuthor(id);
		model.addAttribute("author", author);
		return "author";
	}

}