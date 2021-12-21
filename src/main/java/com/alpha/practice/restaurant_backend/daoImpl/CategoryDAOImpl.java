package com.alpha.practice.restaurant_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alpha.practice.restaurant_backend.dao.CategoryDAO;
import com.alpha.practice.restaurant_backend.dto.DishCategory;

@Repository("categoryRepository")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	private ExtractedTypes rawHandlers= new ExtractedTypes();

	public boolean saveCategory(DishCategory dishcat) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(dishcat);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public DishCategory getCategory(long id) {
		if (id == 0) {
			return null;
		}
		// TODO Auto-generated method stub

		return sessionFactory.getCurrentSession().get(DishCategory.class, Long.valueOf(id));
	}

	public boolean updateCategory(DishCategory dishCat) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(dishCat);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCategory(DishCategory dishCat) {
		try {
			dishCat.setActive(false);
			this.updateCategory(dishCat);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public List<DishCategory> dishCategories() {
		// TODO Auto-generated method stub
		String SQL = "FROM DishCategory WHERE active = :active";

		try {
			Query<?> query = rawHandlers.extracted(sessionFactory,SQL);
			query.setParameter("active", true);
			return (List<DishCategory>) query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * Counting the dishes in the categories for display purposes
	 * Gets counts of dishes in a specific category
	 * visibile and non visible
	 * */
	public int categorySizeAll(DishCategory dishCat) {
		// TODO Auto-generated method stub
		// later implementation for all category
		String SQL = "SELECT COUNT(*) FROM Dish d WHERE d.category=:dishCategory";
		Query<?> query = rawHandlers.extracted(sessionFactory,SQL);
		query.setParameter("dishCategory", dishCat);
		long result = (Long) query.getSingleResult();
		return Integer.valueOf(String.valueOf(result));
	}

	/*
	 * Counting the dishes in the categories for display purposes
	 * Gets counts of dishes in a specific category
	 * visibile
	 * */
	public int categoryVisibleSize(DishCategory dishCat) {
		// TODO Auto-generated method stub
		// visible category and product
		String SQL = "SELECT COUNT(*) FROM Dish d WHERE d.category=:dishCategory AND d.active=:dactive";
		Query<?> query = rawHandlers.extracted(sessionFactory,SQL);
		query.setParameter("dishCategory", dishCat);
		query.setParameter("dactive", true);
		long result = (Long) query.getSingleResult();
		return Integer.valueOf(String.valueOf(result));
	}

	/*
	 * Gets all Categories visible and non visible
	 * */
	public List<DishCategory> dishCategoriesAllVisisbility() {
		// TODO Auto-generated method stub
				String SQL = "FROM DishCategory";

				try {
					Query<?> query = rawHandlers.extracted(sessionFactory,SQL);
					return (List<DishCategory>) query.getResultList();
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
	}
}
