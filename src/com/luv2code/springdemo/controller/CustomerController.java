package com.luv2code.springdemo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;



@Controller
@RequestMapping("/customer")
public class CustomerController 
{
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model theModel)
	{
		
		List<Customer> theCustomers=customerService.getCustomers();
		
		theModel.addAttribute("customers",theCustomers);
		
		return "customer-list";
	}
	
	@GetMapping("/addCustomer")
	public String addCustomer(Model theModel)
	{
		Customer theCustomer=new Customer();
		theModel.addAttribute("customer",theCustomer);
		
		
		
		return "customer-add";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute ("customer") Customer theCustomer)
	{
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Customer customer = customerService.getCustomer(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", customer);
		
		System.out.println(theId);
		// send over to our form		
		return "customer-add";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId,
									Model theModel) {
		
		// get the customer from our service
		customerService.deleteCustomer(theId);	
		
		return "redirect:/customer/list";
	}
	
	
}
