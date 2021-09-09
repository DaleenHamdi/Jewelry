package com.daleenchic.jewellery.dtos;

import java.util.List;
import java.util.stream.Collectors;

public class TotalPriceDTO {

	private float totalPrice;
	private List<ClientOrderInfoDTO> orderInfo;


	public static TotalPriceDTO totalPriceFromDTO (List<ClientOrderInfoDTO> orderInfo)
	{
		List <Float> total = orderInfo.stream()
				.map(d -> d.getSubTotalPrice())
				.collect(Collectors.toList());
		float totalPrice =TotalPriceDTO.calculateTotal(total);
		TotalPriceDTO dto = new TotalPriceDTO(totalPrice,orderInfo) ;
		return dto;
	}
	
	public static float calculateTotal (List <Float> subTotalList)
	{
		float sum=0;
		for(int i=0;i<subTotalList.size();i++)
			sum+=subTotalList.get(i);
		return sum;
	}
	
	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	

	public List<ClientOrderInfoDTO> getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(List<ClientOrderInfoDTO> orderInfo) {
		this.orderInfo = orderInfo;
	}

	public TotalPriceDTO() {
	}

	public TotalPriceDTO(float totalPrice, List<ClientOrderInfoDTO> orderInfo) {
		this.totalPrice = totalPrice;
		this.orderInfo = orderInfo;
	}

	

	
}
