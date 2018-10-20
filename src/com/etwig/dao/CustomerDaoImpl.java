package com.etwig.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.etwig.dao.util.DbUtil;
import com.etwig.model.Customer;
import com.etwig.util.IdGenerator;

public class CustomerDaoImpl implements CustomerDao {

	private static final String createCustomerTableQuery = "CREATE TABLE ETWIG_CUSTOMER (ID VARCHAR, FIRST_NAME VARCHAR, LAST_NAME VARCHAR)";

	private static final String insertCustomerQuery = "INSERT INTO ETWIG_CUSTOMER VALUES(?, ?, ?)";

	private static final String selectAllCustomers = "SELECT * FROM ETWIG_CUSTOMER";

	private static final String selectCustomerQuery = "SELECT * FROM ETWIG_CUSTOMER WHERE ID = ?";

	private static final String deleteCustomer = "DELETE FROM ETWIG_CUSTOMER WHERE ID = ?";

	@Override
	public boolean createCustomerTable() {

		return false;
	}

	@Override
	public int saveCustomer(Customer customer) {
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(insertCustomerQuery)) {
			pstmt.setString(1, IdGenerator.generateCustomerId());
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
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(deleteCustomer)) {
			pstmt.setString(1, customerId);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Customer findCustomer(String customerId) {
		System.out.println("In " + this.getClass().getSimpleName() + " Customer ID: " + customerId);
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(selectCustomerQuery)) {
			pstmt.setString(1, customerId);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);

				Customer customer = new Customer();
				customer.setId(id);
				customer.setFirstName(firstName);
				customer.setLastName(lastName);
				return customer;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Customer> findCustomers() {
		List<Customer> customers = new ArrayList<>();
		try (Connection con = DbUtil.getCon(); Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(selectAllCustomers);
			while (rs.next()) {
				String id = rs.getString(1);
				String firstName = rs.getString(2);
				String lastName = rs.getString(3);

				Customer customer = new Customer();
				customer.setId(id);
				customer.setFirstName(firstName);
				customer.setLastName(lastName);

				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customers;
	}

}
