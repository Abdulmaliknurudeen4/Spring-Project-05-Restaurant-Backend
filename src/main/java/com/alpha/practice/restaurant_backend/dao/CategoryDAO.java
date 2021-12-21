package com.alpha.practice.restaurant_backend.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.alpha.practice.restaurant_backend.dto.DishCategory;
@Transactional
public interface CategoryDAO {
	/*
	 * DAO for category Transactions
	 * */

	//saving a category
	boolean saveCategory(DishCategory dishcat);
	//getting a category with a specific id
	DishCategory getCategory(long id);
	//updating a category
	boolean updateCategory(DishCategory dishCat);
	//deleting a category
	boolean deleteCategory(DishCategory dishCat);
	//get all categories
	List<DishCategory> dishCategories();
	//Business Methods
	
	
	/*
	 * Getting the size of dishes that belong in that category visible and non visible
	 * */
	int categorySizeAll(DishCategory dishCat);
	List<DishCategory> dishCategoriesAllVisisbility();
	/*
	 * Getting the visible ones only
	*/
	int categoryVisibleSize(DishCategory dishCat);
	
}
