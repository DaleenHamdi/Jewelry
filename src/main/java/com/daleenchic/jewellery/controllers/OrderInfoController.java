package com.daleenchic.jewellery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	
}
