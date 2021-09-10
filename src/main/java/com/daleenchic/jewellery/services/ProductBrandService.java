package com.daleenchic.jewellery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daleenchic.jewellery.models.Brand;
import com.daleenchic.jewellery.models.Product;
import com.daleenchic.jewellery.repositories.ProductRepo;

@Service
public class ProductBrandService {
	
	@Autowired 
	private ProductRepo productRepo;
	@Autowired 
	private ProductService productService;
	@Autowired 
	private BrandService brandService;

	public List<Product> getProductsByBrandId(Integer id) {
		return productRepo.findAllByBrandId(id);
	}
	
	public List<Product> addBrandForProduct (Integer id, List<Product> products)
	{
		Brand brand = brandService.getBrandById(id);
		products.stream().forEach(p->p.setBrand(brand));
		productRepo.saveAll(products);
		return products;
	}
	
	public List<Product> updateProductBrand (Integer id, List<Integer> productsId)
	{
		Brand brand = brandService.getBrandById(id);

		productsId.stream().forEach(pI->
		{
		Product product = productService.getProductById(pI);
		product.setBrand(brand);
		productRepo.save(product);
		});
		List<Product> products = productsId.stream()
											.map(p->productService.getProductById(p))
											.collect(Collectors.toList());
		return products;
		}

	public List<Product> updateOneProductBrand(Integer id, Integer productId) 
	{
		Brand brand = brandService.getBrandById(id);

		Product product = productService.getProductById(productId);
		product.setBrand(brand);
		productRepo.save(product);
		
		return brand.getProducts();	
	}
}
