package com.etwig.presentation.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.etwig.service.CustomerService;
import com.etwig.service.CustomerServiceImpl;
import com.etwig.service.LoginService;
import com.etwig.service.LoginServiceImpl;
import com.etwig.service.VerificationService;
import com.etwig.service.VerificationServiceImpl;

@WebListener
public class MyServletContextListener implements ServletContextListener {

	private CustomerService customerService;

	private LoginService loginService;
	
	private VerificationService verificationService;

	public MyServletContextListener() {
		customerService = new CustomerServiceImpl();
		loginService = new LoginServiceImpl();
		verificationService = new VerificationServiceImpl();
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println(">> " + this.getClass().getName());
		String tableCreationRequired = sce.getServletContext().getInitParameter("tableCreation");
		if (tableCreationRequired != null && tableCreationRequired.equalsIgnoreCase("yes")) {
			customerService.createCustomerTable();
			loginService.createLoginTable();
			verificationService.createVarificationTable();
		}
		System.out.println("<< " + this.getClass().getName());
	}

}
