package com.daleenchic.jewellery.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daleenchic.jewellery.models.Product;
import com.daleenchic.jewellery.models.ProductType;

public interface ProductRepo extends CrudRepository <Product,Integer> {
	public List<Product> findAll();
	public List<Product> findByName(String name);
	public List<Product> findByPrice(int price);
	public List<Product> findByMaterial(String material);
	public List<Product> findByType(ProductType type);
	public List<Product> findAllByBrandId(Integer id);
	public List<Product> findAllByCollectionsId(Integer id);

}
