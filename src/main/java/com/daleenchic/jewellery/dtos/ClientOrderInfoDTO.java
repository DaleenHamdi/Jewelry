package com.daleenchic.jewellery.dtos;


import com.daleenchic.jewellery.models.Order;
import com.daleenchic.jewellery.models.OrderInfo;
import com.daleenchic.jewellery.models.Product;

public class ClientOrderInfoDTO {
	private Integer orderId;
	private Integer productId;
	private Integer quantity;
	private Order order;
	private Product product;
	private float subTotalPrice;

	
	public static ClientOrderInfoDTO dTOFromOrderInfo (OrderInfo orderInfo)
	{
		float subTotalPrice = (orderInfo.getQuantity()*orderInfo.getProducts().getPrice());
		ClientOrderInfoDTO dto = new ClientOrderInfoDTO(orderInfo.getId().getOrderId(),
				orderInfo.getId().getProductId(),
				orderInfo.getQuantity(),
				orderInfo.getOrders(),
				orderInfo.getProducts(),
				subTotalPrice
				);
		return dto;
	}
		
	public ClientOrderInfoDTO(Integer orderId, Integer productId, Integer quantity, Order order, Product product,
			float subTotalPrice) {
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.order = order;
		this.product = product;
		this.subTotalPrice = subTotalPrice;
	}

	public ClientOrderInfoDTO() {
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public float getSubTotalPrice() {
		return subTotalPrice;
	}

	public void setSubTotalPrice(float subTotalPrice) {
		this.subTotalPrice = subTotalPrice;
	}
	
}
