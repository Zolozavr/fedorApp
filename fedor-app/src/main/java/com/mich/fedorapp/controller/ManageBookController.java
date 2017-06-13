package com.mich.fedorapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mich.fedorbackend.dao.CategoryDAO;
import com.mich.fedorbackend.dto.Books;
import com.mich.fedorbackend.dto.Category;

@Controller
@RequestMapping("/manage")
public class ManageBookController {
	
	@Autowired
	private CategoryDAO categoryDAO;

	@RequestMapping(value="/books", method=RequestMethod.GET)
	public ModelAndView showManageBooks(){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageBooks", true);
		mv.addObject("title", "Manage Books");
		Books nBook = new Books();
		
		nBook.setUsersId(3);
		nBook.setActive(true);
		
		mv.addObject("book", nBook);
		return mv;
	}
	//All categories
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDAO.list();
	};
	
}
