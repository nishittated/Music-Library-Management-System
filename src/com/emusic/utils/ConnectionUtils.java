/* Copyright (c) Nishit Tated. All Rights Reserved.
   Project name: Online Election Voting System
 * This project is licensed under the MIT License, see LICENSE. 
 */
package com.emusic.utils;

import java.sql.Connection;   
import java.sql.DriverManager;

public class ConnectionUtils {
	private static final String driverClass = "com.mysql.jdbc.Driver",
			url = "jdbc:mysql://localhost:3306/emusic_db",
			username = "root",
			password = "Your_MySQL_Password";

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
 
