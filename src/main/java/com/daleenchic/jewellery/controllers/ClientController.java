package com.daleenchic.jewellery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.daleenchic.jewellery.models.Client;
import com.daleenchic.jewellery.services.ClientService;


@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping(value="/clients")
	public List<Client> getClients() {
		return clientService.getAllClients();
	}
	
	@GetMapping (value="/clients/{id}")
	public  @ResponseBody Client getClientById(@PathVariable Integer id) {
		return clientService.getClientById(id);
	}
	
	@PostMapping(value="/clients")
	public Client addClient (@RequestBody Client client)
	{
		return clientService.create(client);
	}
	
	@PutMapping (value="/clients/{id}")
	public @ResponseBody Client updateClientById(@PathVariable Integer id, @RequestBody Client client)
	{
		return clientService.update(id,client);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(value="/clients/{id}")
	public void deleteClient (@PathVariable Integer id)
	{
		clientService.delete(id);
	}
	
}
