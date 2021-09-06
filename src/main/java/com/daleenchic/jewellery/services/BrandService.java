package com.daleenchic.jewellery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.daleenchic.jewellery.models.Brand;
import com.daleenchic.jewellery.repositories.BrandRepo;


@Service
public class BrandService {

	@Autowired
	private BrandRepo brandRepo;
	
		public List<Brand> getAllBrands()
		{
			return brandRepo.findAll();
		}
		
		
		public Brand getBrandById (Integer id)
		{
			Optional <Brand> brandOpt= brandRepo.findById(id);
			if(brandOpt.isPresent())
				return brandOpt.get();
			else
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Brand Not Found");		
		}
		
		public Brand create (Brand brand)
		{
			brandRepo.save(brand);
			return brand;
		}
		
		public Brand update (Integer id, Brand brand)
		{
			Optional <Brand> brandOpt= brandRepo.findById(id);
			if(brandOpt.isPresent())
			{
				Brand newBrand = brandOpt.get();
				newBrand.setName(brand.getName());
				brandRepo.save(newBrand);
				return newBrand;
			}
			else
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Brand Not Found");	
		}
		
		public void delete (Integer id)
		{
			Optional <Brand> brandOpt= brandRepo.findById(id);
			if(brandOpt.isPresent())
			{
				Brand brandToDelete = brandOpt.get();
				brandRepo.delete(brandToDelete);
			}
			else
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Brand Not Found");	
		}
}
