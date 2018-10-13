package com.etwig.learn.jdbc;

import java.sql.Statement;

import com.etwig.learn.jdbc.DbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class CreateTable {
 
          public static void main(String[] args) {
        	  try {
//      			1. Establish the connection with database
      			Connection con =  DbUtil.getCon();
//      			2. Create statement/command
      			Statement stmt = con.createStatement();
//      			3. execute the command
      boolean retVal = stmt.execute("CREATE TABLE etwig project (id NUMBER, name VARCHAR,description VARCHAR,price NUMBER,quantity Number)");

//      			4. Process the result
      			if (!retVal) {
      				System.out.println("Table created successfully!");
      			}
      		} catch (SQLException e) {
      			e.printStackTrace();
      		}
      	}


      }
