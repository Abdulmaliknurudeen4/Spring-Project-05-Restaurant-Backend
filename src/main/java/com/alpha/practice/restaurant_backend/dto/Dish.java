package com.alpha.practice.restaurant_backend.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.web.multipart.MultipartFile;

import com.alpha.practice.restaurant_backend.enumIdentifiers.Dish_Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "dish_table")
@DynamicUpdate
@JsonInclude(value = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Dish implements Serializable {

	/**
	 * @Json ignore added so that the parser can ignore unknown objects and not throw error
	 * @JsonIgnoreProperties does that
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dish_id")
	private long id;
	@Column(name = "dish_code", nullable = false, length = 255)
	private String code;
	@Enumerated(EnumType.STRING)
	@Column(name = "dish_type", nullable = false)
	private Dish_Type dishType;
	@Column(name = "dish_desc", nullable = false, length = 255)
	private String description;
	@Column(name = "dish_price", nullable = false)
	private double unitPrice;
	@Column(name = "dish_serv", nullable = false)
	private int servings;
	@Column(name = "dish_active", nullable = false)
	private boolean active = true;
	@ManyToOne
	@JsonIgnore
	private DishCategory category;
	@Column(name = "dish_purchases")
	private int purchases;
	@Column(name = "dish_views")
	private int views;
	@Column(name = "dish_name")
	private String name;

	@Transient
	private MultipartFile file;

	public Dish() {
		this.code = "DSH" + UUID.randomUUID().toString().substring(28).toUpperCase() + System.currentTimeMillis();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Dish_Type getDishType() {
		return dishType;
	}

	public void setDishType(Dish_Type dishType) {
		this.dishType = dishType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getServings() {
		return servings;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public DishCategory getCategory() {
		return category;
	}

	public void setCategory(DishCategory category) {
		this.category = category;
	}

	public int getPurchases() {
		return purchases;
	}

	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
