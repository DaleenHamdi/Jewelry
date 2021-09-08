package com.daleenchic.jewellery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.daleenchic.jewellery.models.Order;
import com.daleenchic.jewellery.services.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping(value="/orders")
	public List<Order> getClients() {
		return orderService.getAllOrders();
	}
	
	@GetMapping (value="/orders/{id}")
	public  @ResponseBody Order getOrderById(@PathVariable Integer id) {
		return orderService.getOrderById(id);
	}
	
	@PostMapping(value="/orders")
	public Order addOrder (@RequestBody Order order)
	{
		return orderService.create(order);
	}
	
	@PutMapping (value="/orders/{id}")
	public @ResponseBody Order updateOrderById(@PathVariable Integer id, @RequestBody Order order)
	{
		return orderService.update(id,order);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value="/orders/{id}")
	public void deleteOrder (@PathVariable Integer id)
	{
		orderService.delete(id);
	}
	
	
	
}
