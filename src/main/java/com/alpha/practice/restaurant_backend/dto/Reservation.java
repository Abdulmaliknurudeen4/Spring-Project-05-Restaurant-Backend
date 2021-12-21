package com.alpha.practice.restaurant_backend.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

import com.alpha.practice.restaurant_backend.enumIdentifiers.Reservation_Time;
import com.alpha.practice.restaurant_backend.enumIdentifiers.Reservation_Type;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "reservation_table")
@DynamicUpdate
@JsonInclude(value = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reservation implements Serializable {

	/**
	 * reservation time
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reserv_id")
	private long id;
	@Column(name = "first_Name")
	private String firstName;
	@Column(name = "last_Name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "reserv_date")
	//@Temporal(TemporalType.DATE)
	private LocalDate reservationDate;
	@Enumerated(EnumType.STRING)
	@Column(name = "reserv_type")
	private Reservation_Type reservationType;
	@Column(name = "reserv_sitting")
	private int reservationSitting;
	@Column(name="reserv_filling_date")
	private Date reservationFillingDate;
	@Column(name="reserv_period")
	@Enumerated(EnumType.STRING)
	private Reservation_Time reservationTime;
	@Transient
	private static final int HEAD_COST = 200;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}

	public Reservation_Type getReservationType() {
		return reservationType;
	}

	public void setReservationType(Reservation_Type reservationType) {
		this.reservationType = reservationType;
	}

	public int getReservationSitting() {
		return reservationSitting;
	}

	public void setReservationSitting(int reservationSitting) {
		this.reservationSitting = reservationSitting;
	}

	public static int getHeadCost() {
		return HEAD_COST;
	}

	public Date getReservationFillingDate() {
		return reservationFillingDate;
	}

	public void setReservationFillingDate(Date reservationFillingDate) {
		this.reservationFillingDate = reservationFillingDate;
	}

	public Reservation_Time getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(Reservation_Time reservationTime) {
		this.reservationTime = reservationTime;
	}

}
