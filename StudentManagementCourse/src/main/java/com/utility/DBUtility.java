package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {

	private static Connection con = null;

	private DBUtility() {

	}

	public static Connection getDBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		} catch (Exception e) {
			System.out.println("Database Connection : " + e);
		}
		return con;

	}

}
