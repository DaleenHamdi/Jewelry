package com.daleenchic.jewellery.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.daleenchic.jewellery.models.Brand;


public interface BrandRepo extends CrudRepository <Brand,Integer>{
	public List<Brand> findAll();
	public Optional<Brand> findById(Integer id);
}
