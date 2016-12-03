package tr.gov.egm.library.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tr.gov.egm.library.dto.UserDTO;
import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.exceptions.service.BusinessException;
import tr.gov.egm.library.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "reg", method = RequestMethod.GET)
	public String yonlendir(Model model) {
		model.addAttribute("user", new UserDTO());
		return "register";
	}
	
	@RequestMapping(value = "dashboard", method = RequestMethod.GET)
	public String dashboard() {
		return "dashboard";
	}

	@RequestMapping(value = "chg", method = RequestMethod.GET)
	public String yonlendir2(Model model) {
		model.addAttribute("user", new UserDTO());
		return "changePassword";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(@Validated(UserDTO.Group1.class) @ModelAttribute("user") UserDTO user, HttpServletRequest request, BindingResult br) throws BusinessException {
		String sayfa = "register";
		
		// parola ile parola tekrar uyusmuyor...
		if (!user.getPassword().equals(user.getPasswordAgain())) {
			request.setAttribute("mesaj", "Parola ile Parola tekrar uyuşmuyor !!!");
		}

		if (!br.hasErrors()) {
			userService.register(new User(user.getUsername(), user.getPassword()));
			sayfa = "login";
		}
		return sayfa;
	}

	@RequestMapping(value = "changePassword", method = RequestMethod.POST)
	public String changePassword(@Validated(UserDTO.Group2.class) @ModelAttribute("user") UserDTO userDTO, HttpServletRequest request, BindingResult br) throws BusinessException {
		String sayfa = "changePassword";
		
		// eski parola ile yeni parola ayniysa guncelleme islemine gerek yok.
		if (userDTO.getPassword().equals(userDTO.getNewPassword())) {
			request.setAttribute("mesaj","Yeni parola eski parola ile aynı !!!");
		}
		// yeni parola ile yeni parola tekrar ayni degilse...
		if(!userDTO.getNewPassword().equals(userDTO.getNewPasswordAgain())){
			request.setAttribute("mesaj","Yeni parola ile Yeni parola tekrar uyuşmuyor !!!");
		}
		if (!br.hasErrors()) {
			userService.changePassword(new User(request.getSession().getAttribute("username").toString(), userDTO.getNewPassword()));
			sayfa = "login";
		}
			
		return sayfa;
	}

}
