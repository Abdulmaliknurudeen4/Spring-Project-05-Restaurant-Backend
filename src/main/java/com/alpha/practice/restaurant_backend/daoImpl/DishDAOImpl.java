package com.alpha.practice.restaurant_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alpha.practice.restaurant_backend.dao.CategoryDAO;
import com.alpha.practice.restaurant_backend.dao.DishDAO;
import com.alpha.practice.restaurant_backend.dto.Dish;
import com.alpha.practice.restaurant_backend.dto.DishCategory;

@Repository("dishRepository")
public class DishDAOImpl implements DishDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private CategoryDAO dishCategoryDAO;

	// always instatiate the rawHandlers or there will be null pointer
	private ExtractedTypes rawHandlers = new ExtractedTypes();

	// get a product by Id
	public Dish getDish(long id) {
		if (id == 0) {
			return null;
		}
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().get(Dish.class, Long.valueOf(id));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean addDish(Dish dish) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(dish);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateDish(Dish dish) {
		// TODO Auto-generated method stub
		// update method
		try {
			sessionFactory.getCurrentSession().update(dish);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteDish(Dish dish) {
		// TODO Auto-generated method stub
		try {
			dish.setActive(false);
			this.updateDish(dish);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Return the number of pages availabe in the list by normal looping using the
	 * default page sizes and constraints 1- for 10 per page, other - 3 per page
	 * 1-10
	 * **-3
	 */
	public int getPagesInListDish(int pagesize) {
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}
		long allDishes = (Long) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM Dish")
				.getSingleResult();
		String value = String.valueOf(allDishes);
		return rawHandlers.getPages(Integer.valueOf(value), pagecapacity);
	}

	/*
	 * Pagination Supported
	 */
	public List<Dish> getAllDish(int pagesize, int page) {
		// TODO Auto-generated method stub
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		String SQL = "FROM Dish d ORDER BY d.id ASC";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		List<Dish> dishList = (List<Dish>) query.setFirstResult(rawHandlers.startPagination(pagecapacity, page))
				.setMaxResults(pagecapacity).getResultList();

		return dishList;

	}
	/*
	 * BUSINESS METHODS
	 */

	/*
	 * returns active dishes by their category tested
	 */
	public List<Dish> getActiveDishByCategoryPageable(int pagesize, int page, long categoryId) {
		// TODO Auto-generated method stub
		List<Dish> dishes = null;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		if (categoryId == 0) {
			return null;
		} else {
			String SQL = "FROM Dish d WHERE d.category = :dcategory AND d.active=:dactive ORDER BY d.id ASC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dcategory", dishCategoryDAO.getCategory(categoryId));
			query.setParameter("dactive", true);
			dishes = (List<Dish>) query.setFirstResult(rawHandlers.startPagination(pagecapacity, page))
					.setMaxResults(pagecapacity).getResultList();

		}

		return dishes;
	}

	/*
	 * returns number of pages available, active dishes by their category tested
	 */
	public int pageNumberActiveDishByCategoryPageable(int pagesize, long categoryId) {
		// TODO Auto-generated method stub
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		if (categoryId == 0) {
			return 0;
		} else {
			String SQL = "SELECT COUNT(*) FROM Dish d WHERE d.category = :dcategory AND d.active=:dactive ORDER BY d.id ASC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dcategory", dishCategoryDAO.getCategory(categoryId));
			query.setParameter("dactive", true);
			long stringValue = (Long) query.getSingleResult();
			numberOfPages = Integer.valueOf(
					String.valueOf(rawHandlers.getPages(Integer.valueOf(String.valueOf(stringValue)), pagecapacity)));

		}
		return numberOfPages;
	}

	/*
	 * same just different parameters returns active dishes by their category tested
	 */
	public List<Dish> getActiveDishByCategoryPageable(int pagesize, int page, DishCategory categoryId) {
		// TODO Auto-generated method stub
		List<Dish> dishes = null;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		if (categoryId == null) {
			return null;
		} else {
			String SQL = "FROM Dish d WHERE d.category = :dcategory AND d.active=:dactive ORDER BY d.id ASC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dcategory", categoryId);
			query.setParameter("dactive", true);
			dishes = (List<Dish>) query.setFirstResult(rawHandlers.startPagination(pagecapacity, page))
					.setMaxResults(pagecapacity).getResultList();

		}

		return dishes;
	}

	/*
	 * Pages Number returns count of active dishes by their category tested
	 */
	public int pageNumberActiveDishByCategoryPageable(int pagesize, DishCategory categoryId) {
		// TODO Auto-generated method stub
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		if (categoryId == null) {
			return 0;
		} else {
			String SQL = "SELECT COUNT(*) FROM Dish d WHERE d.category = :dcategory AND d.active=:dactive ORDER BY d.id ASC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dcategory", categoryId);
			query.setParameter("dactive", true);
			long stringValue = (Long) query.getSingleResult();
			numberOfPages = Integer.valueOf(
					String.valueOf(rawHandlers.getPages(Integer.valueOf(String.valueOf(stringValue)), pagecapacity)));

		}
		return numberOfPages;
	}

	/*
	 * Get All Dishes Active and Inactive Dishes returns the List tested
	 */
	public List<Dish> getAllDishByCategoryPageable(int pagesize, int page, long categoryId) {
		// TODO Auto-generated method stub
		List<Dish> dishes = null;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		if (categoryId == 0) {
			return null;
		} else {
			String SQL = "FROM Dish d WHERE d.category = :dcategory ORDER BY d.id ASC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dcategory", dishCategoryDAO.getCategory(categoryId));
			dishes = (List<Dish>) query.setFirstResult(rawHandlers.startPagination(pagecapacity, page))
					.setMaxResults(pagecapacity).getResultList();

		}

		return dishes;
	}

	/*
	 * Get All Dishes Active and Inactive Dishes returns the number of Pages
	 * Available tested
	 */
	public int pageNumberAllDishByCategoryPageable(int pagesize, long categoryId) {
		// TODO Auto-generated method stub
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		if (categoryId == 0) {
			return 0;
		} else {
			String SQL = "SELECT COUNT(*) FROM Dish d WHERE d.category = :dcategory ORDER BY d.id ASC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dcategory", dishCategoryDAO.getCategory(categoryId));
			long stringValue = (Long) query.getSingleResult();
			numberOfPages = Integer.valueOf(
					String.valueOf(rawHandlers.getPages(Integer.valueOf(String.valueOf(stringValue)), pagecapacity)));

		}
		return numberOfPages;
	}

	/*
	 * Same Method Using the object only
	 * 
	 */
	public List<Dish> getAllDishByCategoryPageable(int pagesize, int page, DishCategory categoryId) {
		// TODO Auto-generated method stub
		List<Dish> dishes = null;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		if (categoryId == null) {
			return null;
		} else {
			String SQL = "FROM Dish d WHERE d.category = :dcategory ORDER BY d.id ASC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dcategory", categoryId);
			dishes = (List<Dish>) query.setFirstResult(rawHandlers.startPagination(pagecapacity, page))
					.setMaxResults(pagecapacity).getResultList();

		}

		return dishes;
	}

	/*
	 * Page Count using the Object Only
	 */
	public int pageNumberAllDishByCategoryPageable(int pagesize, DishCategory categoryId) {
		// TODO Auto-generated method stub
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		if (categoryId == null) {
			return 0;
		} else {
			String SQL = "SELECT COUNT(*) FROM Dish d WHERE d.category = :dcategory ORDER BY d.id ASC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dcategory", categoryId);
			long stringValue = (Long) query.getSingleResult();
			numberOfPages = Integer.valueOf(
					String.valueOf(rawHandlers.getPages(Integer.valueOf(String.valueOf(stringValue)), pagecapacity)));

		}
		return numberOfPages;
	}

	/*
	 * Most Ordered Implementation for active dishes
	 */
	public List<Dish> getMostOrderedActivePageable(int pagesize, int page) {
		// TODO Auto-generated method stub
		List<Dish> dishes = null;
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}
		String SQL = "FROM Dish d WHERE d.active=:dactive ORDER BY d.purchases DESC";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		query.setParameter("dactive", true);
		dishes = (List<Dish>) query.setFirstResult(rawHandlers.startPagination(pagecapacity, page))
				.setMaxResults(pagecapacity).getResultList();
		return dishes;
	}

	/*
	 * Get Dishes but order by the mostordered only dishes that are active returns
	 * number of pages available
	 */
	public int pageNumberMostOrderedActivePageable(int pagesize) {
		// TODO Auto-generated method stub
		String SQL = "SELECT COUNT(*) FROM Dish d WHERE d.active=:dactive ORDER BY d.purchases DESC";
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		query.setParameter("dactive", true);
		long stringValue = (Long) query.getSingleResult();
		numberOfPages = Integer.valueOf(
				String.valueOf(rawHandlers.getPages(Integer.valueOf(String.valueOf(stringValue)), pagecapacity)));
		return numberOfPages;
	}

	/*
	 * Most Orderd by Category where the dishes are active
	 */
	public List<Dish> getMostOrderedActiveByCategoryPageable(int pagesize, int page, DishCategory category) {
		// TODO Auto-generated method stub
		List<Dish> dishes = null;
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		if (category == null) {
			return null;
		} else {
			String SQL = "FROM Dish d WHERE d.category=:dcategory AND d.active=:dactive ORDER BY d.purchases DESC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dactive", true);
			query.setParameter("dcategory", category);
			dishes = (List<Dish>) query.setFirstResult(rawHandlers.startPagination(pagecapacity, page))
					.setMaxResults(pagecapacity).getResultList();
		}
		return dishes;
	}

	/*
	 * Most Ordered by Category where the dishes are active, return the pageNumber
	 */
	public int pageNumberMostOrderedActiveByCategoryPageable(int pagesize, DishCategory category) {
		// TODO Auto-generated method stub
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		if (category == null) {
			return 0;
		} else {
			String SQL = "SELECT COUNT(*) FROM Dish d WHERE d.category=:dcategory AND d.active=:dactive ORDER BY d.purchases DESC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dactive", true);
			query.setParameter("dcategory", category);
			long stringValue = (Long) query.getSingleResult();
			numberOfPages = Integer.valueOf(
					String.valueOf(rawHandlers.getPages(Integer.valueOf(String.valueOf(stringValue)), pagecapacity)));
		}
		return numberOfPages;
	}

	/*
	 * Same Method using long id
	 */
	public List<Dish> getMostOrderedActiveByCategoryPageable(int pagesize, int page, long categoryId) {
		List<Dish> dishes = null;
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		if (categoryId == 0) {
			return null;
		} else {
			// if the id is number
			String SQL = "FROM Dish d WHERE d.category=:dcategory AND d.active=:dactive ORDER BY d.purchases DESC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dactive", true);
			query.setParameter("dcategory", dishCategoryDAO.getCategory(categoryId));
			dishes = (List<Dish>) query.setFirstResult(rawHandlers.startPagination(pagecapacity, page))
					.setMaxResults(pagecapacity).getResultList();
		}
		return dishes;
	}

	/*
	 * Same Method implementation usingn Id
	 */
	public int pageNumberMostOrderedActiveByCategoryPageable(int pagesize, long categoryId) {
		// TODO Auto-generated method stub
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		if (categoryId == 0) {
			return 0;
		} else {
			String SQL = "SELECT COUNT(*) FROM Dish d WHERE d.category=:dcategory AND d.active=:dactive ORDER BY d.purchases DESC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dactive", true);
			query.setParameter("dcategory", dishCategoryDAO.getCategory(categoryId));
			long stringValue = (Long) query.getSingleResult();
			numberOfPages = Integer.valueOf(
					String.valueOf(rawHandlers.getPages(Integer.valueOf(String.valueOf(stringValue)), pagecapacity)));
		}
		return numberOfPages;
	}
	// admin methods for viewing active and inactive dishes

	/*
	 * Most Ordered including active and inactive dishes returns the list by paging
	 */
	public List<Dish> getMostOrderedPageable(int pagesize, int page) {
		// TODO Auto-generated method stub
		List<Dish> dishes = null;
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}
		String SQL = "FROM Dish d ORDER BY d.purchases DESC";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		dishes = (List<Dish>) query.setFirstResult(rawHandlers.startPagination(pagecapacity, page))
				.setMaxResults(pagecapacity).getResultList();
		return dishes;
	}

	/*
	 * Most Ordered including active and inactive dishes returns number of pages
	 */
	public int pageNumberMostOrderedPageable(int pagesize) {
		String SQL = "SELECT COUNT(*) FROM Dish d ORDER BY d.purchases DESC";
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		long stringValue = (Long) query.getSingleResult();
		numberOfPages = Integer.valueOf(
				String.valueOf(rawHandlers.getPages(Integer.valueOf(String.valueOf(stringValue)), pagecapacity)));
		return numberOfPages;
	}

	/*
	 * Most Ordered by category including active and inactive dishes returns the
	 * list by paging
	 */
	public List<Dish> getMostOrderedByCategoryPageable(int pagesize, int page, DishCategory category) {
		// TODO Auto-generated method stub
		List<Dish> dishes = null;
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		if (category == null) {
			return null;
		} else {
			String SQL = "FROM Dish d WHERE d.category=:dcategory ORDER BY d.purchases DESC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dcategory", category);
			dishes = (List<Dish>) query.setFirstResult(rawHandlers.startPagination(pagecapacity, page))
					.setMaxResults(pagecapacity).getResultList();
		}
		return dishes;
	}

	/*
	 * Most Ordered by Category including active and inactive dishes returns number
	 * of pages
	 */
	public int pageNumberMostOrderedByCategoryPageable(int pagesize, DishCategory category) {
		// TODO Auto-generated method stub
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		if (category == null) {
			return 0;
		} else {
			String SQL = "SELECT COUNT(*) FROM Dish d WHERE d.category=:dcategory ORDER BY d.purchases DESC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dcategory", category);
			long stringValue = (Long) query.getSingleResult();
			numberOfPages = Integer.valueOf(
					String.valueOf(rawHandlers.getPages(Integer.valueOf(String.valueOf(stringValue)), pagecapacity)));
		}
		return numberOfPages;
	}

	/*
	 * Overloading returns the list
	 */
	public List<Dish> getMostOrderedByCategoryPageable(int pagesize, int page, long categoryId) {
		// TODO Auto-generated method stub
		List<Dish> dishes = null;
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		if (categoryId == 0) {
			return null;
		} else {
			// if the id is number
			String SQL = "FROM Dish d WHERE d.category=:dcategory ORDER BY d.purchases DESC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dcategory", dishCategoryDAO.getCategory(categoryId));
			dishes = (List<Dish>) query.setFirstResult(rawHandlers.startPagination(pagecapacity, page))
					.setMaxResults(pagecapacity).getResultList();
		}
		return dishes;
	}

	/*
	 * Overloading returns number of pages
	 */
	public int pageNumberMostOrderedByCategoryPageable(int pagesize, long categoryId) {
		// TODO Auto-generated method stub
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		if (categoryId == 0) {
			return 0;
		} else {
			String SQL = "SELECT COUNT(*) FROM Dish d WHERE d.category=:dcategory ORDER BY d.purchases DESC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dcategory", dishCategoryDAO.getCategory(categoryId));
			long stringValue = (Long) query.getSingleResult();
			numberOfPages = Integer.valueOf(
					String.valueOf(rawHandlers.getPages(Integer.valueOf(String.valueOf(stringValue)), pagecapacity)));
		}
		return numberOfPages;
	}
	// admin method ends here

	/*
	 * Most Viewed Implementation for active dishes untested
	 */
	// Most viewed
	public List<Dish> getMostViewedActivePageable(int pagesize, int page) {
		// TODO Auto-generated method stub
		List<Dish> dishes = null;
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}
		String SQL = "FROM Dish d WHERE d.active=:dactive ORDER BY d.views DESC";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		query.setParameter("dactive", true);
		dishes = (List<Dish>) query.setFirstResult(rawHandlers.startPagination(pagecapacity, page))
				.setMaxResults(pagecapacity).getResultList();
		return dishes;
	}

	/*
	 * Most Viewed pages return int
	 */
	public int pageNumberMostViewedActivePageable(int pagesize) {
		String SQL = "SELECT COUNT(*) FROM Dish d WHERE d.active=:dactive ORDER BY d.views DESC";
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		query.setParameter("dactive", true);
		long stringValue = (Long) query.getSingleResult();
		numberOfPages = Integer.valueOf(
				String.valueOf(rawHandlers.getPages(Integer.valueOf(String.valueOf(stringValue)), pagecapacity)));
		return numberOfPages;
	}

	/*
	 * Most Viewed by Category and where the dishes are active
	 */
	public List<Dish> getMostViewedActiveByCategoryPageable(int pagesize, int page, DishCategory category) {
		List<Dish> dishes = null;
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		if (category == null) {
			return null;
		} else {
			String SQL = "FROM Dish d WHERE d.category=:dcategory AND d.active=:dactive ORDER BY d.views DESC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dactive", true);
			query.setParameter("dcategory", category);
			dishes = (List<Dish>) query.setFirstResult(rawHandlers.startPagination(pagecapacity, page))
					.setMaxResults(pagecapacity).getResultList();
		}

		return dishes;
	}

	/*
	 * Most Viewed by Category and where the dishes are active, page count 
	 */
	public int pageNumberMostViewedActiveByCategoryPageable(int pagesize, DishCategory category) {
		// TODO Auto-generated method stub
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}
		if (category == null) {
			return 0;
		} else {

			String SQL = "SELECT COUNT(*) FROM Dish d WHERE d.category=:dcategory AND d.active=:dactive ORDER BY d.views DESC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dactive", true);
			query.setParameter("dcategory", category);
			long stringValue = (Long) query.getSingleResult();
			numberOfPages = Integer.valueOf(
					String.valueOf(rawHandlers.getPages(Integer.valueOf(String.valueOf(stringValue)), pagecapacity)));
		}
		return numberOfPages;
	}

	/*
	 * Same implementation using id
	 */
	public List<Dish> getMostViewedActiveByCategoryPageable(int pagesize, int page, long categoryId) {
		List<Dish> dishes = null;
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}

		if (categoryId == 0) {
			return null;
		} else {
			String SQL = "FROM Dish d WHERE d.category=:dcategory AND d.active=:dactive ORDER BY d.views DESC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dactive", true);
			query.setParameter("dcategory", dishCategoryDAO.getCategory(categoryId));
			dishes = (List<Dish>) query.setFirstResult(rawHandlers.startPagination(pagecapacity, page))
					.setMaxResults(pagecapacity).getResultList();
		}

		return dishes;
	}

	/*
	 * Same implementation using id, return pages number
	 */
	public int pageNumberMostViewedActiveByCategoryPageable(int pagesize, long categoryId) {
		// TODO Auto-generated method stub
		int numberOfPages = 0;
		int pagecapacity = 0;
		if (pagesize == 1) {
			pagecapacity = DEFAULT_PAGE_SIZE;
		} else {
			pagecapacity = DEFAUlT_SCROLL_SIZE_SMALL;
		}
		if (categoryId == 0) {
			return 0;
		} else {

			String SQL = "SELECT COUNT(*) FROM Dish d WHERE d.category=:dcategory AND d.active=:dactive ORDER BY d.views DESC";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("dactive", true);
			query.setParameter("dcategory", dishCategoryDAO.getCategory(categoryId));
			long stringValue = (Long) query.getSingleResult();
			numberOfPages = Integer.valueOf(
					String.valueOf(rawHandlers.getPages(Integer.valueOf(String.valueOf(stringValue)), pagecapacity)));
		}
		return numberOfPages;
	}

}
