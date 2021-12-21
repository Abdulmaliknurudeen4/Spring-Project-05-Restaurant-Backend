package com.alpha.practice.restaurant_backend.daoImpl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alpha.practice.restaurant_backend.dao.OrderDriverDAO;
import com.alpha.practice.restaurant_backend.dto.OrderDetails;
import com.alpha.practice.restaurant_backend.dto.User;

//unfinished
//date issues
@Repository("orderDriverRepository")
public class OrderDriverDAOImpl implements OrderDriverDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private ExtractedTypes rawHandlers = new ExtractedTypes();

	public boolean addOrderDetails(OrderDetails details) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(details);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateOrderDetails(OrderDetails details) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(details);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteOrderDetails(long detailsId) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession()
					.delete(sessionFactory.getCurrentSession().get(OrderDetails.class, detailsId));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteOrderDetails(OrderDetails details) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(details);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public List<OrderDetails> getAllOrdersForToday() {
		// TODO Auto-generated method stub
		LocalDate now = LocalDate.now();
		String SQL = "FROM OrderDetails od WHERE od.orderDate=:orderDate";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		query.setParameter("orderDate", now);
		return (List<OrderDetails>) query.getResultList();
	}

	public List<OrderDetails> getOrderDetailsByDateAndUser(LocalDate date, User user) {
		// TODO Auto-generated method stub
		String SQL = "FROM OrderDetails od WHERE od.orderDate=:orderDate AND od.user=:user";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		query.setParameter("orderDate", date);
		query.setParameter("user", user);
		return (List<OrderDetails>) query.getResultList();
	}

	public List<OrderDetails> getOrderDetailsByDateAndUser(LocalDate date, long userId) {
		String SQL = "FROM OrderDetails od WHERE od.orderDate=:orderDate AND od.user=:user";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		query.setParameter("orderDate", date);
		query.setParameter("userId", userId);
		return (List<OrderDetails>) query.getResultList();
	}

	@Override
	public OrderDetails getOrderDetailsByCode(String Code) {
		// TODO Auto-generated method stub
		String SQL = "FROM OrderDetails od WHERE od.orderCode=:code";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		if (Code != null) {
			query.setParameter("code", Code);
			return (OrderDetails) query.getSingleResult();
		} else {
			return null;
		}
	}

}
