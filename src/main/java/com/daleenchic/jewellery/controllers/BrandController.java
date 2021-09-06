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

import com.daleenchic.jewellery.models.Brand;
import com.daleenchic.jewellery.services.BrandService;

@RestController
public class BrandController {

	@Autowired
	private BrandService brandService;
	
	
	@GetMapping (value="/brands")
	public List<Brand> getBrands() {
		return brandService.getAllBrands();
	}

	@GetMapping (value="/brand/{id}")
	public  @ResponseBody Brand getBrandById(@PathVariable Integer id) {
		return brandService.getBrandById(id);
	}
	
	@PostMapping(value="/brands")
	public Brand addBrand (@RequestBody Brand brand)
	{
		return brandService.create(brand);
	}
	
	@PutMapping (value="/brands/{id}")
	public @ResponseBody Brand updateBrandById(@PathVariable Integer id, @RequestBody Brand brand)
	{
		return brandService.update(id,brand);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value="/brands/{id}")
	public void deleteBrand (@PathVariable Integer id)
	{
		brandService.delete(id);
	}
}
