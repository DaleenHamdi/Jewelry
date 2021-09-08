package com.daleenchic.jewellery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.daleenchic.jewellery.dtos.ClientOrderProductDTO;
import com.daleenchic.jewellery.dtos.ProductIdDTO;
import com.daleenchic.jewellery.models.OrderInfo;
import com.daleenchic.jewellery.services.OrderInfoService;

@RestController
public class OrderInfoController {

	@Autowired
	private OrderInfoService orderInfoService;
	
	@GetMapping (value="/orderInfo")
	public @ResponseBody List<OrderInfo> getAllOrdersInfo (){
		return orderInfoService.getAllOrdersInfo();
	}
	
	@GetMapping (value="/client/{id}/orderInfo")
	public @ResponseBody List<OrderInfo> getOrdersInfoByClientId (@PathVariable Integer id){
		return orderInfoService.getOrdersInfoByClientId(id);
	}
	
	@GetMapping (value ="/order/{id}/orderInfo")
	public @ResponseBody List<OrderInfo> getOrdersInfoByOrderId (@PathVariable Integer id){
		return orderInfoService.getOrdersInfoByOrderId(id);
	}
	
	@PutMapping(value="/orders/{orderId}/orderInfo")
	public @ResponseBody OrderInfo addInfoForOrder (@PathVariable Integer orderId,
			@RequestBody ClientOrderProductDTO clientProductId)
	{
		return orderInfoService.addInfoForOrder(clientProductId, orderId);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value="/client/{clientId}/orderInfo")
	public void deleteOrderInfoByProductId (@PathVariable Integer clientId,
			@RequestBody ProductIdDTO productId)
	{
		orderInfoService.deleteRelationByProductId(productId.getProductId(), clientId);
	}
}
