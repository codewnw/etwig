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

	private static final String createLoginTableQuery = "CREATE TABLE ETWIG_LOGIN (USER_NAME VARCHAR, PASSWORD VARCHAR, STATUS VARCHAR)";
	private static final String isValidUserQuery = "SELECT * FROM ETWIG_LOGIN WHERE USER_NAME = ? AND PASSWORD = ? AND STATUS != 'Not Verified'";
	private static final String insertLoginQuery = "INSERT INTO ETWIG_LOGIN VALUES(?, ?, ?)";
	private static final String updateLoginPasswordQuery = "UPDATE ETWIG_LOGIN SET PASSWORD = ? WHERE USER_NAME = ?";
	private static final String updateLoginStatusQuery = "UPDATE ETWIG_LOGIN SET STATUS = ? WHERE USER_NAME = ?";

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
		return false;
	}

	@Override
	public int saveLogin(String userName, String password) {
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(insertLoginQuery)) {
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			pstmt.setString(3, "Not Verified");
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateLoginStatus(String userName, String newStatus) {
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(updateLoginStatusQuery)) {
			pstmt.setString(1, newStatus);
			pstmt.setString(2, userName);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateLoginPassword(String userName, String newPassword) {
		try (Connection con = DbUtil.getCon();
				PreparedStatement pstmt = con.prepareStatement(updateLoginPasswordQuery)) {
			pstmt.setString(1, newPassword);
			pstmt.setString(2, userName);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteLogin() {
		return 0;
	}

}
