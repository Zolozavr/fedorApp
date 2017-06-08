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

		categoryDao = (CategoryDAO) context.getBean("categoryDAO");

	}

	
	/*
	 * Create
	 */
	// @Test
	// public void testAddCategory() {
	// category = new Category();
	//
	// category.setName("Fantastic");
	// category.setDescription("This is a big pile of funny bunny");
	// category.setImageUrl("CAT_3.png");
	//
	// assertEquals("Successfully added a category inside the table",true,
	// categoryDao.add(category));
	// }
	// Read
	
	/*
	 * @Test
	 */
	// public void testGetCategory(){
	// category = categoryDao.get(2);
	// assertEquals("Succesfuly fetched a single category from the
	// table!","Detective",category.getName());
	// }
	
	/*
	 * Update
	 */
	// @Test
	// public void testUpdateCategory(){
	// category = categoryDao.get(2);
	// category.setName("Levitating goods");
	// assertEquals("Succesfuly updated a single category from the
	// table!",true,categoryDao.update(category));
	// }
	
	/*
	 * Delete
	 * */
	
	/*@Test
	public void testDeleteCategory(){
		 
		 category = categoryDao.get(2);
		 assertEquals("Succesfuly deleted a single category from the table!",true,categoryDao.delete(category));
		 	
	}*/
	/*
	 * List of active categories
	 * */
	/*@Test
	public void testListCategory(){
		 
		
		 assertEquals("Succesfuly fetch a list category from the table!",2,categoryDao.list().size());
		 	
	}*/
	
	@Test
	public void testCRUDCategory(){
		 
		 /*
		  * ADD ELEMENT TO CATEGORY
		  * */
		 category = new Category();
		
		 category.setName("Fantastic");
		 category.setDescription("This is a big pile of funny bunny");
		 category.setImageUrl("CAT_1.png");
		
		 assertEquals("Successfully added a category inside the table",true,
		 categoryDao.add(category));
		 
		 category = new Category();
			
		 category.setName("Drama");
		 category.setDescription("This is a big pile of funny");
		 category.setImageUrl("CAT_2.png");
		
		 assertEquals("Successfully added a category inside the table",true,
		 categoryDao.add(category));
		 
		 /*
		  * FETCH AND UPDATIMG
		  * */
			 category = categoryDao.get(2);
			 category.setName("Triller");
			 assertEquals("Succesfuly fetched a single category from the table!","Triller",category.getName());
		 /*
		  * DELETE
		  * */
			 category = categoryDao.get(2);
			 assertEquals("Succesfuly deleted a single category from the table!",true,categoryDao.delete(category));
		/*
		 * FETCH THE LISTS OF ACTIVE CATEGORIES
		 * */
			 assertEquals("Succesfuly fetch a list category from the table!",1,categoryDao.list().size());
}
}
