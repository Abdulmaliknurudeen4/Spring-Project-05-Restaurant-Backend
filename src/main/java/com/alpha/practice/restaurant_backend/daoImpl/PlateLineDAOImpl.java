package com.alpha.practice.restaurant_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alpha.practice.restaurant_backend.dao.PlateLineDAO;
import com.alpha.practice.restaurant_backend.dto.Dish;
import com.alpha.practice.restaurant_backend.dto.Plate_Line;
import com.alpha.practice.restaurant_backend.dto.User;
import com.alpha.practice.restaurant_backend.dto.UserTable;

@Repository("plateLineRepository")
public class PlateLineDAOImpl implements PlateLineDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private ExtractedTypes rawHandlers = new ExtractedTypes();

	public Plate_Line getPlateLine(long id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Plate_Line.class, id);
	}

	public boolean addPlateLine(Plate_Line plateLine) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(plateLine);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean updatePlateLine(Plate_Line plateLine) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(plateLine);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean deletePlateLine(Plate_Line plateLine) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(plateLine);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public List<Plate_Line> getPlateLines(User user) {
		// TODO Auto-generated method stub
		String SQL = "FROM Plate_Line p WHERE p.userTable.user=:user";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		query.setParameter("user", user);
		return (List<Plate_Line>) query.getResultList();
	}

	public List<Plate_Line> getPlateLines(UserTable table) {
		// TODO Auto-generated method stub
		String SQL = "FROM Plate_Line p WHERE p.userTable=:userTable";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		query.setParameter("userTable", table);
		return (List<Plate_Line>) query.getResultList();
	}

	public List<Plate_Line> getPlateLines(long tableId) {
		// TODO Auto-generated method stub
		String SQL = "FROM Plate_Line p WHERE p.userTable.id=:id";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		query.setParameter("id", tableId);
		return (List<Plate_Line>) query.getResultList();
	}

	public boolean updateUserTable(UserTable userTable) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(userTable);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public List<Plate_Line> listAvailabe(User user) {
		// TODO Auto-generated method stub
		String SQL = "FROM Plate_Line p WHERE p.userTable.user=:user AND p.avalaible=:aval";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		query.setParameter("user", user);
		query.setParameter("aval", true);
		return (List<Plate_Line>) query.getResultList();
	}

	public List<Plate_Line> listAvailabe(UserTable usertable) {
		// TODO Auto-generated method stub
		String SQL = "FROM Plate_Line p WHERE p.userTable=:userTable AND p.avalaible=:aval";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		query.setParameter("userTable", usertable);
		query.setParameter("aval", true);
		return (List<Plate_Line>) query.getResultList();
	}

	public List<Plate_Line> listAvailabe(long userTableId) {
		// TODO Auto-generated method stub
		String SQL = "FROM Plate_Line p WHERE p.userTable.id=:id AND p.avalaible=:aval";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		query.setParameter("id", userTableId);
		query.setParameter("aval", true);
		return (List<Plate_Line>) query.getResultList();
	}

	public Plate_Line getByUserTableAndDish(UserTable table, Dish dish) {
		// TODO Auto-generated method stub use code
		String SQL = "FROM Plate_Line p WHERE p.userTable=:userTable AND p.dish=:dish";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		query.setParameter("userTable", table);
		query.setParameter("dish", dish);
		// checks if it is an empty result
		// returns single result if not
		// this is done to prevent error of no entity found
		if (query.getResultList().isEmpty()) {
			return null;
		} else {
			return (Plate_Line) query.getSingleResult();
		}

	}

	public Plate_Line getByUserTableAndDish(long tableId, long dishId) {
		// TODO Auto-generated method stub error
		String SQL = "FROM Plate_Line p WHERE p.userTable.id=:userTableId AND p.dish.id=:id";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		query.setParameter("userTableId", tableId);
		query.setParameter("id", dishId);
		// checks if it is an empty result
		// returns single result if not
		// this is done to prevent error of no entity found
		if (query.getResultList().isEmpty()) {
			return null;
		} else {
			return (Plate_Line) query.getSingleResult();
		}
	}

}
