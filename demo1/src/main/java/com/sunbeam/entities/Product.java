package com.sunbeam.entities;

import javax.persistence.*;

@Entity 
@Table(name="product")

public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(length=20)
	private Category category;
	
	@Column (name="product_price")
	private double price;
	
	@Column(name="product_name", length=20)
	private String productName;
	
	@Column(name="quantity")
	private int quantity;
	
	
	
	public Product()
	{
		
	}

	

	public Product(Category category, double price, String productName, int quantity) {
		super();
		this.category = category;
		this.price = price;
		this.productName = productName;
		this.quantity = quantity;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + ", quantity=" + quantity
				+ ", category=" + category + "]";
	}
	
	
	
	
	


}
