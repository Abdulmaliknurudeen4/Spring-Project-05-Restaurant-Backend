package com.alpha.practice.restaurant_backend.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alpha.practice.restaurant_backend.dao.CategoryDAO;
import com.alpha.practice.restaurant_backend.dao.DishDAO;
import com.alpha.practice.restaurant_backend.dto.Dish;
import com.alpha.practice.restaurant_backend.dto.DishCategory;
import com.alpha.practice.restaurant_backend.enumIdentifiers.Dish_Type;

public class DishTestCase {

	private static AnnotationConfigApplicationContext context;
	private static Dish dish;
	private static List<Dish> dishes;
	private static DishDAO dishDAO;

	private static DishCategory dishCategory;
	private static CategoryDAO dishCatDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.alpha.practice.restaurant_backend");
		context.refresh();
		dishDAO = (DishDAO) context.getBean("dishRepository");
		dishCatDAO = (CategoryDAO) context.getBean("categoryRepository");
	}

	@Test
	public void testCat() {
		// Works retrieve category dishCategory =
		dishCategory = dishCatDAO.getCategory(7); // set dish
		for (int i = 0; i < 9; i++) {
			dish = new Dish();
			dish.setDescription("Sweet, Delicious and good for the body and the mind" + i);
			dish.setDishType(Dish_Type.APETIZER);
			dish.setPurchases(7 * i);
			dish.setUnitPrice(248 + i);
			dish.setViews(8 * i);
			dish.setServings(2 * i);
			dish.setName("Igbo Apetizers" + i);
			dish.setCategory(dishCategory);
			dish.setFile(null);
			dish.setActive(true);
			assertEquals("Failed to add Dish", true, dishDAO.addDish(dish));
		}

		// save dish

	}

//	@Test
//	public void GetPagesInOverAllList() {
//	//Works
//		assertEquals("Failed to get Dish with required size", 21, dishDAO.getPagesInListDish(1));
//
//	}
//	@Test
//	public void getPagesInOverAllListPrinting() {
//		dishes = new ArrayList<Dish>();
//		dishes = dishDAO.getAllDish(1, 1);
//		assertEquals("Failed to retrieve dish of required size", 10, dishes.size());
//		
//	}
//
//	@Test
//	public void getPagesInActiveDishesByCategoryUsingId() {
//		dishes = new ArrayList<Dish>();
//		dishCategory = dishCatDAO.getCategory(4);
//		int pages = dishDAO.pageNumberActiveDishByCategoryPageable(1, 4);
//		assertEquals("Failed to retrieve the dishes count by category to accurate size", 1, pages);
//	}
//
//	@Test
//	public void getListItemPageInActiveDishesByCategoryUsingId() {
//		dishes = new ArrayList<Dish>();
//		dishes = dishDAO.getActiveDishByCategoryPageable(1, 1, 4);
//		assertEquals("Failed to retrieve the dishes list in the pagination system", 8, dishes.size());
//	}

//	@Test
//	public void getListItemPageInActiveDishedByCategoryObject() {
//		dishes = new ArrayList<Dish>();
//		dishCategory = dishCatDAO.getCategory(4);
//		int pages = dishDAO.pageNumberActiveDishByCategoryPageable(1, dishCategory);
//		assertEquals("Failed to retrieve the dishes count by category to accurate size", 1, pages);
//	}
//
//	@Test
//	public void getListItemInActiveDishesByCategoryObject() {
//		dishes = new ArrayList<Dish>();
//		dishCategory = dishCatDAO.getCategory(4);
//		dishes = dishDAO.getActiveDishByCategoryPageable(1, 1, dishCategory);
//		assertEquals("Failed to retrieve the dishes list in the pagination system", 8, dishes.size());
//	}
//	@Test
//	public void getAllVisibilityDishesAllByCategoryId() {
//		dishes = new ArrayList<Dish>();
//		dishes = dishDAO.getAllDishByCategoryPageable(1, 1, 4);
//		assertEquals("Failed to retrieve the all visibility dishes list in the pagination system", 8, dishes.size());
//	}
//	
//	@Test
//	public void getAllVisibilityDishesAllByCategoryIdPageCount() {
//		dishes  = new ArrayList<Dish>();
//		dishCategory = dishCatDAO.getCategory(4);
//		int pages = dishDAO.pageNumberAllDishByCategoryPageable(1, 4);
//		assertEquals("Failed to retrieve the dishes count pages available by category to accurate size", 1, pages);
//	}
//	@Test
//	public void getAllVisibilityDishesAllByCategoryObject() {
//		dishes = new ArrayList<Dish>();
//		dishCategory = dishCatDAO.getCategory(4);
//		dishes = dishDAO.getAllDishByCategoryPageable(1, 1, dishCategory);
//		assertEquals("Failed to retrieve the all visibility dishes list in the pagination system", 8, dishes.size());
//	}
//
//	@Test
//	public void getAllVisibilityDishesAllByCategoryIdPageCountObject() {
//		dishes = new ArrayList<Dish>();
//		dishCategory = dishCatDAO.getCategory(4);
//		int pages = dishDAO.pageNumberAllDishByCategoryPageable(1, dishCategory);
//		assertEquals("Failed to retrieve the dishes count pages available by category to accurate size", 1, pages);
//
//	}
//	
//	
	// testing
