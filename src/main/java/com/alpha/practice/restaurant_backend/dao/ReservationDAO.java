package com.alpha.practice.restaurant_backend.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.alpha.practice.restaurant_backend.dto.Reservation;
@Transactional
public interface ReservationDAO {

	/*
	 * CRUD implementation for Reservation Table
	 * */
	//add
	boolean AddReservation(Reservation reser);
	//update
	boolean UpdateEmailForReservation(Reservation reserv);
	//delete or cancel
	boolean cancelReservation(Reservation reserv);
	//get reservation by email
	Reservation getReservationByEmail(String email);
	Reservation getReservationById(long id);
	//get all reservation
	List<Reservation> getAllReservations();
	//List of Today Reservation
	List<Reservation> getAllReservationsForToday();
	//List of Reservation For the future
	List<Reservation> getAllReservationsForDate(LocalDate date);
	
	//Getting Connection for Report Generation
	Connection getReportConnection() throws SQLException;
}
