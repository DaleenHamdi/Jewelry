package com.daleenchic.jewellery.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.daleenchic.jewellery.dtos.ClientOrderInfoDTO;
import com.daleenchic.jewellery.dtos.TotalPriceDTO;
import com.daleenchic.jewellery.models.OrderInfo;
import com.daleenchic.jewellery.services.OrderInfoService;

@RestController
public class ClientOrderInfoController {

	@Autowired
	private OrderInfoService orderInfoService;
	
	@GetMapping (value="/clientInterface/{id}/orderInfo")
	public @ResponseBody TotalPriceDTO getOrdersInfoByClientId (@PathVariable Integer id){
		 
				List <OrderInfo> orders = orderInfoService.getOrdersInfoByClientId(id);
				List <ClientOrderInfoDTO> dTOList = orders.stream()
						.map(o->ClientOrderInfoDTO.dTOFromOrderInfo(o))
						.collect(Collectors.toList());
				return TotalPriceDTO.totalPriceFromDTO(dTOList);
	}
}
