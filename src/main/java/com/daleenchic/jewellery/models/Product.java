package com.daleenchic.jewellery.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity (name = "product" )
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private float price;
	private String material;
	
	@Enumerated(EnumType.STRING)
	private ProductType type;
	
	
//	Relations
	@ManyToMany (mappedBy = "products")
    private List<Colors> colors;
	
	@ManyToMany (mappedBy = "products")
	@JsonIgnore
    private List<Collection> collections;
	
	@OneToMany(mappedBy = "products")
	@JsonIgnore
    private List<OrderInfo> orderInfos;
	
	@ManyToOne(fetch=FetchType.LAZY,optional = false)
	@JoinColumn(name="brand_id", insertable = false, updatable = false)
	private Brand brand;
	
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public ProductType getType() {
		return type;
	}
	public void setType(ProductType type) {
		this.type = type;
	}
	public List<Colors> getColors() {
		return colors;
	}
	public void setColors(List<Colors> colors) {
		this.colors = colors;
	}
	public List<Collection> getCollections() {
		return collections;
	}
	public void setCollections(List<Collection> collections) {
		this.collections = collections;
	}
	public List<OrderInfo> getOrderInfos() {
		return orderInfos;
	}
	public void setOrderInfos(List<OrderInfo> orderInfos) {
		this.orderInfos = orderInfos;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	//	Constructors
	public Product(Integer id, String name, float price, String material, ProductType type) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.material = material;
		this.type = type;
	}
	
	
	
	public Product(Integer id, String name, float price, String material, ProductType type, List<Colors> colors,
			List<Collection> collections, List<OrderInfo> orderInfos, Brand brand) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.material = material;
		this.type = type;
		this.colors = colors;
		this.collections = collections;
		this.orderInfos = orderInfos;
		this.brand = brand;
	}
	public Product() {
	}


}
