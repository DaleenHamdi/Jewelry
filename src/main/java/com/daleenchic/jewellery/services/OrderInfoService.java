package com.daleenchic.jewellery.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daleenchic.jewellery.models.OrderInfo;
import com.daleenchic.jewellery.repositories.OrderInfoRepo;

@Service
public class OrderInfoService {

	@Autowired
	private OrderInfoRepo orderInfoRepo;
	
	public List<OrderInfo> getAllOrdersInfo()
	{
		return orderInfoRepo.findAll();
	}
	
	public List<OrderInfo> getOrdersInfoByClientId(Integer id) {
		return orderInfoRepo.findAllByClientId(id);
	}
}
