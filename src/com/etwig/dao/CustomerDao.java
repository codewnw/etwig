package com.etwig.dao;

import java.util.List;

import com.etwig.model.Customer;


public interface CustomerDao {
	boolean createCustomerTable();

	String saveCustomer(Customer customer);

	int updateCustomer(Customer customer);

	int deleteCustomer(String customerId);

	Customer findCustomer(String customerId);

	Customer findCustomerByUserName(String userName);

	List<Customer> findCustomers();

}
