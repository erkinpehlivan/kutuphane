
package tr.gov.egm.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tr.gov.egm.library.entities.Category;
import tr.gov.egm.library.exceptions.service.BusinessException;
import tr.gov.egm.library.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	private CategoryService service;

	@RequestMapping(value = "categories", method=RequestMethod.GET)
	public String allCategories(Model model) {
		List<Category> categories;
		try {
			categories = service.findAll();
			model.addAttribute("category", categories);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		return "categories";
	}

	@RequestMapping(value = "category/{id}", method=RequestMethod.GET)
	public String category(Model model, @PathVariable("id")Integer id) {
		Category category;
		try {
			category = service.findById(id);
			model.addAttribute("category", category);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		return "category";
	}
	
	@RequestMapping(value = "category", method=RequestMethod.POST)
	public String changeCategory(@ModelAttribute("category") Category category, Model model) {
		if(category.getId()==null || category.getId()==0){
			try {
				service.add(category);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}
		else
		{
			try {
				service.update(category);
			} catch (BusinessException e) {
				e.printStackTrace();
			}
		}
//		return "redirect:categories";
		return "categoryAdd";
	}
	@RequestMapping(value = "categoryAdd", method=RequestMethod.GET)
	public String addCatalog(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		return "category";
	}

}