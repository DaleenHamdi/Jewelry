package com.daleenchic.jewellery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.daleenchic.jewellery.models.Collection;
import com.daleenchic.jewellery.repositories.CollectionRepo;

@Service
public class CollectionService {

	@Autowired
	private CollectionRepo collectionRepo;
	
	public List<Collection> getAllCollections()
	{
		return collectionRepo.findAll();
	}
	
	
	public Collection getCollectionById (Integer id)
	{
		Optional <Collection> collectionOpt= collectionRepo.findById(id);
		if(collectionOpt.isPresent())
			return collectionOpt.get();
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Collection Not Found");		
	}
	
	public Collection create (Collection collection)
	{
		collectionRepo.save(collection);
		return collection;
	}
	
	public Collection update (Integer id, Collection collection)
	{
		Optional <Collection> collectionOpt= collectionRepo.findById(id);
		if(collectionOpt.isPresent())
		{
			Collection newCollection = collectionOpt.get();
			newCollection.setName(collection.getName());
			collectionRepo.save(newCollection);

			return newCollection;
		}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Collection Not Found");	
	}
	
	public void delete (Integer id)
	{
		Optional <Collection> collectionOpt= collectionRepo.findById(id);
		if(collectionOpt.isPresent())
		{
			Collection collectionToDelete = collectionOpt.get();
			collectionRepo.delete(collectionToDelete);
		}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Collection Not Found");	
	}

}
