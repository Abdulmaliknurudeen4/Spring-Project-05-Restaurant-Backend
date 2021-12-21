package com.alpha.practice.restaurant_backend.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alpha.practice.restaurant_backend.dao.UserDAO;
import com.alpha.practice.restaurant_backend.dto.Address;
import com.alpha.practice.restaurant_backend.dto.User;
import com.alpha.practice.restaurant_backend.dto.UserTable;
import com.alpha.practice.restaurant_backend.enumIdentifiers.Customer_Type;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static User user;
	private static List<Address> addresses;
	private static List<Address> shippings;
	private static UserDAO userDAO;
	private static UserTable userTable;

	private static Address shippingAddress;
	private static Address billingAddress;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.alpha.practice.restaurant_backend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userRepository");
	}
//
//	@Test
//	public void insertUserToDb() {
//
//		user = new User();
//		user.setFirstName("AbdulMalik");
//		user.setLastName("Nurudeen");
//		user.setPassword("$2a$10$AoicLaeESO5TA6DEBO/uD.jVEva.Feb8KHo7Mdb0SZkZoKzsZDISq");
//		user.setActive(true);
//		user.setContactInfo("080559182");
//		user.setCreationDate(new Date());
//		user.setCustomerType(Customer_Type.VEGETARIAN);
//		user.setEmail("abdulmaliknurudeen4@gmail.com");
//		user.setRoles("ROLE_USER");
//		user.setPermissions("AUTH_USER");
//		user.setUserTable(null);
//
//		// Addresses
//		billingAddress = new Address();
//		billingAddress.setAddressOne("Billing Address ");
//		billingAddress.setAddressTwo("Billing Address Two index");
//		billingAddress.setBilling(true);
//		billingAddress.setCity("City of ");
//		billingAddress.setCountry("Country ");
//		billingAddress.setPostalCode("110110");
//		billingAddress.setShipping(false);
//		billingAddress.setState("State ");
//		billingAddress.setUser(user);
//
//		shippingAddress = new Address();
//		shippingAddress.setAddressOne("Shipping Address ");
//
//		shippingAddress.setAddressTwo("Shipping Address Two ");
//		shippingAddress.setBilling(false);
//		shippingAddress.setCity("Shipping city ");
//		shippingAddress.setCountry("Shipping Country ");
//		shippingAddress.setPostalCode("110110");
//		shippingAddress.setShipping(true);
//		shippingAddress.setState("Shipping State ");
//		shippingAddress.setUser(user);
//
////			addresses = new ArrayList<Address>();
////			addresses.add(billingAddress);
////			addresses.add(shippingAddress);
////			user.setAddress(addresses);
//		// cart
//		if (user.getRoles().equals("ROLE_USER")) {
//			userTable = new UserTable();
//			userTable.setUser(user);
//			user.setUserTable(userTable);
//		}
//
//		assertEquals("Failed to Add User to Database alongside its properties", true, userDAO.addUser(user));
//		assertEquals("Failed to Add User's address for shipping", true, userDAO.addAddress(shippingAddress));
//		assertEquals("Failed to Add User's address for billing", true, userDAO.addAddress(billingAddress));
//
//	}
//
//	@Test
//	public void updateUserAddress() {
//		user = userDAO.findUserbyEmail("abdulmaliknurudeen4@gmail.com");
//		addresses = user.getAddress();
//		billingAddress = userDAO.getBillingAddress(user);
//		shippings = userDAO.getShippingAddress(user);
//		// updating billing address
//		billingAddress.setAddressOne("Changed Address One of Billing");
//		billingAddress.setAddressTwo("Changed Address Two of Billing");
//		billingAddress.setBilling(true);
//		billingAddress.setCountry("Nairobi");
//		billingAddress.setCity("Hamsterdam");
//		billingAddress.setShipping(false);
//		billingAddress.setState("United Nations");
//		billingAddress.setUser(user);
//		// billing address updating
//		assertEquals("Failed to update the billing address of User " + user.getEmail(), true,
//				userDAO.updateAddress(billingAddress));
//
//		// remove all the shipping addresses
//			assertEquals("Failed to remove billing address", true, userDAO.deleteAddress(shippings.get(1)));
//
//	}

}
