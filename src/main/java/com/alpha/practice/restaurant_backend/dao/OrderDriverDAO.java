package com.alpha.practice.restaurant_backend.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.alpha.practice.restaurant_backend.dto.OrderDetails;
import com.alpha.practice.restaurant_backend.dto.User;

@Transactional
public interface OrderDriverDAO {
	/*
	 * Implementing CRUD for Orders
	 */
	boolean addOrderDetails(OrderDetails details);

	boolean updateOrderDetails(OrderDetails details);

	boolean deleteOrderDetails(long detailsId);

	boolean deleteOrderDetails(OrderDetails details);

	//all orders pertaining for a today
	// this will be used by the ui to load all the orders for today into a table
	// then the admin can select any one to view the order details
	List<OrderDetails> getAllOrdersForToday();

	//get orderdetails of a particular user then was filed a particular date
	// used for the generation and tracking of invoices
	List<OrderDetails> getOrderDetailsByDateAndUser(LocalDate date, User user);

	//overloading
	List<OrderDetails> getOrderDetailsByDateAndUser(LocalDate date, long userId);
	
	//get orderDetials by code
	OrderDetails getOrderDetailsByCode(String Code);

}
