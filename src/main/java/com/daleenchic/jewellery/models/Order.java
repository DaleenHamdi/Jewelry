package com.daleenchic.jewellery.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "orders")
public class Order {
	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Integer id;
	private Date date;
	
//	Relations
	@OneToMany(mappedBy = "orders",
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL)
	@JsonIgnore
    private List<OrderInfo> orderInfo;
	
//	Getters and Setters
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<OrderInfo> getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(List<OrderInfo> orderInfo) {
		this.orderInfo = orderInfo;
	}
	
	//	Constructors
	
	

	public Order() {
	}

	public Order(Integer id, Date date) {
		this.id = id;
		this.date = date;
	}
}
