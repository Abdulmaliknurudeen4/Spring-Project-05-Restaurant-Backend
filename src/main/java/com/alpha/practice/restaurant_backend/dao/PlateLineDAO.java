package com.alpha.practice.restaurant_backend.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.alpha.practice.restaurant_backend.dto.Dish;
import com.alpha.practice.restaurant_backend.dto.Plate_Line;
import com.alpha.practice.restaurant_backend.dto.User;
import com.alpha.practice.restaurant_backend.dto.UserTable;
@Transactional
public interface PlateLineDAO {
	/*
	 * PlateLine DAO
	 * CRUD and business methods
	 * */
	//CRUD
	public Plate_Line getPlateLine(long id);
	public boolean addPlateLine(Plate_Line plateLine);
	public boolean updatePlateLine(Plate_Line plateLine);
	public boolean deletePlateLine(Plate_Line plateLine);
	public List<Plate_Line> getPlateLines(User user);
	public List<Plate_Line> getPlateLines(UserTable table);
	public List<Plate_Line> getPlateLines(long tableId);
	
	//updating the UserTable holding the plateLines
	boolean updateUserTable(UserTable userTable);
	
	
	//business Methods
	public List<Plate_Line> listAvailabe(User user);
	public List<Plate_Line> listAvailabe(UserTable usertable);
	public List<Plate_Line> listAvailabe(long userTableId);
	//
	public Plate_Line getByUserTableAndDish(UserTable table, Dish dish);
	public Plate_Line getByUserTableAndDish(long tableId, long dishId);

}
