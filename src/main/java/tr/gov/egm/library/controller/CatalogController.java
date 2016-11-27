package tr.gov.egm.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tr.gov.egm.library.entities.Catalog;
import tr.gov.egm.library.service.CatalogService;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
	@Autowired
	private CatalogService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String yonlendir(Model model){
		model.addAttribute("personel",new Catalog());
		return "personel";
		
	}
	public String ekle(Catalog catalog){
		service.ekle(catalog);
		return "menu";	
	}
	
}
