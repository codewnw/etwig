package com.etwig.learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insertdata {

	public static void main(String[] args) {
		try {
			Connection con = DbUtil.getCon();
			Statement stmt = con.createStatement();
			int retVal = stmt.executeUpdate("INSERT INTO etwig project VALUES(1001, 'mobile',’samsung galaxy’,9000,2)");

			if (retVal > 0) {
				System.out.println("Record has been inseted successfully.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
