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
			String[] urlElements = urlPattern.split("/");
			String customerId = urlElements[urlElements.length-1];
			customerService.deleteCustomer(customerId);
			
			List<Customer> customers = customerService.findCustomers();
			request.setAttribute("customers", customers);
			request.getRequestDispatcher("../all").forward(request, response);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String urlPattern = request.getRequestURI();
		if (urlPattern.contains("register")) {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");

			Customer customer = new Customer();
			customer.setFirstName(firstName);
			customer.setLastName(lastName);

			customerService.saveCustomer(customer);

			response.sendRedirect("all");

		}
	}

}
