package com.daleenchic.jewellery.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderInfoId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column (name = "product_id", updatable = false, nullable = false)
	private	Integer productId;
	@Column (name = "client_id", updatable = false, nullable = false)
	private	Integer clientId;
	@Column (name = "order_id", updatable = false, nullable = false)
	private	Integer orderId;
	
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public OrderInfoId(Integer productId, Integer clientId, Integer orderId) {
		this.productId = productId;
		this.clientId = clientId;
		this.orderId = orderId;
	}
	public OrderInfoId() {
	}
} 
