package com.daleenchic.jewellery.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daleenchic.jewellery.models.Order;

public interface OrderRepo extends CrudRepository <Order,Integer>{
	public List<Order> findAll();
}
