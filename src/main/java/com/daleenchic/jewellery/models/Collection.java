package com.daleenchic.jewellery.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name= "collection")
public class Collection {

	@Id
	@GeneratedValue (strategy= GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
//	Relations
	@ManyToMany()
	@JoinTable(name="product_collection",
				joinColumns= @JoinColumn(name="collection_id"),
				inverseJoinColumns = @JoinColumn(name = "product_id"))
	@JsonIgnore
	private List<Product> products;
	
//	Constructors
	public Collection() {
	}
	
	public Collection(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
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
	
	
	public void addProduct (Product product)
	{
		this.products.add(product);
	}
}
