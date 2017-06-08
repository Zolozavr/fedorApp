package com.mich.fedor_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mich.fedorbackend.dao.CategoryDAO;
import com.mich.fedorbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDao;
	
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.mich.fedorbackend");
		context.refresh();

		categoryDao = (CategoryDAO)context.getBean("categoryDAO");

	}

	@Test
	public void testAddCategory() {
		category = new Category();
		
		category.setName("Future");
		category.setDescription("This is a big pile of fun");
		category.setImageUrl("CAT_1.png");

		assertEquals("Successfully added a category inside the table",true, categoryDao.add(category));
	}
}
