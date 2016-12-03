
package tr.gov.egm.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tr.gov.egm.library.entities.Catalog;
import tr.gov.egm.library.service.CatalogService;

@Controller
public class CatalogController {

	@Autowired
	private CatalogService service;

	@RequestMapping(value = "/catalogs", method=RequestMethod.GET)
	public String allAuthors(Model model) {
		List<Catalog> catalogs = service.getAllCatalogs();
		model.addAttribute("catalogs", catalogs);
		return "catalogs";
	}

	@RequestMapping(value = "/catalog/{id}", method=RequestMethod.GET)
	public String catalog(Model model, @PathVariable("id")Integer id) {
		Catalog catalog = service.getCatalog(id);
		model.addAttribute("catalog", catalog);
		return "catalog";
	}
	
	@RequestMapping(value = "/catalog", method=RequestMethod.POST)
	public String changeCatalog(Model model,@ModelAttribute("catalog") Catalog catalog ) {
		if(catalog.getId()==null || catalog.getId()==0){
			service.addCatalog(catalog);
		}
		else
		{
			service.updateCatalog(catalog);
		}
		return "redirect:catalogs";
	}

}