package com.etwig.model;

public class Customer {

	private String id;

	private String firstName;

	private String lastName;

	private String email;

	private String mobile;

	private String street1;

	private String street2;

	private String city;

	private String state;

	private String country;

	private String postCode;
	
	private boolean tncAccepted;
	
	private String password;


	public boolean isTncAccepted() {
		return tncAccepted;
	}

	public void setTncAccepted(boolean tncAccepted) {
		this.tncAccepted = tncAccepted;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", mobile=" + mobile + ", street1=" + street1 + ", street2=" + street2 + ", city=" + city + ", state="
				+ state + ", country=" + country + ", postCode=" + postCode + ", tncAccepted=" + tncAccepted + "]";
	}
	
	

}
