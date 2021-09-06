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

import com.daleenchic.jewellery.models.Colors;
import com.daleenchic.jewellery.services.ColorsService;

@RestController
public class ColorsController {

	@Autowired
	private ColorsService colorsService;
	
	@GetMapping(value="/colors")
	public List<Colors> getColors() {
		return colorsService.getAllColors();
	}
	
	@GetMapping (value="/colors/{id}")
	public  @ResponseBody Colors getColorById (@PathVariable Integer id) {
		return colorsService.getColorById(id);
	}
	
	@PostMapping(value="/colors")
	public Colors addColor (@RequestBody Colors color)
	{
		return colorsService.create(color);
	}
	
	@PutMapping (value="/colors/{id}")
	public @ResponseBody Colors updateColorById(@PathVariable Integer id, @RequestBody Colors color)
	{
		return colorsService.update(id,color);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value="/colors/{id}")
	public void deleteColor (@PathVariable Integer id)
	{
		colorsService.delete(id);
	}
}
