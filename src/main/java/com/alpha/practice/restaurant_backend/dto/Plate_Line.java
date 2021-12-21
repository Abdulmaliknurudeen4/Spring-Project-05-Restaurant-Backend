package com.alpha.practice.restaurant_backend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "plate_line_table")
@DynamicUpdate
public class Plate_Line implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "plate_line_id")
	private long id;
	@OneToOne
	@JsonIgnore
	private Dish dish;
	@ManyToOne
	@JsonIgnore
	private UserTable userTable;
	@Column(name = "plate_line_count")
	private int count;
	@Column(name = "plate_line_price")
	private double buyingPrice;
	@Column(name = "isAvalaible")
	private boolean avalaible = true;
	private double total;
	
	public Plate_Line() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Dish getDish() {
		return dish;
	}

	public void setDish(Dish dish) {
		this.dish = dish;
	}

	public UserTable getUserTable() {
		return userTable;
	}

	public void setUserTable(UserTable userTable) {
		this.userTable = userTable;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public boolean isAvalaible() {
		return avalaible;
	}

	public void setAvalaible(boolean avalaible) {
		this.avalaible = avalaible;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
