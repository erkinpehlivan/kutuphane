package tr.gov.egm.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(String username, String passwd, String passwdAgain, BindingResult br) {
		String sayfa = "login";
		if(!passwd.equals(passwdAgain)){
			sayfa = "register";
		}
		if (!br.hasErrors()) {
			sayfa = "register";
			userService.register(new User(username, passwd));
		}
		return sayfa;
	}
	
	@RequestMapping(value = "changePassword", method = RequestMethod.POST)
	public String changePassword(@ModelAttribute("user") User user, String oldPasswd, String newPasswd, String newPasswdAgain, BindingResult br){
		String sayfa = "login";
		
		// eski parola ile yeni parola ayniysa guncelleme islemine gerek yok.
		if(oldPasswd.equals(newPasswd)){
			sayfa = "changePassword";
		}
		// yeni parola ile yeni parola tekrar ayni degilse....
		if(!newPasswd.equals(newPasswdAgain)){
			sayfa = "changePassword";
		}
		if(!br.hasErrors()){
			sayfa = "userMenu";
			user.setPassword(newPasswd);
			userService.changePassword(user);
		}
		
		return sayfa;
	}

}
