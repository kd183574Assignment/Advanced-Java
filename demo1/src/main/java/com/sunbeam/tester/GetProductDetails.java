package com.sunbeam.tester;

import java.util.Scanner;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;

public class GetProductDetails {
	
	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)) {
			
			ProductDao dao = new ProductDaoImpl();
			
			System.out.println("ENTER Min and Max range :");
			System.out.println(dao.getProductDetailsById(sc.nextLong()));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
