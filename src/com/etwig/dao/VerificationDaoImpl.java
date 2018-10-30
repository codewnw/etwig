package com.etwig.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.etwig.dao.util.DbMetaData;
import com.etwig.dao.util.DbUtil;

public class VerificationDaoImpl implements VerificationDao {

	private static final String createOtpQuery = "CREATE TABLE ETWIG_OTP (USER_NAME VARCHAR, OTP NUMBER)";

	private static final String insertOtpQuery = "INSERT INTO ETWIG_OTP VALUES(? ,?)";

	private static final String verifyOtpQuery = "SELECT * FROM ETWIG_OTP WHERE USER_NAME = ? AND OTP = ?";

	private static final String deleteOtpQuery = "DELETE FROM ETWIG_OTP WHERE USER_NAME = ?";

	@Override
	public int saveOtp(String userName, int otp) {
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(insertOtpQuery)) {
			pstmt.setString(1, userName);
			pstmt.setInt(2, otp);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean varifyOtp(String userName, int otp) {
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(verifyOtpQuery)) {
			pstmt.setString(1, userName);
			pstmt.setInt(2, otp);
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public int deleteOtp(String userName) {
		try (Connection con = DbUtil.getCon(); PreparedStatement pstmt = con.prepareStatement(deleteOtpQuery)) {
			pstmt.setString(1, userName);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean createVarificationTable() {
		String tableName = "ETWIG_OTP";
		if (!DbMetaData.isTableExists(tableName)) {
			try (Connection con = DbUtil.getCon(); Statement stmt = con.createStatement()) {
				System.out.println("Creating table " + tableName);
				return !stmt.execute(createOtpQuery);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Table " + tableName + " already exists.");
		}
		return false;
	}

}
