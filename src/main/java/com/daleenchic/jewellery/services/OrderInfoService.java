package com.daleenchic.jewellery.services;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.daleenchic.jewellery.dtos.ClientOrderProductDTO;
import com.daleenchic.jewellery.models.OrderInfo;
import com.daleenchic.jewellery.models.OrderInfoId;
import com.daleenchic.jewellery.repositories.OrderInfoRepo;

@Service
public class OrderInfoService {

	@Autowired
	private OrderInfoRepo orderInfoRepo;
	@Autowired
	private OrderService orderService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private ProductService productService;
	
	
	public List<OrderInfo> getAllOrdersInfo()
	{
		return orderInfoRepo.findAll();
	}
	
	public List<OrderInfo> getOrdersInfoByClientId(Integer id) {
		return orderInfoRepo.findAllByClientId(id);
	}
	
	public List<OrderInfo> getOrdersInfoByOrderId(Integer id,String auth) {
		String encodedUsernamePassword = auth.substring("Basic ".length()).trim();
		String usernamePassword =new String(Base64.decodeBase64(encodedUsernamePassword.getBytes()));

		int seperatorIndex = usernamePassword.indexOf(':');
		String userName = usernamePassword.substring(0, seperatorIndex);		
		String provider ="Provider";
		if (userName.equals(provider))
			return orderInfoRepo.findAllByOrdersId(id);
		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"Unauthorized");

	}

	public OrderInfo addInfoForOrder(ClientOrderProductDTO clientProductId, Integer orderId)
	{		
		OrderInfoId orderInfoSetId = new OrderInfoId();
		orderInfoSetId.setOrderId(orderId);
		orderInfoSetId.setProductId(clientProductId.getProductId());;
		orderInfoSetId.setClientId(clientProductId.getClientId());

		Optional <OrderInfo> orderInfo = orderInfoRepo.findById(orderInfoSetId);
		if(orderInfo.isPresent())
		{
			orderInfo.get().setQuantity(clientProductId.getQuantity());
			return orderInfoRepo.save(orderInfo.get());
		}
		else 
		{
			OrderInfo newOrderInfo = new OrderInfo(orderInfoSetId,clientProductId.getQuantity());
			newOrderInfo.setOrders(orderService.getOrderById(orderId));
			newOrderInfo.setProducts(productService.getProductById(clientProductId.getProductId()));
			newOrderInfo.setClient(clientService.getClientById(clientProductId.getClientId()));
			return orderInfoRepo.save(newOrderInfo);
		}
	}

	public void deleteRelationByProductId(Integer productId, Integer clientId) {
		List<OrderInfo> orderInfo = orderInfoRepo.findByProductsIdAndClientId(productId,clientId);
		if(orderInfo.isEmpty())
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Order Operation Not Found");
		}
		else
			orderInfo.stream().forEach(o->orderInfoRepo.delete(o));
	}

	
}
