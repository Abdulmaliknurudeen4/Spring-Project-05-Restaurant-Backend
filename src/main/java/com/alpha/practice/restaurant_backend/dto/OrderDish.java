package com.alpha.practice.restaurant_backend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "order_dish")
@DynamicUpdate
public class OrderDish implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_item_id")
	private long id;
	@OneToOne
	private Dish dish;
	@ManyToOne
	@JoinColumn(name = "order_item_foreign_id", updatable=true)
	private OrderDetails orderDetails;
	//the join table owns the foreign key
	@Column(name = "buying_price")
	private double buyingPrice;
	@Column(name = "line_total")
	private double total;
	@Column(name = "dish_count")
	private int dishCount;
	
	public OrderDish() {
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

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	public double getBuyingPrice() {
		return buyingPrice;
	}

	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getDishCount() {
		return dishCount;
	}

	public void setDishCount(int dishCount) {
		this.dishCount = dishCount;
	}

}
