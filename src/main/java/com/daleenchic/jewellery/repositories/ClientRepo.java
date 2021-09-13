package com.daleenchic.jewellery.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daleenchic.jewellery.models.Client;

public interface ClientRepo extends CrudRepository <Client,Integer>{
	public List<Client> findAll();
	public List<Client> findByFirstName(String name);
	public List<Client> findByLastName(String name);
	public List<Client> findByPhone(String phone);
	public List<Client> findByEmail(String email);
}
