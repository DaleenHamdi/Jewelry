package com.daleenchic.jewellery.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.daleenchic.jewellery.dtos.ProductColorDTO;
import com.daleenchic.jewellery.models.Product;
import com.daleenchic.jewellery.services.ProductColorsService;

@RestController
public class ProductColorsController {

	@Autowired
	private ProductColorsService productColorsService;
	
//	add color for product 
	@PutMapping(value="/product/{productId}")
	public @ResponseBody Product addColorToProduct (@PathVariable Integer productId,
			@RequestBody ProductColorDTO colorId)
	{
		return productColorsService.addColorForProduct(colorId.getColorId(), productId);
	}
	
//	remove color from product 
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value="/product/{productId}/{colorId}")
	public void removeProductFromCollection (@PathVariable Integer productId,
			@PathVariable Integer colorId)
	{
		productColorsService.deletFromProduct(colorId, productId);
	}
}
