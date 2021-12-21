package com.alpha.practice.restaurant_backend.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotBlank;

import com.alpha.practice.restaurant_backend.enumIdentifiers.Customer_Type;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user_table")
@DynamicUpdate
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	@JsonIgnore
	private long id;
	@Column(name = "first_name", nullable = false, length = 90)
	@NotBlank(message = "Enter First Name !!")
	private String firstName;
	@Column(name = "last_name", nullable = true, length = 90)
	private String lastName;
	@Column(name = "email", unique = true, nullable = false, length = 120)
	@NotBlank(message = "Enter Email, A valid One")
	private String email;
	@Column(name = "contact_info", nullable = false, length = 20)
	@NotBlank(message = "Enter Contact Information")
	private String contactInfo;
	@Column(name = "user_roles")
	private String roles;
	@Column(name = "user_granted_permissions")
	private String permissions;
	@Column(name = "user_password")
	@NotBlank(message = "Type a valid password")
	private String password;
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private UserTable userTable;
	@Temporal(TemporalType.DATE)
	@Column(name = "creation_date", nullable = false)
	@JsonIgnore
	private Date creationDate;
	@Transient
	@JsonIgnore
	private int attempts;
	@Enumerated(EnumType.STRING)
	@Column(name = "customer_type", nullable = false)
	private Customer_Type customerType;
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Address> address;
	@Column(name = "user_enabled")
	private boolean active;
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1L;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
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

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserTable getUserTable() {
		return userTable;
	}

	public void setUserTable(UserTable userTable) {
		this.userTable = userTable;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public Customer_Type getCustomerType() {
		return customerType;
	}

	public void setCustomerType(Customer_Type customerType) {
		this.customerType = customerType;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
