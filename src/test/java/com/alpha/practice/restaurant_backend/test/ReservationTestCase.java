package com.alpha.practice.restaurant_backend.test;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.alpha.practice.restaurant_backend.dao.ReservationDAO;
import com.alpha.practice.restaurant_backend.dto.Reservation;
import com.alpha.practice.restaurant_backend.enumIdentifiers.Reservation_Time;
import com.alpha.practice.restaurant_backend.enumIdentifiers.Reservation_Type;

public class ReservationTestCase {
	private static AnnotationConfigApplicationContext context;
	private static Reservation reservation;
	private static List<Reservation> reservations;
	private static ReservationDAO reservationDAO;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.alpha.practice.restaurant_backend");
		context.refresh();
		reservationDAO = (ReservationDAO) context.getBean("reservationRepository");
	}

//	@Test
//	public void insertReservation() {
//		reservation = new Reservation();
//		reservation.setEmail("abdulmaliknurudeen4@gmail.com");
//		reservation.setFirstName("Critics Company");
//		reservation.setLastName("NdA");
//		reservation.setReservationSitting(4);
//		reservation.setReservationType(Reservation_Type.OTHERS);
//		reservation.setReservationDate(LocalDate.now());
//		LocalDate filling = LocalDate.now();
//		reservation.setReservationFillingDate(new Date());
//		reservation.setReservationTime(Reservation_Time.MORNING);
//
//		assertEquals("Failed to insert reservation into the database", true,
//				reservationDAO.AddReservation(reservation));
//
//		assertEquals("Failed to retrieve object from the database succesfully", "abdulmaliknurudeen4@gmail.com",
//				reservationDAO.getReservationByEmail("abdulmaliknurudeen4@gmail.com").getEmail());
//
////		assertEquals("Failed to Delete From the Database", true, reservationDAO
////				.cancelReservation(reservationDAO.getReservationByEmail("abdulmaliknurudeen4@gmail.com")));
//
//	}
//
//	@Test
//	public void getReservationForDay() {
//		reservations = reservationDAO.getAllReservationsForDate(LocalDate.of(2001, 2, 7));
//		assertEquals("Failed to Retrieve Reservation for a specific Date", 1, reservations.size());
//	}
//	@Test
//	public void getReservationForToday() {
//		reservations = reservationDAO.getAllReservationsForToday();
//		assertEquals("Failed To Retrieve Reservations that are due for today", 1, reservations.size());
//	}

//	@Test
//	public void getReservationsAll() {
//		reservations = reservationDAO.getAllReservations();
//		assertEquals("Failed to Get all Reservation", 1, reservations.size());
//	}
}
