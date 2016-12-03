package tr.gov.egm.library.controller;

import javax.servlet.http.HttpSession;

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
	public String register(@Validated(UserDTO.Group1.class) @ModelAttribute("user") UserDTO user, BindingResult br) throws BusinessException {
		if (!user.getPassword().equals(user.getPasswordAgain())) {
			return "register";
		}

		if (!br.hasErrors()) {
			userService.register(new User(user.getUsername(), user.getPassword())); // DONE
			return "register";
		}
		return "login";
	}

	@RequestMapping(value = "changePassword", method = RequestMethod.POST)
	public String changePassword(@Validated(UserDTO.Group2.class) @ModelAttribute("user") UserDTO userDTO, HttpSession session, BindingResult br) throws BusinessException {

		// eski parola ile yeni parola ayniysa guncelleme islemine gerek yok.
		// yeni parola ile yeni parola tekrar ayni degilse...
		if (userDTO.getPassword().equals(userDTO.getNewPassword()) || !userDTO.getNewPassword().equals(userDTO.getNewPasswordAgain())) {
			return "changePassword";
		}

		if (!br.hasErrors()) {
			userService.changePassword(new User(session.getAttribute("username").toString(), userDTO.getNewPassword()));
			return "login";
		}

		return "login";
	}

}
