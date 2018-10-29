package com.etwig.service;

public interface LoginService {

	boolean createLoginTable();

	boolean isValidUser(String userName, String password);

	boolean doesUserExist(String userName);

	int saveLogin(String userName, String password);

	int updateLogin();

	int deleteLogin();
}
