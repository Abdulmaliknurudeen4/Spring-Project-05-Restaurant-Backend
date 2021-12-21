package com.alpha.practice.restaurant_backend.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "menu_table")
@DynamicUpdate
public class Menu implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "menu_id")
	private long id;
	@OneToMany(orphanRemoval = false, fetch = FetchType.EAGER)
	private List<Dish> dishes = new ArrayList<Dish>();
	@Column(name = "menu_date", unique = true)
	private LocalDate menuDate;

	public Menu() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

	public LocalDate getMenuDate() {
		return menuDate;
	}

	public void setMenuDate(LocalDate menuDate) {
		this.menuDate = menuDate;
	}

}
