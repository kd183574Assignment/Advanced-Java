package com.sunbeam.dao;



import java.util.List;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

public interface ProductDao {
	String addProduct(Product product);
	
	Product getProductDetailsById(Long productId);
	
	List<Product> getResultList(double begin,double end, Category category);
	
	String applyDiscount(Category category, double discount);
	
	String deleteProductName(String name);
	
}