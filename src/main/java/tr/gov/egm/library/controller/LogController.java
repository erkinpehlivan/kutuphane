package tr.gov.egm.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tr.gov.egm.library.entities.Log;
import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.exceptions.service.BusinessException;
import tr.gov.egm.library.service.LogService;

@Controller
@RequestMapping(method = RequestMethod.GET)
public class LogController {

	@Autowired
	private LogService service;

	@RequestMapping("/log")
	public String allLogs(Model model) throws BusinessException {
		List<Log> log = null;
		log = service.getAllLog();
		model.addAttribute("log", log);
		return "log";
	}

	@RequestMapping("/logByUser")
	public String allLogs(Model model, @ModelAttribute(name = "user") User user) throws BusinessException {
		List<Log> log = null;
		log = service.getByUser(user);
		model.addAttribute("log", log);
		return "log";
	}

}