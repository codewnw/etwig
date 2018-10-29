package com.etwig.service;

import com.etwig.dao.LoginDao;
import com.etwig.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {

	private LoginDao loginDao;

	public LoginServiceImpl() {
		super();
		loginDao = new LoginDaoImpl();
	}

	@Override
	public boolean createLoginTable() {
		return loginDao.createLoginTable();
	}

	@Override
	public boolean isValidUser(String userName, String password) {
		return loginDao.isValidUser(userName, password);
	}

	@Override
	public boolean doesUserExist(String userName) {
		return loginDao.doesUserExist(userName);
	}

	@Override
	public int saveLogin(String userName, String password) {
		return loginDao.saveLogin(userName, password);
	}

	@Override
	public int updateLogin() {
		return loginDao.updateLogin();
	}

	@Override
	public int deleteLogin() {
		return loginDao.deleteLogin();
	}

}
