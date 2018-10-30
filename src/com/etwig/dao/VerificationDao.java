package com.etwig.dao;

public interface VerificationDao {
	boolean createVarificationTable();

	int saveOtp(String userName, int otp);

	boolean varifyOtp(String userName, int otp);

	int deleteOtp(String userName);
}
