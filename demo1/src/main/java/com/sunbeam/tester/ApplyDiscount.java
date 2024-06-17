package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;

import static com.sunbeam.utils.HibernateUtils.*;

import java.util.Scanner;
public class ApplyDiscount {

	public static void main(String[] args)
	{
		try(SessionFactory sf = getFactory(); 
			Scanner sc = new Scanner(System.in) ) {
			
			ProductDao dao = new ProductDaoImpl();
			
			System.out.println("Enter Category and Discount :");
			System.out.println(dao.applyDiscount(Category.valueOf(sc.next().toUpperCase()),sc.nextDouble())
			);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
