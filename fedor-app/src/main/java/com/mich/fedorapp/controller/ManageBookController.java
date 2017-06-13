package com.mich.fedorapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mich.fedorbackend.dao.BooksDAO;
import com.mich.fedorbackend.dao.CategoryDAO;
import com.mich.fedorbackend.dto.Books;
import com.mich.fedorbackend.dto.Category;

@Controller
@RequestMapping("/manage")
public class ManageBookController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private BooksDAO bookDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManageBookController.class);

	@RequestMapping(value="/books", method=RequestMethod.GET)
	public ModelAndView showManageBooks(@RequestParam(name="opr", required=false) String opr){
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageBooks", true);
		mv.addObject("title", "Manage Books");
		Books nBook = new Books();
		
		nBook.setUsersId(3);
		nBook.setActive(true);
		
		if(opr!=null){
			
			if(opr.equals("book")){
				mv.addObject("msg", "Book successfuly added");
			}
		}
		
		mv.addObject("book", nBook);
		return mv;
	}
	//All categories
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		
		return categoryDAO.list();
	};
	//Binding result  before the model
	@RequestMapping(value="/books", method=RequestMethod.POST)
	public String handleBooksSubmission(@Valid @ModelAttribute("book") Books mBook, BindingResult results, Model model){
		//error check
		if(results.hasErrors()){
			model.addAttribute("userClickManageBooks", true);
			model.addAttribute("title", "Manage Books");
			return "page";
		}
		
		logger.info(mBook.toString());
		bookDAO.add(mBook);
		return "redirect:/manage/books?opr=book";
	}
}
