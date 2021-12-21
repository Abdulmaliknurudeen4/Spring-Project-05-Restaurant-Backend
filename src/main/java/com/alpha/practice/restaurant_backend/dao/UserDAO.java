package com.alpha.practice.restaurant_backend.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.alpha.practice.restaurant_backend.dto.Address;
import com.alpha.practice.restaurant_backend.dto.User;

@Transactional
public interface UserDAO {
	/*
	 * Implementation CRUD for User and address
	 */
	boolean addUser(User user);

	//untested
	boolean updateUser(User user);

	boolean addAddress(Address address);

	//untested
	boolean updateAddress(Address address);
	//untested
	boolean deleteAddress(Address address);

	// find user by Email
	User findUserbyEmail(String email);

	// get first address for registration that is the billing address
	Address getBillingAddress(User user);

	// get the list of all address
	List<Address> getShippingAddress(User user);

	// single address
	Address getAddress(long addressId);

	// disable user through update method
	boolean update(User user, boolean enabled);

	// changing details
	boolean update(User user, String password);

}
