package exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException(){
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("errorTitle", "Sorry.");
		mv.addObject("errorDescription", "We cant find this page. Maybe some fairies stole it.");
		mv.addObject("title", "404 Error page");
		
		return mv;
		
	}
	
}
