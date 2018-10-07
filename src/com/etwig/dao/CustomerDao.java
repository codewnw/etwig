package com.etwig.dao;

import java.util.List;

import com.etwig.model.Customer;


public interface CustomerDao {
	boolean createCustomerTable();

	int saveCustomer(Customer customer);

	int updateCustomer(Customer customer);

	int deleteCustomer(String customerId);

	Customer findCustomer(String customerId);

	List<Customer> findCustomer();

}
