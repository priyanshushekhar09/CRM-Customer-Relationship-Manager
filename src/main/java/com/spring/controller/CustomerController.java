package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.DAO.CustomerDAO;
import com.spring.entity.Customer;
import com.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		List<Customer> theCustomers = customerService.getCustomers();
		
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAddCustomer")
	public String showFormForAddCustomer(Model theModel) {
		
		Customer customer = new Customer();
		
		theModel.addAttribute("customer", customer);
		
		return "customer-modified-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.addCustomer(theCustomer);
		
		return "redirect:/customer/list" ;
	}
	
	@GetMapping("showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theID, Model theModel) {
		
		Customer theCustomer = customerService.getCustomers(theID);
		
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-modified-form";
	
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int theID) {
		
		customerService.deleteCustomer(theID);
		
		return "redirect:/customer/list";
		
	}
	
	@GetMapping("/searchCustomer")
	public String searchCustomer(@RequestParam("theSearchName") String searchName, Model theModel) {
		
		
		List<Customer> customer = customerService.searchCustomers(searchName);
		
		theModel.addAttribute("customers", customer);
		
		
		return "list-customers";
	}
	

	
	

}
