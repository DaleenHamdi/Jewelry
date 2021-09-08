package com.daleenchic.jewellery.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity (name= "client")
public class Client {

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
//	Relations
	@OneToMany(mappedBy = "client",
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL)
	@JsonIgnore
    private List<OrderInfo> orderInfo;
	
//	Constructors
	public Client() {
	}
	
	public Client(Integer id, String firstName, String lastName, String email, String phone) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}
	
//	Getters and Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<OrderInfo> getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(List<OrderInfo> orderInfo) {
		this.orderInfo = orderInfo;
	}
	
	
}
