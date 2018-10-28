<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.etwig.model.Customer"%>
<jsp:useBean id="customer" class="com.etwig.model.Customer" />
<jsp:setProperty property="*" name="customer" />
<%
	request.setAttribute("customer", customer);
	request.getRequestDispatcher("customers/save").forward(request, response);
%>