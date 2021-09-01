package com.groupb.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name="products")
public class Product {
	
	// this is the product that we carry , not the object in our warehouse
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
	@SequenceGenerator(name="id_generator", sequenceName = "product_id_seq", allocationSize = 1)
	
	
	@Column(name="id")
	private int productId;
	
	@Column
	private String title;
	
	@Column
	private String category;
	
	@Column
	private String manufacturer;
	
	@Column(name="minimum_limit")
	private int minLimit;
	
	@OneToMany(mappedBy="product", cascade=CascadeType.ALL)
    private List<ProductStock> stock;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getMinLimit() {
		return minLimit;
	}
	public void setMinLimit(int minLimit) {
		this.minLimit = minLimit;
	}
	
	public void setStock(List<ProductStock> stock) {
		this.stock = stock;
	}
	
	
}
