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

import com.daleenchic.jewellery.models.Collection;
import com.daleenchic.jewellery.services.CollectionService;

@RestController
public class CollectionController {

	@Autowired
	private CollectionService collectionService;
	
	@GetMapping(value="/collections")
	public List<Collection> getCollections() {
		return collectionService.getAllCollections();
	}
	
	@GetMapping (value="/collections/{id}")
	public  @ResponseBody Collection getCollectionById(@PathVariable Integer id) {
		return collectionService.getCollectionById(id);
	}
	
	@PostMapping(value="/collections")
	public Collection addCollection (@RequestBody Collection collection)
	{
		return collectionService.create(collection);
	}
	
	@PutMapping (value="/collections/{id}")
	public @ResponseBody Collection updateCollectionById(@PathVariable Integer id, @RequestBody Collection collection)
	{
		return collectionService.update(id,collection);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value="/collections/{id}")
	public void deleteCollection (@PathVariable Integer id)
	{
		collectionService.delete(id);
	}
	

}
