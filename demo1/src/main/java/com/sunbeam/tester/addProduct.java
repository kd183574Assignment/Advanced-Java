package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;

import static com.sunbeam.utils.HibernateUtils.getFactory;


public class addProduct {
	
	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)
				){
			
			ProductDao dao= new ProductDaoImpl();
			System.out.println("ENTER PRODUCT DETAILS : Category, Price, Product, quantity ");
			
			//this.productName = productName;
		//	this.price = price;
			//this.quantity = quantity;
//			this.category = category;
			
			
			Product prod = new Product(Category.valueOf(sc.next().toUpperCase()), sc.nextDouble(), sc.next(), sc.nextInt());
			
			System.out.println(dao.addProduct(prod));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
