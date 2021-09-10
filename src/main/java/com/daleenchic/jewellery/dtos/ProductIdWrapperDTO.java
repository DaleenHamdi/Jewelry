package com.daleenchic.jewellery.dtos;

import java.util.List;

public class ProductIdWrapperDTO {

	private List<Integer> productsId;
	
	public void addId(Integer id) {
        this.productsId.add(id);
    }

	public ProductIdWrapperDTO(List<Integer> productsId) {
		this.productsId = productsId;
	}

	public List<Integer> getProductsId() {
		return productsId;
	}

	public void setProductsId(List<Integer> productsId) {
		this.productsId = productsId;
	}

	public ProductIdWrapperDTO() {
	}
	
	
}
