package com.etwig.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class DbUtil {
	private static Connection con;

	private static String url;

	private static String userName;

	private static String password;

	static {
		ResourceBundle rb = ResourceBundle.getBundle("db", Locale.US);
		url = rb.getString("url");
		userName = rb.getString("userName");
		password = rb.getString("password");
	}

	public static Connection getCon() throws SQLException {
		if (con == null || con.isClosed()) {
			try {
				Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			return DriverManager.getConnection(url, userName, password);
		}
		return con;
	}
}
