package com.spring.DAO.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.DAO.CustomerDAO;
import com.spring.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory factory;

	@Override
	public List<Customer> getCustomerList() {
		
		Session session = factory.getCurrentSession();
		
		Query<Customer> query = session.createQuery("from Customer order by firstName", Customer.class);
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public void addCustomer(Customer theCustomer) {
		
		Session session = factory.getCurrentSession();
		
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer addCustomer(int theID) {
		
		Session session = factory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, theID);
		
		return customer;
		
	}

	@Override
	public void deleteCustomer(int theID) {
		
		Session session = factory.getCurrentSession();
		
		Query query = session.createQuery("delete from Customer where ID=:customerid");
		
		query.setParameter("customerid", theID);
		
		query.executeUpdate();
	}



	@Override
	public List<Customer> searchCustomer(String searchName) {
		
		  Session session = factory.getCurrentSession();
	        
	        Query theQuery = null;
	        
	      
	        if (searchName != null && searchName.trim().length() > 0) {
	            theQuery =session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
	            theQuery.setParameter("theName", "%" + searchName.toLowerCase() + "%");
	        }
	        else {
	            theQuery = session.createQuery("from Customer", Customer.class);            
	        }
	        
	        List<Customer> customers = theQuery.getResultList();
	                
	        return customers;
	}



} 
