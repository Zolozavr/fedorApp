package com.mich.fedorapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mich.fedorapp.util.FileUploadUtility;
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

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ModelAndView showManageBooks(@RequestParam(name = "opr", required = false) String opr) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageBooks", true);
		mv.addObject("title", "Manage Books");
		Books nBook = new Books();

		nBook.setUsersId(3);
		nBook.setActive(true);
		mv.addObject("book", nBook);
		if (opr != null) {

			if (opr.equals("book")) {
				mv.addObject("msg", "Book successfuly added");
			}
			else if(opr.equals("category")){
				mv.addObject("msg", "Category successfuly added");
			}
		}
		
		
		return mv;
	}

	@RequestMapping(value = "/books/{id}/activation", method = RequestMethod.POST)
	@ResponseBody
	public String handlerBookActivation(@PathVariable int id) {
		Books book = bookDAO.get(id);
		boolean isActive = book.isActive();
		book.setActive(!book.isActive());
		bookDAO.update(book);
		return (isActive) ? "You have succesfuly deactivated book" + book.getId()
				: "You have succesfuly activated book" + book.getId();
	}
	//Updating existing book
	
	@RequestMapping(value = "/{id}/books", method = RequestMethod.GET)
	public ModelAndView showEditBooks(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageBooks", true);
		mv.addObject("title", "Manage Books");
		
        //Fetching lot from database
		Books nBook = bookDAO.get(id);
		//Updating the book
		mv.addObject("book", nBook);
		return mv;
	}

	
	
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySub(@ModelAttribute Category category){
		categoryDAO.add(category);
		return "redirect:/manage/books/?opr=category";
	}
	
	//New category
	@ModelAttribute("category")
	public Category getCategory(){
		return new Category();
	}
	
	
	
	// All categories
	@ModelAttribute("categories")
	public List<Category> getCategories() {

		return categoryDAO.list();
	};

	// Binding result before the model
	@RequestMapping(value = "/books", method = RequestMethod.POST)
	public String handleBooksSubmission(@Valid @ModelAttribute("book") Books mBook, BindingResult results, Model model,
			HttpServletRequest request) {
		
		// error check
		if (results.hasErrors()) {
			model.addAttribute("userClickManageBooks", true);
			model.addAttribute("title", "Manage Books");
			return "page";
		}

		
		
		logger.info(mBook.toString());
		if(mBook.getId() == 0){
			//if this is a new product, create product
			bookDAO.add(mBook);
		}
		else{
			//if this is existing product update product
			bookDAO.update(mBook);		}
		

		if (!mBook.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mBook.getFile(), mBook.getImgUrl());
		}

		return "redirect:/manage/books?opr=book";
	}
}
