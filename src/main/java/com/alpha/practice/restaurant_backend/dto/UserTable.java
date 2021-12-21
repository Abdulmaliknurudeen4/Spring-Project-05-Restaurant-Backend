package com.alpha.practice.restaurant_backend.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "user_table_cart")
@DynamicUpdate
public class UserTable implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "table_id")
	private long id;
	@OneToOne
	@JsonIgnore
	private User user;
	@Column(name = "grand_Total")
	private double grandTotal;
	@Column(name = "dish_lines")
	private int dish_lines;
	@JsonIgnore
	@OneToMany(mappedBy = "userTable", fetch = FetchType.LAZY)
	private List<Plate_Line> plateLines;
	
	public UserTable() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public int getDish_lines() {
		return dish_lines;
	}

	public void setDish_lines(int dish_lines) {
		this.dish_lines = dish_lines;
	}

	public List<Plate_Line> getPlateLines() {
		return plateLines;
	}

	public void setPlateLines(List<Plate_Line> plateLines) {
		this.plateLines = plateLines;
	}

}
