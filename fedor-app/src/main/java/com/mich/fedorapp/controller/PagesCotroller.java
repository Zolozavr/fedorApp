package com.mich.fedorapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PagesCotroller {
@RequestMapping(value = {"/", "/home", "/index"})
public ModelAndView index() {
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("greatings", "testSpring");
	return mv;
}
}
