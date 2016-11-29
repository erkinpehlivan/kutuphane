package tr.gov.egm.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(method = RequestMethod.GET)
public class SecurityController {

	@RequestMapping("/giris")
	public String girisKontrol() {
		return "login";
	}

	@RequestMapping("/girisHatali")
	public String girisHatali(ModelMap map) {
		map.put("hata", "true");
		return "login";
	}

	@RequestMapping("/403")
	public String yetkinizYok() {
		return "403";
	}

}