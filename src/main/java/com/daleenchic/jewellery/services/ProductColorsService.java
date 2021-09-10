package com.daleenchic.jewellery.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.daleenchic.jewellery.models.Colors;
import com.daleenchic.jewellery.models.Product;
import com.daleenchic.jewellery.repositories.ProductRepo;

@Service
public class ProductColorsService {

	@Autowired 
	private ColorsService colorsService;
	@Autowired 
	private ProductRepo productRepo;
	
	
	public Product addColorForProduct (Integer colorId, Integer productId)
	{
		Optional <Product> optionalProduct = productRepo.findById(productId);
		if (optionalProduct.isPresent())
		{
			Product product = optionalProduct.get();
			Colors color = colorsService.getColorById(colorId);
			product.addColor(color);
			return productRepo.save(product);
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Product Not Found");
	}
	
	public void deletFromProduct(Integer colorId, Integer productId) 
	{
			Optional <Product> optionalProduct = productRepo.findById(productId);
			if (optionalProduct.isPresent())
			{
				Product product = optionalProduct.get();
				Colors color = colorsService.getColorById(colorId);
				product.removeColor(color);
				productRepo.save(product);
			}
			else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"product Not Found");
		
		}
}
