package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;
import com.sunbeam.entities.Category;

import static com.sunbeam.utils.HibernateUtils.*;

import java.util.Scanner;


public class GetResultList {
	
	public static void main(String[] args)
	{
		try (SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in);)
			
		{
			ProductDao dao = new ProductDaoImpl();
			
			System.out.println("Enter MIN AND MAX : ");
			dao.getResultList(sc.nextDouble(), sc.nextDouble(), Category.valueOf(sc.next().toUpperCase()))
			.forEach(System.out::println);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
