package com.alpha.practice.restaurant_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alpha.practice.restaurant_backend.dao.UserDAO;
import com.alpha.practice.restaurant_backend.dto.Address;
import com.alpha.practice.restaurant_backend.dto.User;

@Repository("userRepository")
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private ExtractedTypes rawHandlers = new ExtractedTypes();

	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return true;
		}
	}

	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		// TODO Auto-generated method stub
	}

	@Override
	public boolean updateAddress(Address address) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}

	// untested
	@Override
	public boolean deleteAddress(Address address) {
		// TODO Auto-generated method stub
//		String email = address.getUser().getEmail();
//		User user = this.findUserbyEmail(email);
//		user.getAddress().remove(address);
//		this.updateUser(user);
		try {
			sessionFactory.getCurrentSession().delete(address);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}

	public User findUserbyEmail(String email) {
		String SQL = "FROM User u WHERE u.email=:email";
		try {
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("email", email);
			return (User) query.getSingleResult();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		// TODO Auto-generated method stub
	}

	public Address getBillingAddress(User user) {
		// TODO Auto-generated method stub
		String SQL = "FROM Address WHERE user=:user AND billing=:billing";
		try {
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("user", user);
			query.setParameter("billing", true);
			return (Address) query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public List<Address> getShippingAddress(User user) {
		// TODO Auto-generated method stub
		String SQL = "FROM Address WHERE user=:user AND shipping=:shipping";
		try {
			Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
			query.setParameter("user", user);
			query.setParameter("shipping", true);
			return (List<Address>) query.getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public Address getAddress(long addressId) {
		try {
			return sessionFactory.getCurrentSession().get(Address.class, addressId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public boolean update(User user, boolean enabled) {
		try {
			user.setActive(enabled);
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User user, String password) {
		// TODO Auto-generated method stub
		try {
			user.setPassword(password);
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

}
