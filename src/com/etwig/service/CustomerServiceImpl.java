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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCustomer(String customerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Customer findCustomer(String customerId) {
		System.out.println("In " + this.getClass().getSimpleName());
		return customerDao.findCustomer(customerId);
	}

	@Override
	public List<Customer> findCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

}
