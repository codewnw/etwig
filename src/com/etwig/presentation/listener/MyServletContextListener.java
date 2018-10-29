package com.etwig.presentation.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.etwig.service.CustomerService;
import com.etwig.service.CustomerServiceImpl;
import com.etwig.service.LoginService;
import com.etwig.service.LoginServiceImpl;

@WebListener
public class MyServletContextListener implements ServletContextListener {

	private CustomerService customerService;

	private LoginService loginService;

	public MyServletContextListener() {
		customerService = new CustomerServiceImpl();
		loginService = new LoginServiceImpl();
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println(">> " + this.getClass().getName());
		String tableCreationRequired = sce.getServletContext().getInitParameter("tableCreation");
		if (tableCreationRequired != null && tableCreationRequired.equalsIgnoreCase("yes")) {
			customerService.createCustomerTable();
			loginService.createLoginTable();
		}
		System.out.println("<< " + this.getClass().getName());
	}

}
