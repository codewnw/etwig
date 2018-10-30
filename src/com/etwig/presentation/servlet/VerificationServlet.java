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
import com.etwig.service.VerificationService;
import com.etwig.service.VerificationServiceImpl;

@WebServlet("/verify")
public class VerificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private VerificationService verificationService;
	
	private CustomerService customerService;
	
	private LoginService loginService;
	
	public VerificationServlet() {
		customerService = new CustomerServiceImpl();
		verificationService = new VerificationServiceImpl();
		loginService = new LoginServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("otp-verification.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		if(verificationService.varifyOtp(userName, Integer.parseInt(request.getParameter("otp")))) {
			verificationService.deleteOtp(userName);
			loginService.updateLoginStatus(userName, "Verified");
			request.setAttribute("message", "Verification Successfull!");
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			Customer customer = customerService.findCustomerByUserName(userName);
			request.setAttribute("customer", customer);
			request.getRequestDispatcher("profile.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("otp-verification.jsp?message=Verfication Failed! Please try again...");
		}
	}

}
