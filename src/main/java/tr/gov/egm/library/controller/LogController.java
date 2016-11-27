package tr.gov.egm.library.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import tr.gov.egm.library.dao.LogDAO;
import tr.gov.egm.library.entities.Log;
import tr.gov.egm.library.entities.User;
import tr.gov.egm.library.service.LogService;

@Controller
@RequestMapping(method = RequestMethod.GET)
public class LogController {

	@Autowired
	private LogService service;

	@RequestMapping("/log")
	public String allLogs(Model model) {
		List<Log> log = service.getAllLog();

		model.addAttribute("log", log);

		return "log";
	}
	
	@RequestMapping("/logByUser")
	public String allLogs(Model model, @ModelAttribute(name = "user") User user) {
		List<Log> log = service.getir(user);

		model.addAttribute("log", log);

		return "log";
	}

	

	//
	// @SuppressWarnings("unchecked")
	// protected void doPost(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	//
	// String sayfa = "/menu.jsp";
	//
	// try {
	// User user = (User) request.getSession().getAttribute("user");
	// List<Log> logsByUser = service.getir(user);
	// request.setAttribute("logsByUser", logsByUser);
	// sayfa = "/log.jsp";
	//
	// } catch (Exception e) {
	//
	// e.printStackTrace();
	// request.setAttribute("mesaj", e.getMessage());
	// }
	// request.getRequestDispatcher(sayfa).forward(request, response);
	// }
	//
	// @SuppressWarnings("unchecked")
	// protected void doPost2(HttpServletRequest request, HttpServletResponse
	// response)
	// throws ServletException, IOException {
	//
	// String sayfa = "/menu.jsp";
	//
	// try {
	//
	// List<Log> logsByUser = service.getAllLog();
	// request.setAttribute("logsByUser", logsByUser);
	// sayfa = "/log.jsp";
	//
	// } catch (Exception e) {
	//
	// e.printStackTrace();
	// request.setAttribute("mesaj", e.getMessage());
	// }
	// request.getRequestDispatcher(sayfa).forward(request, response);
	// }
}