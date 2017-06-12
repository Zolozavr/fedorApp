package com.mich.fedor_backend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.junit.Assert.assertEquals;

import com.mich.fedorbackend.dao.BooksDAO;
import com.mich.fedorbackend.dto.Books;

public class BooksTestCase {
	private static AnnotationConfigApplicationContext context;

	private static BooksDAO booksDAO;
	
	private Books book;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mich.fedorbackend");
		context.refresh();

		booksDAO = (BooksDAO) context.getBean("booksDAO");

	}
	@Test
	public void testCRUDBooks(){
		book = new Books();
		book.setBookName("Chibichanga");
		book.setAuthor("Me");
		book.setImgUrl("p_903.png");
		book.setActive(true);
		book.setCategoryId(1);
		book.setUsersId(1);
		
		assertEquals("Book isnt added", true, booksDAO.add(book));
		
		book = booksDAO.get(2);
		book.setBookName("Joys dream");
		assertEquals("Not happened",true ,booksDAO.update(book));
		
		assertEquals("Not deleted", true, booksDAO.delete(book));
		
		assertEquals("Not listed, heh", 17,  booksDAO.list().size());
		
		assertEquals("Wrong active list components", 16, booksDAO.listActiveBooks().size());
		
		assertEquals("Wrong active books by category", 2, booksDAO.listActiveProductsByCategory(5).size());
		
		assertEquals("Wrong latest active book", 3, booksDAO.getLatestActiveBooks(3).size());
	}
}
