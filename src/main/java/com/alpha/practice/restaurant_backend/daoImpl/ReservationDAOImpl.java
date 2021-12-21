package com.alpha.practice.restaurant_backend.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alpha.practice.restaurant_backend.dao.ReservationDAO;
import com.alpha.practice.restaurant_backend.dto.Reservation;

@Repository("reservationRepository")
public class ReservationDAOImpl implements ReservationDAO {
	@Autowired
	private SessionFactory sessionFactory;

	private ExtractedTypes rawHandlers = new ExtractedTypes();

	public boolean AddReservation(Reservation reser) {
		try {
			sessionFactory.getCurrentSession().persist(reser);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean UpdateEmailForReservation(Reservation reserv) {
		try {
			sessionFactory.getCurrentSession().update(reserv);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean cancelReservation(Reservation reserv) {
		try {
			sessionFactory.getCurrentSession().delete(reserv);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Reservation getReservationByEmail(String email) {
		if (email.equals("") || email == null) {
			return null;
		}
		String SQL = "FROM Reservation R WHERE R.email=:email";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		query.setParameter("email", email);
		Reservation reservation = (Reservation) query.getSingleResult();
		return reservation;
	}

	public List<Reservation> getAllReservations() {
		// TODO Auto-generated method stub
		String SQL = "FROM Reservation";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		List<Reservation> reservations = (List<Reservation>) query.getResultList();
		return reservations;
	}

	public List<Reservation> getAllReservationsForToday() {
		// TODO Auto-generated method stub
		String SQL = "FROM Reservation r WHERE r.reservationDate =:date";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		LocalDate localDate = LocalDate.now();
		query.setParameter("date", localDate);
		List<Reservation> reservations = (List<Reservation>) query.getResultList();
		return reservations;
	}

	public List<Reservation> getAllReservationsForDate(LocalDate date) {
		// TODO Auto-generated method stub
		String SQL = "FROM Reservation r WHERE r.reservationDate =:date";
		Query<?> query = rawHandlers.extracted(sessionFactory, SQL);
		query.setParameter("date", date);
		List<Reservation> reservations = (List<Reservation>) query.getResultList();
		return reservations;
	}

	@Override
	public Reservation getReservationById(long id) {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().get(Reservation.class, id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Connection getReportConnection() throws SQLException {
		// Get Connection for reporting
		Connection connection = sessionFactory.getSessionFactoryOptions()
				.getServiceRegistry().getService(ConnectionProvider.class)
				.getConnection();
		return connection;
	}

}
