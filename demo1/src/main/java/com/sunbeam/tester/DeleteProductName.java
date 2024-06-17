package com.sunbeam.tester;

import java.util.Scanner;
import static com.sunbeam.utils.HibernateUtils.*;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.ProductDao;
import com.sunbeam.dao.ProductDaoImpl;

public class DeleteProductName {
	
	public static void main(String[] args)
	{
		try(SessionFactory sf = getFactory();
		Scanner sc = new Scanner(System.in))
				{
			ProductDao dao = new ProductDaoImpl();
			System.out.println("Enter Product Name :");
			System.out.println(dao.deleteProductName(sc.next()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
