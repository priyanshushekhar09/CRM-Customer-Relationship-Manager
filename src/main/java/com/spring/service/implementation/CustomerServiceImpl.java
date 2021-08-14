package com.spring.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.DAO.CustomerDAO;
import com.spring.entity.Customer;
import com.spring.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomerList();
	}

	@Override
	@Transactional
	public void addCustomer(Customer theCustomer) {
		
		customerDAO.addCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomers(int theID) {
		
		return customerDAO.addCustomer(theID);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theID) {
		
		customerDAO.deleteCustomer(theID);
		
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String searchName) {
	
		return customerDAO.searchCustomer(searchName);
	}





}
