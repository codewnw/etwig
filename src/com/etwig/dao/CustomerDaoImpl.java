package com.etwig.dao;

import java.util.List;

import com.etwig.model.Customer;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public boolean createCustomerTable() {
		
		return false;
	}

	@Override
	public int saveCustomer(Customer customer) {
	
		return 0;
	}

	@Override
	public int updateCustomer(Customer customer) {
		
		return 0;
	}

	@Override
	public int deleteCustomer(String customerId) {
		
		return 0;
	}

	@Override
	public Customer findCustomer(String customerId) {
		System.out.println("In " + this.getClass().getSimpleName());
		System.out.println("Running JDBC Insert command......Customer");
		
		return null;
	}

	@Override
	public List<Customer> findCustomer() {
	
		return null;
	}

}
