package com.daleenchic.jewellery.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.daleenchic.jewellery.models.Colors;
import com.daleenchic.jewellery.repositories.ColorsRepo;

@Service
public class ColorsService {
	@Autowired
	private ColorsRepo colorsRepo;
	
	public List<Colors> getAllColors()
	{
		return colorsRepo.findAll();
	}
	
	
	public Colors getColorById (Integer id)
	{
		Optional <Colors> colorOpt= colorsRepo.findById(id);
		if(colorOpt.isPresent())
			return colorOpt.get();
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Color Not Found");		
	}
	
	public Colors create (Colors color)
	{
		colorsRepo.save(color);
		return color;
	}
	
	public Colors update (Integer id, Colors color)
	{
		Optional <Colors> colorOpt= colorsRepo.findById(id);
		if(colorOpt.isPresent())
		{
			Colors newColor = colorOpt.get();
			newColor.setColor (color.getColor());
			colorsRepo.save(newColor);
			return newColor;
		}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Color Not Found");	
	}
	
	public void delete (Integer id)
	{
		Optional <Colors> colorOpt= colorsRepo.findById(id);
		if(colorOpt.isPresent())
		{
			Colors colorToDelete = colorOpt.get();
			colorsRepo.delete(colorToDelete);
		}
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Color Not Found");	
	}
	
}
