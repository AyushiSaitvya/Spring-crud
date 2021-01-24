package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;



@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	
	public List<Customer> getCustomers()
	{
		Session CurrentSession=sessionFactory.getCurrentSession();
		
		Query<Customer> customerList= CurrentSession.createQuery("from Customer order by lastName",Customer.class);
		
		List<Customer> customers=customerList.getResultList();
		
		
		
		return customers;
	}

	  @Override
	  public void saveCustomer(Customer theCustomer)
	  {
		  
		    Session CurrentSession=sessionFactory.getCurrentSession();
			
			CurrentSession.saveOrUpdate(theCustomer);
			
	  }

	

	@Override
	public Customer getCustomer(int theId) {
		
		    Session CurrentSession=sessionFactory.getCurrentSession();
			
			Customer theCustomer=CurrentSession.get(Customer.class,theId);
			
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		  Session CurrentSession=sessionFactory.getCurrentSession();
		  Customer theCustomer=CurrentSession.get(Customer.class,theId);
		
		    CurrentSession.delete(theCustomer);
		
	}
	
	
	
}
