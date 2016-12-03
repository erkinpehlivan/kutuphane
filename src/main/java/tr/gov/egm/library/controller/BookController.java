
package tr.gov.egm.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tr.gov.egm.library.entities.Book;
import tr.gov.egm.library.exceptions.service.BusinessException;
import tr.gov.egm.library.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService service;

	@RequestMapping(value = "books", method=RequestMethod.GET)
	public String allBooks(Model model) {
		List<Book> books;
		try {
			books = service.findAll();
			model.addAttribute("books", books);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return "books";
	}

	@RequestMapping(value = "book/{id}", method=RequestMethod.GET)
	public String book(Model model, @PathVariable("id")Integer id) {
		Book book;
		try {
			book = service.findById(id);
			model.addAttribute("book", book);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		return "book";
	}
	
	@RequestMapping(value = "book", method=RequestMethod.POST)
	public String changeBook(Model model,@ModelAttribute("book") Book book ) {
		if(book.getId()==null || book.getId()==0){
			try {
				service.add(book);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}
		else
		{
			try {
				service.update(book);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}
		return "redirect:books";
	}

}