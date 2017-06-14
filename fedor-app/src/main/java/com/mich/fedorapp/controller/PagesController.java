package com.mich.fedorapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mich.fedorbackend.dao.BooksDAO;
import com.mich.fedorbackend.dao.CategoryDAO;
import com.mich.fedorbackend.dto.Books;
import com.mich.fedorbackend.dto.Category;

@Controller
public class PagesController {
	private static final Logger logger = LoggerFactory.getLogger(PagesController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private BooksDAO booksDAO;
	
	

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "");
		
		logger.info("Inside page controller index - INFO");
		logger.debug("Inside page controller indes - DEBUG");
		
		// test dao
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickShop", true);
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	// Method to load all the books based on category
	@RequestMapping(value = { "/show/all/books" })
	public ModelAndView showAllBooks() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All books");
		// test dao
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllBooks", true);
		return mv;
	}

	// Method to load all the books based on category
	@RequestMapping(value = { "/show/category/{id}/books" })
	public ModelAndView showCategoryBooks(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		// categoryDAO to fetch a single category
		Category category = null;
		category = categoryDAO.get(id);
		mv.addObject("title", category.getName());
		// test dao
		mv.addObject("categories", categoryDAO.list());
		// passing the single category object
		mv.addObject("category", category);
		mv.addObject("userClickCategoryBooks", true);
		return mv;
	}
	/*
	 * Single book page
	 */

	@RequestMapping(value = "/show/{id}/book")
	public ModelAndView showSingleBook(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		Books book = booksDAO.get(id);

		// +1 view
		book.setViews(book.getViews() + 1);
		booksDAO.update(book);

		mv.addObject("title", book.getBookName());
		mv.addObject("book", book);
		mv.addObject("userClickShowBook", true);

		return mv;
	}
}