//	
//	@Test
//	public void getMostOrderedActivePageable() {
//		dishes = new ArrayList<Dish>();
//		dishes = dishDAO.getMostOrderedActivePageable(1,6);
//		assertEquals("Failed to retrieve the dishes based on ordering by the Most Ordered by Page", 10, dishes.size());
//	}
//	
//	@Test
//	public void pageNumberMostOrderedActivePageable() {
//		dishes = new ArrayList<Dish>();
//		int pages = dishDAO.pageNumberMostOrderedActivePageable(1);
//		assertEquals("Failed to retrieve the dishes based on ordering by the Most Ordered by Page", 16, pages);
//	}
//	@Test
//	public void getMostOrderedActiveByCategoryPageable() {
//		dishes = new ArrayList<Dish>();
//		dishCategory = dishCatDAO.getCategory(4);
//		dishes = dishDAO.getMostOrderedActiveByCategoryPageable(1, 1, dishCategory);
//		assertEquals("Failed to Retrieve Dishes in a specific category that are the most ordered in that category ", 8,
//				dishes.size());
//	}
//
//	@Test
//	public void pageNumberMostOrderedActiveByCategoryPageable() {
//		dishCategory = dishCatDAO.getCategory(4);
//		int pages = dishDAO.pageNumberMostOrderedActiveByCategoryPageable(1, dishCategory);
//		assertEquals("Failed to Retrieve Page Count in a specific category that are the most ordered in that category ",
//				1, pages);
//
//	}
	/*
	 * All other methods after that are okay by analysis not testing since they all
	 * consume of the same steps of code even the admin methods
	 */

	// Most Viewed Testing
//	@Test
//	public void getMostViewedActivePageable() {
//		dishes = new ArrayList<Dish>();
//		dishes = dishDAO.getMostViewedActivePageable(1, 2);
//		assertEquals("Failed to retrieve dishes ordered by the views ", 10, dishes.size());
//	}
//
//	@Test
//	public void pageNumberMostViewedActivePageable() {
//		int pages = dishDAO.pageNumberMostViewedActivePageable(1);
//		assertEquals("Failed to retrieve page count of dishes ordered by their views", 16, pages);
//	}

//	@Test
//	public void getMostViewedActiveByCategoryPageable() {
//		dishes = new ArrayList<Dish>();
//		dishCategory = dishCatDAO.getCategory(5);
//		dishes = dishDAO.getMostViewedActiveByCategoryPageable(1, 5, dishCategory);
//		assertEquals("Failed to retreive dishes in a category ordered by the most viewed", 10, dishes.size());
//	}
//	
//	@Test
//	public void pageNumberMostViewedActiveByCategoryPageable() {
//		dishCategory = dishCatDAO.getCategory(5);
//		int pages = dishDAO.pageNumberMostViewedActiveByCategoryPageable(1, dishCategory);
//		assertEquals("Failed to retreive number of pages in a category ordered by the most viewed", 5, pages);
//	}
	/*
	 * dish testing finished here all other method of this are overloading which
	 * analytically work
	 */
	
//	@Test
//	public void testFor() {
//		assertEquals("Failed to Work", 5, dishDAO.pageNumberMostOrderedPageable(1));
//	}

}
