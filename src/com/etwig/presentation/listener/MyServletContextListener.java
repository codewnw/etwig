package com.etwig.presentation.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.etwig.dao.LoginDao;
import com.etwig.dao.LoginDaoImpl;
import com.etwig.service.CustomerService;
import com.etwig.service.CustomerServiceImpl;

@WebListener
public class MyServletContextListener implements ServletContextListener {

	private CustomerService customerService;

	private LoginDao loginDao;

	public MyServletContextListener() {
		customerService = new CustomerServiceImpl();
		loginDao = new LoginDaoImpl();
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println(">> " + this.getClass().getName());
		String tableCreationRequired = sce.getServletContext().getInitParameter("tableCreation");
		if (tableCreationRequired != null && tableCreationRequired.equalsIgnoreCase("yes")) {
			customerService.createCustomerTable();
			loginDao.createLoginTable();
		}
		System.out.println("<< " + this.getClass().getName());
	}

}
