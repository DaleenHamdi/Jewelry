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
		
//		if(isInEnum(product.getType().toString(),ProductType.class))
//		{
			productRepo.save(product);
			return product;	
//		}
//		throw new IllegalArgumentException(
//					"Unknown enum type " + product.getType() + ", Allowed values are " + Arrays.toString(ProductType.values())
//					);
	}
	
	
	public Product update (Integer id, Product product)
	{
		Optional <Product> productOpt= productRepo.findById(id);
		if(productOpt.isPresent())
		{
			Product newProduct = productOpt.get();
			newProduct.setName(product.getName());
			newProduct.setMaterial(product.getMaterial());
			newProduct.setPrice(product.getPrice());
			newProduct.setType(product.getType());
			newProduct.setColors(product.getColors());
			newProduct.setBrand(product.getBrand());
			newProduct.setCollections(product.getCollections());
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


	public List<Product> getProductsByBrandId(Integer id) {
		return productRepo.findAllByBrandId(id);
	}
	
	public List<Product> getProductsByCollectionId(Integer id) {
		return productRepo.findAllByCollectionsId(id);
	}
	
//	public boolean isInEnum(String value, Class <ProductType> type) 
//	{
//	    return Arrays.stream(type.getEnumConstants()).anyMatch(e -> e.name().equals(value));
//	}
}
