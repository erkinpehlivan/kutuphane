package tr.gov.egm.library.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import tr.gov.egm.library.exceptions.service.BusinessException;

@ControllerAdvice
public class ControllerExceptionAdvice {

	@ExceptionHandler(BusinessException.class)
	public ModelAndView errorInterceptor(BusinessException ex) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("hataMesaji", ex.getMessage());
		return mv;
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView errorInterceptor(Exception ex) {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("hataMesaji", ex.getMessage());
		return mv;
	}

}