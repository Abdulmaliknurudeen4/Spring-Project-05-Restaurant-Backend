package com.alpha.practice.restaurant_backend.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alpha.practice.restaurant_backend.dao.DishDAO;
import com.alpha.practice.restaurant_backend.dao.PlateLineDAO;
import com.alpha.practice.restaurant_backend.dao.UserDAO;
import com.alpha.practice.restaurant_backend.dto.Dish;
import com.alpha.practice.restaurant_backend.dto.Plate_Line;
import com.alpha.practice.restaurant_backend.dto.User;
import com.alpha.practice.restaurant_backend.dto.UserTable;

public class Plate_LineTestCase {
	private static AnnotationConfigApplicationContext context;

	private static PlateLineDAO plateDAO;
	private static UserDAO userDAO;
	private static DishDAO dishDAO;

	private Plate_Line plateLine = null;
	private UserTable userTable = null;
	private List<Plate_Line> plateLines = null;
	private List<Dish> dishes = null;
	private User user = null;
	private Dish dish = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.alpha.practice.restaurant_backend");
		context.refresh();
		plateDAO = (PlateLineDAO) context.getBean("plateLineRepository");
		dishDAO = (DishDAO) context.getBean("dishRepository");
		userDAO = (UserDAO) context.getBean("userRepository");
	}

//	@Test
//	public void insertPlateLinesOfDish() {
//		user = userDAO.findUserbyEmail("firstnameUserEmail3@gmail.com");
//		assertEquals("Failed to Retreive the User", "firstnameUserEmail3@gmail.com", user.getEmail());
//		userTable = user.getUserTable();
//		assertEquals("Failed to Retrive the User's Table", 14, userTable.getId());
//		dish = dishDAO.getDish(474);
//		//making the plate line
//		plateLine = new Plate_Line();
//		plateLine.setAvalaible(true);
//		plateLine.setBuyingPrice(dish.getUnitPrice());
//		plateLine.setCount(22);
//		plateLine.setDish(dish);
//		plateLine.setTotal(dish.getUnitPrice()*plateLine.getCount());
//		plateLine.setUserTable(userTable);
//		//setting the userTable
//		userTable.setDish_lines(userTable.getDish_lines()+1);
//		userTable.setGrandTotal(userTable.getGrandTotal()+plateLine.getTotal());
//		
//		assertEquals("Failed to update the userTable in the database", true, plateDAO.updateUserTable(userTable));
//		assertEquals("Failed to Add the PlateLine into the Database",true, plateDAO.addPlateLine(plateLine));
//		
//		
//
//	}

//	@Test
//	public void findPlateLineByDishAndUser() {
//		user = userDAO.findUserbyEmail("proflee204@gmail.com");
//		assertEquals("failed to retrieve the user", "proflee204@gmail.com", user.getEmail());
//		userTable = user.getUserTable();
//		assertEquals("Failed to Retrive the User's Table", 88, userTable.getId());
//		dish = dishDAO.getDish(51);
//		plateLine = plateDAO.getByUserTableAndDish(userTable, dish);
//		assertNotNull("The plate Line is not available", plateLine);
//	}

//	@Test
//	public void getPlateLineListOfUser() {
//		user = userDAO.findUserbyEmail("abdulmaliknurudeen5@gmail.com");
//		assertEquals("Failed to Retreive the User", "abdulmaliknurudeen5@gmail.com", user.getEmail());
//		userTable = user.getUserTable();
//		assertEquals("Failed to Retrive the User's Table", 2, userTable.getId());
//		
//		assertEquals("Failed to retrieve platelines for the user", 2, plateDAO.getPlateLines(userTable).size());
//	}

//	@Test
//	public void getPlateLineListofUserbyId() {
//		user = userDAO.findUserbyEmail("abdulmaliknurudeen5@gmail.com");
//		assertEquals("Failed to Retreive the User", "abdulmaliknurudeen5@gmail.com", user.getEmail());
//		userTable = user.getUserTable();
//		assertEquals("Failed to Retrive the User's Table", 2, userTable.getId());
//		
//		assertEquals("Failed to retrieve platelines for the user", 2, plateDAO.getPlateLines(userTable.getId()).size());

//		
//		user = userDAO.findUserbyEmail("abdulmaliknurudeen5@gmail.com");
//		assertEquals("Failed to Retreive the User", "abdulmaliknurudeen5@gmail.com", user.getEmail());
//		userTable = user.getUserTable();
//		assertEquals("Failed to Retrive the User's Table", 2, userTable.getId());
//		
//		assertEquals("Failed to retrieve platelines for the user", 2, plateDAO.getPlateLines(user).size());

//		user = userDAO.findUserbyEmail("abdulmaliknurudeen5@gmail.com");
//		assertEquals("Failed to Retreive the User", "abdulmaliknurudeen5@gmail.com", user.getEmail());
//		userTable = user.getUserTable();
//		assertEquals("Failed to Retrive the User's Table", 2, userTable.getId());
//		
//		assertEquals("Failed to retrieve platelines for the user", 2, plateDAO.listAvailabe(user).size());
//		
//		user = userDAO.findUserbyEmail("abdulmaliknurudeen5@gmail.com");
//		assertEquals("Failed to Retreive the User", "abdulmaliknurudeen5@gmail.com", user.getEmail());
//		userTable = user.getUserTable();
//		assertEquals("Failed to Retrive the User's Table", 2, userTable.getId());
//		dish = dishDAO.getDish(53);
//		assertEquals("Failed to retrieve platelines for the user", true, plateDAO.getByUserTableAndDish(userTable, dish).isAvalaible());
//	}
	
//	@Test
//	public void clearUserTable() {
//		User user = userDAO.findUserbyEmail("proflee204@gmail.com");
//	}
}
