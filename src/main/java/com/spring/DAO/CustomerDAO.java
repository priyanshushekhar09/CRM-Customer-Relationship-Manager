package com.spring.DAO;

import java.util.List;

import com.spring.entity.Customer;


public interface CustomerDAO {

	public List<Customer> getCustomerList();

	public void addCustomer(Customer theCustomer);

	public Customer addCustomer(int theID);

	public void deleteCustomer(int theID);

	public List<Customer> searchCustomer(String searchName);

}
