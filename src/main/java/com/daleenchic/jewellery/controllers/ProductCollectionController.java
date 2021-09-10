package com.daleenchic.jewellery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.daleenchic.jewellery.dtos.ProductIdDTO;
import com.daleenchic.jewellery.models.Collection;
import com.daleenchic.jewellery.models.Product;
import com.daleenchic.jewellery.services.ProductCollectionService;

@RestController
public class ProductCollectionController {

	@Autowired
	private ProductCollectionService productCollectionService;
	
	
//	Get all products in this collection
	@GetMapping (value="/collection/{id}/products")
	public @ResponseBody List<Product> getProductsByCollectionId (@PathVariable Integer id){
	return productCollectionService.getProductsByCollectionId(id);
	}
	
	
//	add product to collection 
	@PutMapping(value="/collection/{collectionId}")
	public @ResponseBody Collection addProductToCollection (@PathVariable Integer collectionId,
			@RequestBody ProductIdDTO productId)
	{
		return productCollectionService.addProductForCollection(productId.getProductId(), collectionId);
	}
	
	
//	remove product from collection 
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value="/collection/{collectionId}/{productId}")
	public void removeProductFromCollection (@PathVariable Integer collectionId,
			@PathVariable Integer productId)
	{
		productCollectionService.deletFromCollection(productId, collectionId);
	}
}
