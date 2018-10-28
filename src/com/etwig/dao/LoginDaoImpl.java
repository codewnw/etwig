package com.etwig.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.etwig.dao.util.DbMetaData;
import com.etwig.dao.util.DbUtil;
import com.etwig.util.IdGenerator;

public class LoginDaoImpl implements LoginDao {

	private static final String createLoginTableQuery = "CREATE TABLE ETWIG_LOGIN (USER_NAME VARCHAR, PASSWORD VARCHAR)";
	private static final String isValidUserQuery = "SELECT * FROM ETWIG_LOGIN WHERE USER_NAME = ? AND PASSWORD = ?";
	private static final String insertLoginQuery = "INSERT INTO ETWIG_LOGIN VALUES(?, ?)";

	@Override
	public boolean createLoginTable() {
		String tableName = "ETWIG_LOGIN";
		if (!DbMetaData.isTableExists(tableName)) {
			try (Connection con = DbUtil.getCon(); Statement stmt = con.createStatement()) {
				System.out.println("Creating table " + tableName);
				return !stmt.execute(createLoginTableQuery);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Table " + tableName + " already exists.");
		}
		return false;
	}

	@Override
	public boolean isValidUser(String userName, String password) {
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(isValidUserQuery)) {
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean doesUserExist(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveLogin(String userName, String password) {
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(insertLoginQuery)) {
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateLogin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteLogin() {
		// TODO Auto-generated method stub
		return 0;
	}

}
