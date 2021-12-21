package com.alpha.practice.restaurant_backend.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.alpha.practice.restaurant_backend.dto.Menu;

@Transactional
public interface MenuDAO {
	/*
	 * CRUD for Menu display to Users
	 */
	Menu getMenu(long id);

	boolean addMenuForToday(Menu menu);

	boolean addMenuForFutureDate(Menu menu, LocalDate date);

	boolean updateMenu(Menu menu);

	boolean dropMenu(Menu menu);

	List<Menu> getAllMenuRecorded();

	// Might implement AOP to check if there are any menu with the same date, it
	// should drop all menu but for
	// now simple implementation
	Menu getMenuForToday();

	Menu getMenuForDate(LocalDate date);

}
