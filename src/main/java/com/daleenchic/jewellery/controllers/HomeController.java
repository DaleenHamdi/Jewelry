package com.daleenchic.jewellery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.daleenchic.jewellery.models.Brand;
import com.daleenchic.jewellery.models.Product;
import com.daleenchic.jewellery.services.BrandService;
import com.daleenchic.jewellery.services.ProductBrandService;
import com.daleenchic.jewellery.services.ProductService;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductBrandService productBrandService;	
	
	@GetMapping ("/home")
	public String home() {
		return "home";
	}
	
//	Products CRUD
//		GetAllProducts
		@GetMapping ("/all-products")
		public String showProducts(Model model) {
			List<Product> p= productService.getAllProducts();
			model.addAttribute("products",p);
			return "allProducts";
		}
		
//		Create Product
		@GetMapping ("/product")
		public String create (Model model) {
			Product p=new Product();
			model.addAttribute("product", p);
			return "newProduct";
		}
		
		@PostMapping ("/create-product")
		public String createProductResopnse(Model model,Product product)
		{
			productService.create(product);
			model.addAttribute("object","product");
			return "createSuccessful";
		}
		
//		Update product
		@GetMapping("/edit-product/{id}")
		public String editProduct(Model model, @PathVariable Integer id) {
			Product p = productService.getProductById(id);
			model.addAttribute("product", p);
			return "editProduct";
		}
		
		@PostMapping("/update-product/{id}")
		public String updateProduct(Model model,@PathVariable Integer id, Product product) {
			productService.update(id, product);
			model.addAttribute("object","product");
			return "editSuccessful";
		}
		
//		Delete Product
		@GetMapping("/delete-product/{id}")
		public String deleteProduct(Model model,@PathVariable Integer id) {
			productService.delete(id);
			model.addAttribute("object","product");
			return "deleteSuccessful";
		}
		
		
//		Brand CRUD
//		GetAllBrands
		@GetMapping ("/all-brands")
		public String showBrands(Model model) {
			List<Brand> b= brandService.getAllBrands();
			model.addAttribute("brands",b);
			return "allBrands";
		}
		
//		Create Brand
		@GetMapping ("/brand")
		public String createBrand (Model model) {
			Brand b=new Brand();
			model.addAttribute("brand", b);
			return "newBrand";
		}
		
		@PostMapping ("/create-brand")
		public String createBrandResopnse(Model model,Brand brand)
		{
			brandService.create(brand);
			model.addAttribute("object","brand");
			return "createSuccessful";
		}
		
//		Update Brand
		@GetMapping("/edit-brand/{id}")
		public String editBrand(Model model, @PathVariable Integer id) {
			Brand b = brandService.getBrandById(id);
			model.addAttribute("brand", b);
			return "editBrand";
		}
		
		@PostMapping("/update-brand/{id}")
		public String updateBrand(@PathVariable Integer id, Brand brand) {
			brandService.update(id, brand);
			return "editSuccessful";
		}
		
//		Delete Brand
		@GetMapping("/delete-brand/{id}")
		public String deleteBrand(Model model,@PathVariable Integer id) {
			brandService.delete(id);
			model.addAttribute("object","brand");
			return "deleteSuccessful";
		}

//		Get Products By Brand Id 
		@GetMapping ("/brand-products/{id}")
		public String showProductsByBrandId(Model model,@PathVariable Integer id) {
			List<Product> p= productBrandService.getProductsByBrandId(id);
			model.addAttribute("products",p);
			return "productsByBrand";
		}
} 
