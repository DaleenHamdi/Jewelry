package com.daleenchic.jewellery.dtos;

public class ClientOrderProductDTO {

	private Integer clientId;
	private Integer productId;
	private Integer quantity;
	
//	Getters And Setters
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
//	Constructors
	public ClientOrderProductDTO(Integer clientId, Integer productId, Integer quantity) {
		this.clientId = clientId;
		this.productId = productId;
		this.quantity = quantity;
	}
	public ClientOrderProductDTO() {
	}
	
	


}
