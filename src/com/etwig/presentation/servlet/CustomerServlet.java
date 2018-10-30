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
import com.etwig.service.MailService;
import com.etwig.service.MailServiceImpl;
import com.etwig.service.VerificationService;
import com.etwig.service.VerificationServiceImpl;
import com.etwig.util.OtpGenerator;

@WebServlet("/customers/*")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CustomerService customerService;

	private MailService mailService;

	private VerificationService verificationService;

	public CustomerServlet() {
		customerService = new CustomerServiceImpl();
		mailService = new MailServiceImpl();
		verificationService = new VerificationServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String urlPattern = request.getRequestURI();
		if (urlPattern.contains("all")) {
			List<Customer> customers = customerService.findCustomers();
			request.setAttribute("customers", customers);
			request.getRequestDispatcher("../customers.jsp").forward(request, response);
		} else if (urlPattern.contains("delete")) {
			String customerId = getCustomerIdFromUrlPatten(urlPattern);
			customerService.deleteCustomer(customerId);

			List<Customer> customers = customerService.findCustomers();
			request.setAttribute("customers", customers);
			request.getRequestDispatcher("../all").forward(request, response);
		} else if (urlPattern.contains("myhome") && urlPattern.contains("CUST")) {
			String customerId = getCustomerIdFromUrlPatten(urlPattern);
			Customer customer = customerService.findCustomer(customerId);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("../../profile.jsp").forward(request, response);
		} else if (urlPattern.contains("edit") && urlPattern.contains("CUST")) {
			String customerId = getCustomerIdFromUrlPatten(urlPattern);
			Customer customer = customerService.findCustomer(customerId);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("../../customer-registration.jsp").forward(request, response);
		}
		/*
		 * else if(urlPattern.contains("update")){ String[] urlElements =
		 * urlPattern.split("/"); String customerId = urlElements[urlElements.length-1];
		 * customerService.updateCustomer(customerId);
		 * 
		 * List<Customer> customers = customerService.findCustomers();
		 * request.setAttribute("customers", customers);
		 * request.getRequestDispatcher("../all").forward(request, response);
		 * 
		 * }
		 */
	}

	private String getCustomerIdFromUrlPatten(String urlPattern) {
		String[] urlElements = urlPattern.split("/");
		String customerId = urlElements[urlElements.length - 1];
		return customerId;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String urlPattern = request.getRequestURI();
		if (urlPattern.contains("save")) {
			if (request.getAttribute("customer") != null) {
				String customerId = "";
				if (request.getParameter("id") == null || request.getParameter("id").equals("")) {
					Customer newCustomer = (Customer) request.getAttribute("customer");
					customerId = customerService.saveCustomer(newCustomer);
					int otp = OtpGenerator.getOtp();
					System.out.println("OTP is: " + otp);
					mailService.sendMail(newCustomer.getEmail(), "OTP", otp + "");
					verificationService.saveOtp(newCustomer.getEmail(), otp);
				} else {
					if (request.getAttribute("customer") == null) {
						request.getRequestDispatcher("../process-customer-registration.jsp").forward(request, response);
					}
					Customer customer = (Customer) request.getAttribute("customer");
					customerId = customer.getId();
					customerService.updateCustomer(customer);
				}
				response.sendRedirect("myhome/" + customerId);
			} else {
				request.getRequestDispatcher("../process-customer-registration.jsp").forward(request, response);
			}
		}
	}

}
