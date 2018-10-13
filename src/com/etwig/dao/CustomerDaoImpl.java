package com.etwig.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.etwig.dao.util.DbUtil;
import com.etwig.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	private static final String createCustomerTableQuery = "CREATE TABLE ETWIG_CUSTOMER (ID VARCHAR, FIRST_NAME VARCHAR, LAST_NAME VARCHAR)";

	private static final String insertCustomerQuery = "INSERT INTO ETWIG_CUSTOMER VALUES(?, ?, ?)";

	@Override
	public boolean createCustomerTable() {

		return false;
	}

	@Override
	public int saveCustomer(Customer customer) {
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(insertCustomerQuery)) {
			pstmt.setString(1, "10001");
			pstmt.setString(2, customer.getFirstName());
			pstmt.setString(3, customer.getLastName());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
