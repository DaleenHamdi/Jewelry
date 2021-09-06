package com.daleenchic.jewellery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.daleenchic.jewellery.models.Product;
import com.daleenchic.jewellery.services.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;
	
	@GetMapping ("/home")
	public String home(Model model) {
		List<Product> p= productService.getAllProducts();
		model.addAttribute("products",p);
		return "home";
	}
	
	@GetMapping ("/product")
	public String create (Model model) {
		Product p=new Product();
		model.addAttribute("product", p);
		return "product";
	}
	
	@PostMapping ("/create-product")
	public String createProductResopnse(Product product)
	{
		productService.create(product);
		return "productSuccessful";
	}
	
	@GetMapping("/delete-product/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		productService.delete(id);
		return "deleteSuccessful";
	}
	
	@GetMapping("/edit-product/{id}")
	public String editProduct(Model model, @PathVariable Integer id) {
		Product p = productService.getProductById(id);
		model.addAttribute("product", p);
		return "editProduct";
	}
	
	@PostMapping("/update-product/{id}")
	public String updateProduct(@PathVariable Integer id, Product product) {
		productService.update(id, product);
		return "editSuccessful";
	}
} 
