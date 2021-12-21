package com.alpha.practice.restaurant_backend.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.swing.JOptionPane;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alpha.practice.restaurant_backend.dao.DishDAO;
import com.alpha.practice.restaurant_backend.dao.MenuDAO;
import com.alpha.practice.restaurant_backend.dto.Dish;
import com.alpha.practice.restaurant_backend.dto.Menu;

public class MenuTestCase {
	private static AnnotationConfigApplicationContext context;
	private static Menu menu;
	private static List<Menu> menus;
	private static MenuDAO menuDAO;

	private static Dish dish;
	private static List<Dish> dishes;
	private static DishDAO dishDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.alpha.practice.restaurant_backend");
		context.refresh();
		menuDAO = (MenuDAO) context.getBean("menuRepository");
		dishDAO = (DishDAO) context.getBean("dishRepository");
	}

//	@Test
//	public void insertMenu() {
//		menu = new Menu();
//		dishes = dishDAO.getAllDish(1, 1);
//		assertEquals("Failed to retrieve it to correct size", 10, dishes.size());
//		menu.setDishes(dishes);
//		assertEquals("Failed to add Menu to the database", true, menuDAO.addMenuForToday(menu));
//	}

//	@Test
//	public void insertMenuForFutureDate() {
//		menu = new Menu();
//		dishes = dishDAO.getAllDish(1, 2);
//		assertEquals("Failed to retrieve it to correct size", 10, dishes.size());
//		menu.setDishes(dishes);
//		assertEquals("Failed to add Menu to the database", true,
//				menuDAO.addMenuForFutureDate(menu, LocalDate.of(2020, 3, 30)));
//	}

//	@Test
//	public void getMenuForToday() {
//		menu = menuDAO.getMenuForToday();
//		assertEquals("Failed to retrieve menu for Today's Date of " + LocalDate.now(), LocalDate.now(),
//				menu.getMenuDate());
//	}
//
//	@Test
//	public void getMenuForFutureDate() {
//		menu = menuDAO.getMenuForDate(LocalDate.of(2020, 2, 29));
//		assertEquals("Failed to retrieve menu for Future Date of " + LocalDate.of(2020, 2, 29),
//				LocalDate.of(2020, 2, 29), menu.getMenuDate());
//	}

//	@Test
//	public void getMenu() {
//		menu = menuDAO.getMenu(57);
//		assertEquals("Failed to Retrieve Menu with specific id", 57, menu.getId());
//	}

//	@Test
//	public void getAllMenu() {
//		menus = menuDAO.getAllMenuRecorded();
//		assertEquals("Failed to Retrieve all the menu in the databases", 1, menus.size());
//	}

//	@Test
//	public void dropMenu() {
//		assertEquals("Failed to drop menu from the menu table ", true,menuDAO.dropMenu(menuDAO.getMenu(59)));
//	}
	
//	@Test
//	public void getSpecifics() {
//		
//	}
}
