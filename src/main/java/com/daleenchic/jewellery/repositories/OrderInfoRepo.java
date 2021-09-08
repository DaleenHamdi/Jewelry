package com.daleenchic.jewellery.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daleenchic.jewellery.models.OrderInfo;
import com.daleenchic.jewellery.models.OrderInfoId;

@Repository
public interface OrderInfoRepo  extends CrudRepository <OrderInfo,OrderInfoId>{
	public List<OrderInfo> findAll();
	public List<OrderInfo> findAllById(OrderInfoId id);
	public List<OrderInfo> findAllByClientId(Integer Id);
	public List<OrderInfo> findByProductsIdAndClientId(Integer productId,Integer clientId);
	public List<OrderInfo> findAllByOrdersId(Integer Id);
}
