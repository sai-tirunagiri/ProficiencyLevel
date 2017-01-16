package com.org.Factory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class connectionFactory {
			
	



	/**
	 * 
	 * 
	 *
	 */

	

		private static String uri;
		private static String userName;
		private static String password;
		private static String driverName;
		private static Connection connection;

		static {
			uri = "jdbc:mysql://localhost:3306/qicmetrics";
			userName = "root";
			password = "";
			driverName = "org.gjt.mm.mysql.Driver";
		}

		public boolean getConnection() throws ClassNotFoundException,SQLException {
			Class.forName(driverName);
			System.out.println("Driver loaded successfully!");
			connection = DriverManager.getConnection(uri, userName, password);
			
			
			if (connection != null) {
				System.out.println("Connection established!");
				return true;
			} else {
				System.out.println("Connection failed to DB");
				return false;
			}
			
		}
	

	

}
