package com.daleenchic.jewellery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.daleenchic.jewellery.models.Order;
import com.daleenchic.jewellery.repositories.OrderRepo;

@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;
	
	public List<Order> getAllOrders()
	{
		return orderRepo.findAll();
	}
	
	
	public Order getOrderById (Integer id)
	{
		Optional <Order> orderOpt= orderRepo.findById(id);
		if(orderOpt.isPresent())
			return orderOpt.get();
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Order Not Found");		
	}
	
	public Order create (Order order)
	{
		orderRepo.save(order);
		return order;
	}
	
	public Order update (Integer id, Order order)
	{
		Optional <Order> orderOpt= orderRepo.findById(id);
		if(orderOpt.isPresent())
		{
			Order newOrder = orderOpt.get();
			newOrder.setDate(order.getDate());
			orderRepo.save(newOrder);
			return newOrder;
		}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Order Not Found");	
	}
	
	public void delete (Integer id)
	{
		Optional <Order> orderOpt= orderRepo.findById(id);
		if(orderOpt.isPresent())
		{
			Order orderToDelete = orderOpt.get();
			orderRepo.delete(orderToDelete);
		}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Order Not Found");	
	}
	
	
}
