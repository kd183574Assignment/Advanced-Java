
package com.sunbeam.dao;

import com.sunbeam.entities.Category;
import com.sunbeam.entities.Product;
import org.hibernate.*;
import static com.sunbeam.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

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

	@Override
	public List<Product> getResultList(double begin, double end, Category category) {
		String jpql = "select Product p from Product p where p.price between :start and :end and p.category = :ct";
		List<Product> product = null;
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			product = session.createQuery(jpql, Product.class)
					.setParameter("start", begin)
					.setParameter("end", end )
					.setParameter("ct", category)
					.getResultList();
			tx.commit();
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		
		
		
		return product;
	}

	@Override
	public String applyDiscount(Category category, double discount) {
		// TODO Auto-generated method stub
		String message = "APPLYING DISCOUNT FAILED...!!";
		String jpql = "update Product p set p.price = p.price-:disc where p.category = :ct ";
				
		Session session = getFactory().getCurrentSession();
		// 2. begin a Tx
		Transaction tx = session.beginTransaction();
		
		try {
			int rows = session.createQuery(jpql)
					.setParameter("ct", category)
					.setParameter("disc", discount)
					.executeUpdate();
			tx.commit();
			message = "Applied Discount to Products - " + rows;
		} catch (RuntimeException e) {
			// TODO: handle exception
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return message;
	}

	@Override
	public String deleteProductName(String name) {
		// TODO Auto-generated method stub
		
		String message = "Deletion is failed..!!";
		Product p = null;
		String jpql = "select p from Product p where p.productName =:pn";
		
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			p = session.createQuery(jpql, Product.class)
					.setParameter("pn",name)
					.getSingleResult();
			if(p != null) {
			session.delete(p);
			
			}
			tx.commit();
			message = "delete successfully..!!";
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			if(tx != null) {
				tx.rollback();
			}
			throw e;
			
		}
		return message;
	}
	
}