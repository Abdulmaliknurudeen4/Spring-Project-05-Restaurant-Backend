package com.alpha.practice.restaurant_backend.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alpha.practice.restaurant_backend.dao.CategoryDAO;
import com.alpha.practice.restaurant_backend.dto.DishCategory;

public class DishCategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private static DishCategory dishCategory;
	private static CategoryDAO dishCatDAO;
	private static List<DishCategory> dishCategories;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.alpha.practice.restaurant_backend");
		context.refresh();
		dishCatDAO = (CategoryDAO) context.getBean("categoryRepository");
	}

//	@Test
//	public void testCat() {
//		// dishCategory = dishCatDAO.getCategory(3);
//		// assertEquals("Failed to retrieve the category count", 1,
//		// dishCatDAO.categorySizeAll(dishCategory));
//		for (int i = 0; i < 10; i++) {
//			dishCategory = new DishCategory();
//			dishCategory.setActive(true);
//			dishCategory.setDescription("This is the dish category " + i);
//			dishCategory.setImageUrl("NOT ACCOUNTED FOR " + i);
//			dishCategory.setName("Food Category " + i);
//			assertEquals("Failed to Add Category", true, dishCatDAO.saveCategory(dishCategory));
//		}
//	}

//	@Test
//	public void getCountCategory() {
//		dishCategory = dishCatDAO.getCategory(5);
//		int count = dishCatDAO.categorySizeAll(dishCategory);
//		assertEquals("Failed to Get Category Size", 50, count);
//	}
//	
//	@Test
//	public void getCountCategoryVisible() {
//		dishCategory = dishCatDAO.getCategory(206);
//		int count = dishCatDAO.categoryVisibleSize(dishCategory);
//		assertEquals("Failed to Get Category Size", 0, count);
//	}

	@Test
	public void getCategoryList() {
		dishCategories = dishCatDAO.dishCategoriesAllVisisbility();
		assertEquals("Failed to retrieve all the categories", 5, dishCategories.size());
	}
}
