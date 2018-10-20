package com.etwig.presentation.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etwig.model.Customer;
import com.etwig.service.CustomerService;
import com.etwig.service.CustomerServiceImpl;

@WebServlet("/customers/*")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerService customerService;

	public CustomerServlet() {
		super();
		this.customerService = new CustomerServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String urlPattern = request.getRequestURI();
		if (urlPattern.contains("all")) {
			List<Customer> customers = customerService.findCustomers();
			request.setAttribute("customers", customers);
			request.getRequestDispatcher("../customers.jsp").forward(request, response);
		}
		else if(urlPattern.contains("delete")){
			String customerId = getCustomerIdFromUrlPatten(urlPattern);
			customerService.deleteCustomer(customerId);
			
			List<Customer> customers = customerService.findCustomers();
			request.setAttribute("customers", customers);
			request.getRequestDispatcher("../all").forward(request, response);
		}
		else if(urlPattern.contains("myhome") && urlPattern.contains("CUST")) {
			String customerId = getCustomerIdFromUrlPatten(urlPattern);
			Customer customer = customerService.findCustomer(customerId);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("../../profile.jsp").forward(request, response);
		}
		else if(urlPattern.contains("edit") && urlPattern.contains("CUST")) {
			String customerId = getCustomerIdFromUrlPatten(urlPattern);
			Customer customer = customerService.findCustomer(customerId);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("../../customer-registration.jsp").forward(request, response);
		}
		/*else if(urlPattern.contains("update")){
			String[] urlElements = urlPattern.split("/");
			String customerId = urlElements[urlElements.length-1];
			customerService.updateCustomer(customerId);
			
			List<Customer> customers = customerService.findCustomers();
			request.setAttribute("customers", customers);
			request.getRequestDispatcher("../all").forward(request, response);
			
		}
*/
	}

	private String getCustomerIdFromUrlPatten(String urlPattern) {
		String[] urlElements = urlPattern.split("/");
		String customerId = urlElements[urlElements.length-1];
		return customerId;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String urlPattern = request.getRequestURI();
		if (urlPattern.contains("save")) {
			if(request.getParameter("id") == null || request.getParameter("id").equals("")) {
				System.out.println("You are new user....");
				String firstName = request.getParameter("firstName");
				String lastName = request.getParameter("lastName");

				Customer customer = new Customer();
				customer.setFirstName(firstName);
				customer.setLastName(lastName);

				customerService.saveCustomer(customer);
			}
			else {
				System.out.println("You are returning user....");
			}
			response.sendRedirect("all");

		}
	}

}
