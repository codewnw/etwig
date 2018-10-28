package com.etwig.service;

import java.util.List;

import com.etwig.dao.CustomerDao;
import com.etwig.dao.CustomerDaoImpl;
import com.etwig.dao.ItemDaoImpl;
import com.etwig.model.Customer;

public class CustomerServiceImpl implements CustomerService{
	private CustomerDao customerDao;
	
	public CustomerServiceImpl() {
		super();
		this.customerDao = new CustomerDaoImpl();
	}

	@Override
	public boolean createCustomerTable() {
		return customerDao.createCustomerTable();
	}

	@Override
	public String saveCustomer(Customer customer) {
		return customerDao.saveCustomer(customer);
	}

	@Override
	public int updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

	@Override
	public int deleteCustomer(String customerId) {
		return customerDao.deleteCustomer(customerId);
	}

	@Override
	public Customer findCustomer(String customerId) {
//		System.out.println("In " + this.getClass().getSimpleName()+" Customer ID: "+customerId);
		return customerDao.findCustomer(customerId);
	}

	@Override
	public List<Customer> findCustomers() {
		return customerDao.findCustomers();
	}

}
