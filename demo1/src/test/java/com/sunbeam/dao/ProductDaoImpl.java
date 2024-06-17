
package com.sunbeam.dao;

import com.sunbeam.entities.Product;
import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		
		String message="Product adding in failed..!!";
		
		Session session=getFactory().getCurrentSession();

		Transaction tx=session.beginTransaction();

		try {
			
			Serializable productId = session.save(product);
			
			tx.commit();
			
			message = "Product adding is successfully..!!";
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			if(tx != null)
				tx.rollback();
			
			throw e;
		}
		
		
		return message;
	}

	@Override
	public Product getProductDetailsById(Long productId) {
		Product product=null;
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		try {
			
			product =session.get(Product.class, productId);
			
			
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
			// TODO: handle exception
		}
		return product;
		// TODO Auto-generated method stub
		
	}
	
}