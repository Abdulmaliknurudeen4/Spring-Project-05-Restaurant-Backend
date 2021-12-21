package com.alpha.practice.restaurant_backend.daoImpl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alpha.practice.restaurant_backend.dao.MenuDAO;
import com.alpha.practice.restaurant_backend.dto.Menu;

@Repository("menuRepository")
public class MenuDAOImpl implements MenuDAO {
	@Autowired
	private SessionFactory sessionFactory;
	private ExtractedTypes rawHandlers = new ExtractedTypes();

	public boolean addMenuForToday(Menu menu) {
		try {
			LocalDate today = LocalDate.now();
			menu.setMenuDate(today);
			sessionFactory.getCurrentSession().persist(menu);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean addMenuForFutureDate(Menu menu, LocalDate date) {

		try {
			Menu menuSave = menu;
			menuSave.setMenuDate(date);
			sessionFactory.getCurrentSession().persist(menuSave);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateMenu(Menu menu) {
		try {
			sessionFactory.getCurrentSession().update(menu);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean dropMenu(Menu menu) {
		try {
			sessionFactory.getCurrentSession().delete(menu);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public List<Menu> getAllMenuRecorded() {
		// TODO Auto-generated method stub
		String SQL = "FROM Menu";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		@SuppressWarnings("unchecked")
		List<Menu> menus = (List<Menu>) query.getResultList();
		return menus;
	}

	public Menu getMenu(long id) {
		try {
			Menu menuReturn = sessionFactory.getCurrentSession().get(Menu.class, id);
			return menuReturn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Menu getMenuForToday() {
		try {
			LocalDate today = LocalDate.now();

			String SQL = "FROM Menu m WHERE m.menuDate = :date";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("date", today);
			Menu menuReturn = (Menu) query.getSingleResult();
			return menuReturn;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public Menu getMenuForDate(LocalDate date) {
		try {
			String SQL = "FROM Menu m WHERE m.menuDate = :date";
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("date", date);
			Menu menuReturn = (Menu) query.getSingleResult();
			return menuReturn;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
