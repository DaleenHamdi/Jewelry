package com.daleenchic.jewellery.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.daleenchic.jewellery.dtos.ProductIdDTO;
import com.daleenchic.jewellery.models.Product;
import com.daleenchic.jewellery.services.ProductBrandService;

@RestController
public class ProductBrandController {
	@Autowired 
	private ProductBrandService productBrandService;
	
	
//	Get all products in this brand
	@GetMapping (value="/brand/{id}/products")
	public @ResponseBody List<Product> getProductsByBrandId (@PathVariable Integer id){
	return productBrandService.getProductsByBrandId(id);
	}
	
//	add list of products for this brand
	@PostMapping(value="/brand/{id}/products")
	public @ResponseBody List<Product> addProductsToBrand (@PathVariable Integer id,
			@RequestBody List<Product> products)
	{
		return productBrandService.addBrandForProduct(id, products);
	}
	
//	add list of products for this brand by Id
	@PutMapping(value="/brand/{id}/products")
	public @ResponseBody List<Product> updateProductsInBrand (@PathVariable Integer id,
			@RequestBody List<ProductIdDTO> productsId)
	{
		List<Integer> productsIdNumbers = productsId.stream()
													.map(p->p.getProductId())
													.collect(Collectors.toList());
		return productBrandService.updateProductBrand(id, productsIdNumbers);
	}
	
//	add product for this brand by Id
	@PutMapping(value="/brand/{id}/product")
	public @ResponseBody List<Product> updateOneProductInBrand (@PathVariable Integer id,
			@RequestBody ProductIdDTO productsId)
	{
		return productBrandService.updateOneProductBrand(id, productsId.getProductId());
	}
}
