package com.daleenchic.jewellery.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;


@Entity(name="orderInfo")
public class OrderInfo {

	
	 @EmbeddedId
	 private OrderInfoId id;
	 
	 private int quantity;



	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "order_id",insertable=false,updatable=false)
	private Order orders;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "product_id",insertable=false,updatable=false)
	private Product products;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "client_id",insertable=false,updatable=false)
	private Client client;

	public OrderInfoId getId() {
		return id;
	}

	public void setId(OrderInfoId id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrders() {
		return orders;
	}

	public void setOrders(Order orders) {
		this.orders = orders;
	}

	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public OrderInfo(OrderInfoId id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public OrderInfo() {
	}

	
}
