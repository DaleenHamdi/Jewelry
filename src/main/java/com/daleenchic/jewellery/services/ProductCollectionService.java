package com.daleenchic.jewellery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.daleenchic.jewellery.models.Collection;
import com.daleenchic.jewellery.models.Product;
import com.daleenchic.jewellery.repositories.CollectionRepo;
import com.daleenchic.jewellery.repositories.ProductRepo;

@Service
public class ProductCollectionService {

	@Autowired
	private ProductService productService;
	@Autowired 
	private ProductRepo productRepo;
	@Autowired
	private CollectionRepo collectionRepo;
	
	public List<Product> getProductsByCollectionId(Integer id) {
		return productRepo.findAllByCollectionsId(id);
	}
	
	public Collection addProductForCollection(Integer productId, Integer collectionId) 
	{
		Optional <Collection> optionalCollcetion = collectionRepo.findById(collectionId);
		if (optionalCollcetion.isPresent())
		{
			Collection collection = optionalCollcetion.get();
			Product product = productService.getProductById(productId);
			collection.addProduct(product);
			return collectionRepo.save(collection);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"collection Not Found");
	
	}


	public void deletFromCollection(Integer productId, Integer collectionId) 
	{
		Optional <Collection> optionalCollcetion = collectionRepo.findById(collectionId);
		if (optionalCollcetion.isPresent())
		{
			Collection collection = optionalCollcetion.get();
			Product product = productService.getProductById(productId);
			collection.removeProduct(product);
			collectionRepo.save(collection);
		}
		else
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"collection Not Found");
	
	}

}
