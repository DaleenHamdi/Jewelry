package com.daleenchic.jewellery.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daleenchic.jewellery.models.Collection;

public interface CollectionRepo extends CrudRepository <Collection,Integer>{
	public List<Collection> findAll();
	public List<Collection> findByName(String name);

}
