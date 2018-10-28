package com.etwig.dao;

public interface LoginDao {

	boolean createLoginTable();

	boolean isValidUser(String userName, String password);

	boolean doesUserExist(String userName);

	int saveLogin(String userName, String password);

	int updateLogin();

	int deleteLogin();
}
