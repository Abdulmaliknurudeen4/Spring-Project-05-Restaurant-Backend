package com.alpha.practice.restaurant_backend.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "order_details_table")
@DynamicUpdate
public class OrderDetails implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_detail_id")
	private long id;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	// the join table owns the foreign key
	@Column(name = "order_total")
	private double orderTotal;
	@ManyToOne
	private Address billing;
	@ManyToOne
	private Address shipping;
	@OneToMany(mappedBy = "orderDetails", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OrderDish> orderdishes = new ArrayList<OrderDish>();
	@Column(name = "order_count")
	private int orderCount;
	@Column(name = "order_date")
	private LocalDate orderDate;
	@Column(name="order_code")
	private String orderCode;
	
	
	
	public OrderDetails() {
		this.orderCode = "ORD" + UUID.randomUUID().toString().substring(30).toUpperCase() + System.currentTimeMillis();
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

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Address getBilling() {
		return billing;
	}

	public void setBilling(Address billing) {
		this.billing = billing;
	}

	public Address getShipping() {
		return shipping;
	}

	public void setShipping(Address shipping) {
		this.shipping = shipping;
	}

	public List<OrderDish> getOrderdishes() {
		return orderdishes;
	}

	public void setOrderdishes(List<OrderDish> orderdishes) {
		this.orderdishes = orderdishes;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

}
