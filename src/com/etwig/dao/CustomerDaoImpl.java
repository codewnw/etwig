package com.etwig.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.etwig.dao.util.DbMetaData;
import com.etwig.dao.util.DbUtil;
import com.etwig.model.Customer;
import com.etwig.util.IdGenerator;

public class CustomerDaoImpl implements CustomerDao {

	private LoginDao loginDao;

	private static final String createCustomerTableQuery = "CREATE TABLE ETWIG_CUSTOMER (ID VARCHAR, FIRST_NAME VARCHAR, LAST_NAME VARCHAR, MOBILE VARCHAR, EMAIL VARCHAR, STREET1 VARCHAR, STREET2 VARCHAR, CITY VARCHAR, STATE VARCHAR, POST_CODE VARCHAR, COUNTRY VARCHAR, TNC_ACCEPTED BOOLEAN)";

	private static final String insertCustomerQuery = "INSERT INTO ETWIG_CUSTOMER VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String selectAllCustomers = "SELECT * FROM ETWIG_CUSTOMER";

	private static final String selectCustomerQuery = "SELECT * FROM ETWIG_CUSTOMER WHERE ID = ?";

	private static final String deleteCustomer = "DELETE FROM ETWIG_CUSTOMER WHERE ID = ?";

	private static final String updateCustomerQuery = "UPDATE ETWIG_CUSTOMER SET FIRST_NAME = ?, LAST_NAME = ? WHERE ID = ?";

	public CustomerDaoImpl() {
		loginDao = new LoginDaoImpl();
	}

	@Override
	public boolean createCustomerTable() {
		if (!DbMetaData.isTableExists("ETWIG_CUSTOMER")) {
			try (Connection con = DbUtil.getCon(); Statement stmt = con.createStatement()) {
				System.out.println("Creating table ETWIG_CUSTOMER");
				return !stmt.execute(createCustomerTableQuery);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Table ETWIG_CUSTOMER already exists.");
		}
		return false;
	}

	@Override
	public String saveCustomer(Customer customer) {
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(insertCustomerQuery)) {
			String customerId = IdGenerator.generateCustomerId();
			pstmt.setString(1, customerId);
			pstmt.setString(2, customer.getFirstName());
			pstmt.setString(3, customer.getLastName());
			pstmt.setString(4, customer.getMobile());
			pstmt.setString(5, customer.getEmail());
			pstmt.setString(6, customer.getStreet1());
			pstmt.setString(7, customer.getStreet2());
			pstmt.setString(8, customer.getCity());
			pstmt.setString(9, customer.getState());
			pstmt.setString(10, customer.getCountry());
			pstmt.setString(11, customer.getPostCode());
			pstmt.setBoolean(12, customer.isTncAccepted());
			pstmt.executeUpdate();
			loginDao.saveLogin(customer.getEmail(), customer.getPassword());
			return customerId;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public int updateCustomer(Customer customer) {
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(updateCustomerQuery)) {
			pstmt.setString(1, customer.getFirstName());
			pstmt.setString(2, customer.getLastName());
			pstmt.setString(3, customer.getId());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
				Customer customer = new Customer();

				customer.setId(rs.getString(1));
				customer.setFirstName(rs.getString(2));
				customer.setLastName(rs.getString(3));
				customer.setMobile(rs.getString(4));
				customer.setEmail(rs.getString(5));
				customer.setStreet1(rs.getString(6));
				customer.setStreet2(rs.getString(7));
				customer.setCity(rs.getString(8));
				customer.setState(rs.getString(9));
				customer.setCountry(rs.getString(10));
				customer.setPostCode(rs.getString(11));
				customer.setTncAccepted(rs.getBoolean(12));

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
