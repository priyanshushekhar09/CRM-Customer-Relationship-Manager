package com.spring.service;

import java.util.List;

import com.spring.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void addCustomer(Customer theCustomer);

	public Customer getCustomers(int theID);

	public void deleteCustomer(int theID);

	public List<Customer> searchCustomers(String searchName);



}
