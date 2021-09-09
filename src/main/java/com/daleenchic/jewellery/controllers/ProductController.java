package com.daleenchic.jewellery.controllers;

import java.util.List;
import java.util.stream.Collectors;

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

import com.daleenchic.jewellery.dtos.ProductColorDTO;
import com.daleenchic.jewellery.dtos.ProductIdDTO;
import com.daleenchic.jewellery.models.Product;
import com.daleenchic.jewellery.services.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
		
	@GetMapping(value="/products")
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping (value="/products/{id}")
	public  @ResponseBody Product getProductById(@PathVariable Integer id) {
		return productService.getProductById(id);
	}
	
	@PostMapping(value="/products")
	public Product addProduct (@RequestBody Product product)
	{
		return productService.create(product);
	}
	
	@PutMapping (value="/products/{id}")
	public @ResponseBody Product updateProductById(@PathVariable Integer id, @RequestBody Product product)
	{
		return productService.update(id,product);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value="/products/{id}")
	public void deleteProduct (@PathVariable Integer id)
	{
		productService.delete(id);
	}

//	Get all products in this brand
	@GetMapping (value="/brand/{id}/products")
	public @ResponseBody List<Product> getProductsByBrandId (@PathVariable Integer id){
	return productService.getProductsByBrandId(id);
	}
	
//	add list of products for this brand
	@PostMapping(value="/brand/{id}/products")
	public @ResponseBody List<Product> addProductsToBrand (@PathVariable Integer id,
			@RequestBody List<Product> products)
	{
		return productService.addBrandForProduct(id, products);
	}
	
//	add list of products for this brand by Id
	@PutMapping(value="/brand/{id}/products")
	public @ResponseBody List<Product> updateProductsInBrand (@PathVariable Integer id,
			@RequestBody List<ProductIdDTO> productsId)
	{
		List<Integer> productsIdNumbers = productsId.stream()
													.map(p->p.getProductId())
													.collect(Collectors.toList());
		return productService.updateProductBrand(id, productsIdNumbers);
	}

	
//	Get all products in this collection
	@GetMapping (value="/collection/{id}/products")
	public @ResponseBody List<Product> getProductsByCollectionId (@PathVariable Integer id){
	return productService.getProductsByCollectionId(id);
	}
	
//	add color for product 
	@PutMapping(value="/product/{productId}")
	public @ResponseBody Product addColorToProduct (@PathVariable Integer productId,
			@RequestBody ProductColorDTO colorId)
	{
		return productService.addColorForProduct(colorId.getColorId(), productId);
	}
	
//	remove color from product 
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value="/product/{productId}/{colorId}")
	public void removeProductFromCollection (@PathVariable Integer productId,
			@PathVariable Integer colorId)
	{
		productService.deletFromProduct(colorId, productId);
	}
	
}

