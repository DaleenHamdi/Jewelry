package com.daleenchic.jewellery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.daleenchic.jewellery.models.Client;
import com.daleenchic.jewellery.repositories.ClientRepo;


@Service
public class ClientService {

	@Autowired
	private ClientRepo clientRepo;
	
	public List<Client> getAllClients()
	{
		return clientRepo.findAll();
	}
	
	
	public Client getClientById (Integer id)
	{
		Optional <Client> clientOpt= clientRepo.findById(id);
		if(clientOpt.isPresent())
			return clientOpt.get();
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Client Not Found");		
	}
	
	public Client create (Client client)
	{
		clientRepo.save(client);
		return client;
	}
	
	public Client update (Integer id, Client client)
	{
		Optional <Client> clientOpt= clientRepo.findById(id);
		if(clientOpt.isPresent())
		{
			Client newClient = clientOpt.get();
			if (client.getFirstName() != null)
				newClient.setFirstName(client.getFirstName());
			if (client.getLastName() != null)
				newClient.setLastName(client.getLastName());
			if (client.getEmail() != null )
				newClient.setEmail(client.getEmail());
			if (client.getPhone() != null)
				newClient.setPhone(client.getPhone());
			clientRepo.save(newClient);
			return newClient;
		}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Client Not Found");	
	}
	
	public void delete (Integer id)
	{
		Optional <Client> clientOpt= clientRepo.findById(id);
		if(clientOpt.isPresent())
		{
			Client clientToDelete = clientOpt.get();
			clientRepo.delete(clientToDelete);
		}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Client Not Found");	
	}

	
}
