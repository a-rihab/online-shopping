package com.pearl.backendshopping.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pearl.backendshopping.dao.CategoryDAO;
import com.pearl.backendshopping.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.pearl.backendshopping");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	// @Test
	// public void testAddCategory() {
	//
	// category=new Category();
	//
	// category.setName("Laptop");
	// category.setDescription("This is somed description for Laptop");
	// category.setImageUrl("CAT_02.jpg");
	//
	// assertEquals("successfully added a new a category to the
	// table",true,categoryDAO.add(category));
	//
	// }

	// @Test
	// public void testGetCategory() {
	//
	// category =categoryDAO.get(1);
	//
	// assertEquals("successfully fetch a category from the
	// table","Television",category.getName());
	//
	// }

	// @Test
	// public void testUpdateCategory() {
	//
	// category =categoryDAO.get(1);
	//
	// category.setName("TV");
	//
	// assertEquals("successfully updated a single category into the
	// table",true,categoryDAO.upadte(category));
	//
	// }

	// @Test
	// public void testDeleteCategory() {
	//
	// category =categoryDAO.get(1);
	//
	// assertEquals("successfully deleted a single category into the
	// table",true,categoryDAO.delete(category));
	//
	// }

	@Test
	public void testListCategory() {

		assertEquals("successfully fetch all categories from the table", 1, categoryDAO.list().size());

	}

}
