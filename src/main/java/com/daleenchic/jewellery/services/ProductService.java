package com.daleenchic.jewellery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.daleenchic.jewellery.models.Product;
import com.daleenchic.jewellery.repositories.ProductRepo;

@Service
public class ProductService {

	@Autowired 
	private ProductRepo productRepo;
	
	
	public List<Product> getAllProducts()
	{
		return productRepo.findAll();
	}
	
	
	public Product getProductById (Integer id)
	{
		Optional <Product> productOpt= productRepo.findById(id);
		if(productOpt.isPresent())
			return productOpt.get();
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product Not Found");		
	}
	
	public Product create (Product product)
	{
			productRepo.save(product);
			return product;	

	}
	
	
	public Product update (Integer id, Product product)
	{
		Optional <Product> productOpt= productRepo.findById(id);
		if(productOpt.isPresent())
		{
			Product newProduct = productOpt.get();
			if (product.getName() != null)
				newProduct.setName(product.getName());
			if(product.getMaterial() != null)
				newProduct.setMaterial(product.getMaterial());
			if(product.getPrice() != 0)
				newProduct.setPrice(product.getPrice());
			if(product.getType() != null)
				newProduct.setType(product.getType());
			if(product.getColors() != null)
				newProduct.setColors(product.getColors());
			if(product.getBrand() != null)
				newProduct.setBrand(product.getBrand());
			if(product.getCollections() != null)
				newProduct.setCollections(product.getCollections());
			if(product.getOrderInfos() != null)
				newProduct.setOrderInfos(product.getOrderInfos());
			productRepo.save(newProduct);
			return newProduct;
		
		}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product Not Found");	
	}
	
	
	public void delete (Integer id)
	{
		Optional <Product> productOpt= productRepo.findById(id);
		if(productOpt.isPresent())
		{
			Product productToDelete = productOpt.get();
			productRepo.delete(productToDelete);
		}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product Not Found");	
	}
	
}
