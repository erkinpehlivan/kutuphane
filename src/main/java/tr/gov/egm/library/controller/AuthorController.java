package tr.gov.egm.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tr.gov.egm.library.entities.Author;
import tr.gov.egm.library.service.AuthorService;

@Controller
public class AuthorController {

	@Autowired
	private AuthorService service;

	@RequestMapping(value = "/authors", method=RequestMethod.GET)
	public String allAuthors(Model model) {
		List<Author> author = service.getAllAuthors();
		model.addAttribute("authors", author);
		return "authors";
	}

	@RequestMapping(value = "/author/{id}", method=RequestMethod.GET)
	public String author(Model model, @PathVariable("id")Integer id) {
		Author author = service.getAuthor(id);
		model.addAttribute("author", author);
		return "author";
	}
	
	@RequestMapping(value = "/author", method=RequestMethod.POST)
	public String changeAuthor(Model model,@ModelAttribute("author") Author author ) {
		if(author.getId()==null || author.getId()==0){
			service.addAuthor(author);
		}
		else
		{
			service.updateAuthor(author);
		}
		return "redirect:authors";
	}

}