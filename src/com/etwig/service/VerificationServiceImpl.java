package com.etwig.service;

import com.etwig.dao.VerificationDao;
import com.etwig.dao.VerificationDaoImpl;

public class VerificationServiceImpl implements VerificationService {
	private VerificationDao verificationDao;

	public VerificationServiceImpl() {
		verificationDao = new VerificationDaoImpl();
	}

	@Override
	public boolean createVarificationTable() {
		return verificationDao.createVarificationTable();
	}

	@Override
	public int saveOtp(String userName, int otp) {
		return verificationDao.saveOtp(userName, otp);
	}

	@Override
	public boolean varifyOtp(String userName, int otp) {
		return verificationDao.varifyOtp(userName, otp);
	}

	@Override
	public int deleteOtp(String userName) {
		return verificationDao.deleteOtp(userName);
	}

}
