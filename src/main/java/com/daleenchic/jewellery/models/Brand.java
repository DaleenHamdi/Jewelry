package com.daleenchic.jewellery.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity (name ="brand")
public class Brand {

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
//	Relations
	
	@OneToMany(mappedBy ="brand",
			fetch=FetchType.LAZY,
			cascade=CascadeType.REMOVE)
	@JsonIgnore
	private List<Product> products;
	
//	Getters and Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	//	Constructors
	public Brand(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Brand() {
	}
	
	
}
