package com.alpha.practice.restaurant_backend.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.alpha.practice.restaurant_backend.dto.Dish;
import com.alpha.practice.restaurant_backend.dto.DishCategory;

@Transactional
public interface DishDAO {
	public static final int DEFAULT_PAGE_SIZE = 10;
	public static final int DEFAUlT_SCROLL_SIZE_SMALL = 3;

	/*
	 * Implementation for Data Access Object for Dish
	 */
	Dish getDish(long id);

	List<Dish> getAllDish(int pagesize, int page);

	int getPagesInListDish(int pagesize);

	// CRUD methods
	boolean addDish(Dish dish);

	boolean updateDish(Dish dish);

	boolean deleteDish(Dish dish);

	// implementation for getting pageable for dish goes here with the business
	// methods
	// default page size
	/*
	 * Active Products Implementation int return types are for getting page sizes
	 * for display
	 */
	List<Dish> getActiveDishByCategoryPageable(int pagesize, int page, long categoryId);

	int pageNumberActiveDishByCategoryPageable(int pagesize, long categoryId);

	// overloaded method provided for using Object
	List<Dish> getActiveDishByCategoryPageable(int pagesize, int page, DishCategory categoryId);

	int pageNumberActiveDishByCategoryPageable(int pagesize, DishCategory categoryId);

	/*
	 * All Products Implementation int return types are for getting page sizes for
	 * for admin display
	 */
	List<Dish> getAllDishByCategoryPageable(int pagesize, int page, long categoryId);

	int pageNumberAllDishByCategoryPageable(int pagesize, long categoryId);

	// overloaded method for Object usage
	List<Dish> getAllDishByCategoryPageable(int pagesize, int page, DishCategory categoryId);

	int pageNumberAllDishByCategoryPageable(int pagesize, DishCategory categoryId);
	/*
	 * Most Ordered implementation
	 */

	// **get most ordered active**
	List<Dish> getMostOrderedActivePageable(int pagesize, int page);

	int pageNumberMostOrderedActivePageable(int pagesize);

	// get most ordered by category
	List<Dish> getMostOrderedActiveByCategoryPageable(int pagesize, int page, DishCategory category);

	int pageNumberMostOrderedActiveByCategoryPageable(int pagesize, DishCategory category);

	// overloading
	List<Dish> getMostOrderedActiveByCategoryPageable(int pagesize, int page, long categoryId);

	int pageNumberMostOrderedActiveByCategoryPageable(int pagesize, long categoryId);

	// for admin implementation
	// **get most ordered active and inactive dishes**
	List<Dish> getMostOrderedPageable(int pagesize, int page);

	int pageNumberMostOrderedPageable(int pagesize);

	// get most ordered by category
	List<Dish> getMostOrderedByCategoryPageable(int pagesize, int page, DishCategory category);

	int pageNumberMostOrderedByCategoryPageable(int pagesize, DishCategory category);

	// overloading
	List<Dish> getMostOrderedByCategoryPageable(int pagesize, int page, long categoryId);

	int pageNumberMostOrderedByCategoryPageable(int pagesize, long categoryId);
	/* admin implementation stops here*/

	/*
	 * Most Viewed Implementation
	 */
	// **get most viewed active** *additions*

	List<Dish> getMostViewedActivePageable(int pagesize, int page);

	int pageNumberMostViewedActivePageable(int pagesize);

	// get most Viewed by category
	List<Dish> getMostViewedActiveByCategoryPageable(int pagesize, int page, DishCategory category);

	int pageNumberMostViewedActiveByCategoryPageable(int pagesize, DishCategory category);

	// overloading
	List<Dish> getMostViewedActiveByCategoryPageable(int pagesize, int page, long categoryId);

	int pageNumberMostViewedActiveByCategoryPageable(int pagesize, long categoryId);

	/*
	 * Remake above implementation for the admin so as to select active and inactive
	 * dishes but the above includes only active dishes, remake for order not view
	 * most order only matters to admin not implementing most viewed
	 */
}
