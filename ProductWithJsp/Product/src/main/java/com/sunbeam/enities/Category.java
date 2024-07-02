package com.sunbeam.enities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends BaseEntitity{
	
	@Column(length =30 , unique = true)
	private String name;
	
	private String description;
	
	
	//Category ---> products  (one to many)
	
	@OneToMany(mappedBy = "productCategory",cascade = CascadeType.ALL)
	private List<Product> productList = new ArrayList<>();

	
	public Category()
	{
		
	}
	
	

	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Product> getProductList() {
		return productList;
	}


	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}


	@Override
	public String toString() {
		return "Category [name=" + name + ", description=" + description + ", productList=" + productList + "]";
	}
	
	
	public void addProduct(Product product)
	{
		this.productList.add(product);
		
		product.setCategory(this);
	}
	
}
