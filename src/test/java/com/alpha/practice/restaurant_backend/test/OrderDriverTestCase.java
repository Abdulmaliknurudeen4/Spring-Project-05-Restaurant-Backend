package com.alpha.practice.restaurant_backend.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alpha.practice.restaurant_backend.dao.DishDAO;
import com.alpha.practice.restaurant_backend.dao.OrderDriverDAO;
import com.alpha.practice.restaurant_backend.dao.PlateLineDAO;
import com.alpha.practice.restaurant_backend.dao.UserDAO;
import com.alpha.practice.restaurant_backend.dto.Dish;
import com.alpha.practice.restaurant_backend.dto.OrderDetails;
import com.alpha.practice.restaurant_backend.dto.OrderDish;
import com.alpha.practice.restaurant_backend.dto.Plate_Line;
import com.alpha.practice.restaurant_backend.dto.User;
import com.alpha.practice.restaurant_backend.dto.UserTable;

public class OrderDriverTestCase {
	private static AnnotationConfigApplicationContext context;

	private static PlateLineDAO plateDAO;
	private static UserDAO userDAO;
	private static DishDAO dishDAO;
	private static OrderDriverDAO orderDriverDAO;

	private Plate_Line plateLine = null;
	private UserTable userTable = null;
	private List<Plate_Line> plateLines = null;
	private List<Dish> dishes = null;
	private User user = null;
	private Dish dish = null;
	private OrderDish orderDish;
	private List<OrderDish> orderDishes;
	private OrderDetails orderDetails;
	private List<OrderDetails> orderDetailses;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.alpha.practice.restaurant_backend");
		context.refresh();
		plateDAO = (PlateLineDAO) context.getBean("plateLineRepository");
		dishDAO = (DishDAO) context.getBean("dishRepository");
		userDAO = (UserDAO) context.getBean("userRepository");
		orderDriverDAO = (OrderDriverDAO) context.getBean("orderDriverRepository");
	}

	@Test
	public void insertOrderDetails() {
		// retrive the user
		user = userDAO.findUserbyEmail("firstnameUserEmail3@gmail.com");
		assertEquals("Failed to Retreive the User", "firstnameUserEmail3@gmail.com", user.getEmail());
		userTable = user.getUserTable();
		assertEquals("Failed to Retrive the User's Table", 14, userTable.getId());
		assertNotNull(userTable);
		plateLines = plateDAO.getPlateLines(userTable.getId());
		assertNotNull(plateLines);
		orderDishes = new ArrayList<OrderDish>();
		orderDetails = new OrderDetails();
		for (int i = 0; i < plateLines.size(); i++) {
			orderDish = new OrderDish();
			// inserting plateLine Details into the OrderDish with loop
			orderDish.setDish(plateLines.get(i).getDish());
			orderDish.setDishCount(plateLines.get(i).getCount());
			orderDish.setBuyingPrice(plateLines.get(i).getBuyingPrice());
			orderDish.setTotal(orderDish.getBuyingPrice() * orderDish.getDishCount());
			orderDish.setOrderDetails(null);
			// setting the orderDetails every time a new Order Dish is inserted
			orderDetails.setOrderTotal(orderDetails.getOrderTotal() + orderDish.getTotal());
			orderDetails.setOrderCount(orderDetails.getOrderCount() + 1);
			// let orderdish know
			orderDish.setOrderDetails(orderDetails);
			orderDishes.add(orderDish);

		}
		// inserting the table details into the OrderDetails
		orderDetails.setUser(user);
		orderDetails.setBilling(userDAO.getBillingAddress(user));
		orderDetails.setShipping(userDAO.getAddress(3));
		orderDetails.setOrderDate(LocalDate.now());
		// orderDishes = orderDetails.getOrderdishes();
		// orderDishes.add(orderDish);
		orderDetails.setOrderdishes(orderDishes);
		// testing
		assertEquals("Failed to persist the OrderDish and The OrderDetails into the database", true,
				orderDriverDAO.addOrderDetails(orderDetails));

	}
	
//	@Test
//	public void gettersTesting() {
//		dish = dishDAO.getDish(9);
//		user = userDAO.findUserbyEmail("abdulmaliknurudeen5@gmail.com");
//		plateLine = plateDAO.getByUserTableAndDish(user.getUserTable(), dish);
//		assertEquals("Failed to retreive the plate line of a user "+user.getFirstName()+","
//				+ " with the table id of "+user.getUserTable().getId(),
//				59, plateLine.getId());
//		
//	}

//	@Test
//	public void getorderDetailsTest() {
//		orderDetailses = orderDriverDAO.getAllOrdersForToday();
//		assertEquals("Getting all Orders for today failed", 1,
//				orderDriverDAO.getAllOrdersForToday().size());

//		
//		user = userDAO.findUserbyEmail("abdulmaliknurudeen5@gmail.com");
//		assertEquals("Failed to get inventory of the user abdulmalik 5", 1, 
//				orderDriverDAO.getOrderDetailsByDateAndUser(LocalDate.now(), user).size());
//			}
	
//	@Test
//	public void delete() {
//		assertEquals("Failed to delete", true,orderDriverDAO.deleteOrderDetails(628));
//	}

}
