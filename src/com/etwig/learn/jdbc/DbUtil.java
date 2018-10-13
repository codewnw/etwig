package com.etwig.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	private static Connection con;

	public static Connection getCon() throws SQLException {
		if (con == null) {
			return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		}
		return con;
	}
}
