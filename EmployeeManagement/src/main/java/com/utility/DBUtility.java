package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

// Singleton Design Pattern   [Read Static ]
public class DBUtility {

	private static Connection con = null;

	private DBUtility() {

	}

	public static Connection getDBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaemp", "root", "root");
		} catch (Exception e) {
			System.out.println("DBUTILITY  " + e);
		}
		return con;
	}

}
