package com.etwig.presentation.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.etwig.model.Item;
import com.etwig.service.CustomerService;
import com.etwig.service.CustomerServiceImpl;
import com.etwig.service.ItemService;
import com.etwig.service.ItemServiceImpl;
import com.etwig.service.LoginService;
import com.etwig.service.LoginServiceImpl;
import com.etwig.service.VerificationService;
import com.etwig.service.VerificationServiceImpl;
import static com.etwig.util.IdGenerator.generateItemId;

@WebListener
public class MyServletContextListener implements ServletContextListener {

	private CustomerService customerService;

	private LoginService loginService;
	
	private VerificationService verificationService;
	
	private ItemService itemservice;

	public MyServletContextListener() {
		customerService = new CustomerServiceImpl();
		loginService = new LoginServiceImpl();
		verificationService = new VerificationServiceImpl();
		itemservice = new ItemServiceImpl();
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
			itemservice.createItemTable();
			if(itemservice.findItems().isEmpty()) {
				itemservice.saveItem(new Item(generateItemId(), "Item 1", "Description 1", 101.1d, 100, "somting"));
				itemservice.saveItem(new Item(generateItemId(), "Item 2", "Description 2", 102.1d, 200, "somting"));
				itemservice.saveItem(new Item(generateItemId(), "Item 3", "Description 3", 103.1d, 300, "somting"));
				itemservice.saveItem(new Item(generateItemId(), "Item 4", "Description 4", 104.1d, 400, "somting"));
				itemservice.saveItem(new Item(generateItemId(), "Item 5", "Description 5", 105.1d, 500, "somting"));
			}
		}
		System.out.println("<< " + this.getClass().getName());
	}

}
