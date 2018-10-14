package com.etwig.service;

import java.util.List;

import com.etwig.model.Customer;


public interface CustomerService {
	boolean createCustomerTable();

	int saveCustomer(Customer customer);

	int updateCustomer(Customer customer);

	int deleteCustomer(String customerId);

	Customer findCustomer(String customerId);

	List<Customer> findCustomers();

}
