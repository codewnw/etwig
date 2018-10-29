package com.etwig.presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.etwig.model.Customer;
import com.etwig.service.CustomerService;
import com.etwig.service.CustomerServiceImpl;
import com.etwig.service.LoginService;
import com.etwig.service.LoginServiceImpl;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginService loginService;
	
	private CustomerService customerService;

	public LoginServlet() {
		loginService = new LoginServiceImpl();
		customerService = new CustomerServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		boolean isValidUser = loginService.isValidUser(userName, password);
		if (isValidUser) {
			request.setAttribute("message", "Login Successfull!");
			HttpSession session = request.getSession();
			session.setAttribute(userName, userName);
			Customer customer = customerService.findCustomerByUserName(userName);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		} else {
			response.sendRedirect("login.jsp?message=Login Failed! Please try again...");
		}
	}

}
