package com.mich.fedorapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PagesCotroller {
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greatings", "Do we need to great Isanin");
		return mv;
	}
	@RequestMapping(value="/test")
	public ModelAndView test(@RequestParam(value="greatings", required=false)String greating){
		if(greating==null){
		greating = "Hello there";	
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greatings", greating);
		return mv;
	}
	@RequestMapping(value="/admin")
	public ModelAndView admin(@RequestParam(value="login")String login){
		if(login.equals("joe")){
			login="admin Joe";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("login", login);
		return mv;
	}
	
}
