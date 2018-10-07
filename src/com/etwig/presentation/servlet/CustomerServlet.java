package com.etwig.presentation.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etwig.service.CustomerService;
import com.etwig.service.CustomerServiceImpl;
import com.etwig.service.ItemService;
import com.etwig.service.ItemServiceImpl;


@WebServlet("/Customer")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerService customerService;
    public CustomerServlet() {
        super();
        this.customerService = new CustomerServiceImpl();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In " + this.getClass().getSimpleName());
		customerService.findCustomer("junk");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
