package com.mich.fedorapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mich.fedorbackend.dao.BooksDAO;
import com.mich.fedorbackend.dto.Books;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	@Autowired
	private BooksDAO bookDAO;

	@RequestMapping("/all/books")
	@ResponseBody
	public List<Books> getAllBooks() {
		return bookDAO.listActiveBooks();
	}
	
	@RequestMapping("/admin/all/books")
	@ResponseBody
	public List<Books> getAllBooksForAdmnin() {
		
		return bookDAO.list();
	}
	
	@RequestMapping("/category/{id}/books")
	@ResponseBody
	public List<Books> getAllBooksByCategory(@PathVariable int id) {
		return bookDAO.listActiveProductsByCategory(id);
	}


}
