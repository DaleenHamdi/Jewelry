package com.daleenchic.jewellery.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.daleenchic.jewellery.models.Brand;
import com.daleenchic.jewellery.models.Colors;
import com.daleenchic.jewellery.models.Product;
import com.daleenchic.jewellery.repositories.ProductRepo;

@Service
public class ProductService {

	@Autowired 
	private ProductRepo productRepo;
	@Autowired 
	private BrandService brandService;
	@Autowired 
	private ColorsService colorsService;
	
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


	public List<Product> getProductsByBrandId(Integer id) {
		return productRepo.findAllByBrandId(id);
	}
	
	public List<Product> getProductsByCollectionId(Integer id) {
		return productRepo.findAllByCollectionsId(id);
	}
	
	public List<Product> addBrandForProduct (Integer id, List<Product> products)
	{
		Brand brand = brandService.getBrandById(id);
		products.stream().forEach(p->p.setBrand(brand));
		productRepo.saveAll(products);
		return products;
	}
	
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
	
	public List<Product> updateProductBrand (Integer id, List<Integer> productsId)
	{
		Brand brand = brandService.getBrandById(id);

		productsId.stream().forEach(pI->
		{
		Product product = getProductById(pI);
		product.setBrand(brand);
		productRepo.save(product);
		});
		List<Product> products = productsId.stream()
											.map(p->getProductById(p))
											.collect(Collectors.toList());
		return products;
		}
}
