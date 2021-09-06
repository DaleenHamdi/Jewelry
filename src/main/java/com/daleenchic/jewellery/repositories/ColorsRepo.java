package com.daleenchic.jewellery.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daleenchic.jewellery.models.Colors;

public interface ColorsRepo extends CrudRepository <Colors,Integer>{
	public List<Colors> findAll();
	public List<Colors> findByColor(String color);
}
