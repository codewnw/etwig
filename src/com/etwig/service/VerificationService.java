package com.etwig.service;

public interface VerificationService {
	boolean createVarificationTable();

	int saveOtp(String userName, int otp);

	boolean varifyOtp(String userName, int otp);

	int deleteOtp(String userName);
}
