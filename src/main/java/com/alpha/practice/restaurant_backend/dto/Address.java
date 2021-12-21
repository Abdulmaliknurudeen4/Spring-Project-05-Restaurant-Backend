package com.alpha.practice.restaurant_backend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_address")
@DynamicUpdate
public class Address implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private long id;
	@ManyToOne
	@JsonIgnore
	private User user;
	@Column(name = "address_one", nullable = true)
	@NotBlank(message = "Please Enter Address One")
	private String addressOne;
	@Column(name = "address_two", nullable = true)
	@NotBlank(message = "Please Enter Address Two")
	private String addressTwo;
	@Column(name = "country", nullable = false)
	@NotBlank(message = "Please Choose Country")
	private String country;
	@Column(name = "state", nullable = false)
	@NotBlank(message = "Please enter state")
	private String state;
	@Column(name = "city", nullable = false)
	@NotBlank(message = "Please Enter City")
	private String city;
	@Column(name = "postal_code", nullable = true)
	@NotBlank(message = "Please Enter Postal Code")
	private String postalCode;
	@Column(name = "shipping_address")
	private boolean shipping;
	@Column(name = "billing_address")
	private boolean billing;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAddressOne() {
		return addressOne;
	}

	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}

	public String getAddressTwo() {
		return addressTwo;
	}

	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public boolean isShipping() {
		return shipping;
	}

	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}

	public boolean isBilling() {
		return billing;
	}

	public void setBilling(boolean billing) {
		this.billing = billing;
	}

}
