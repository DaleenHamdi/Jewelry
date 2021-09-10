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

}

