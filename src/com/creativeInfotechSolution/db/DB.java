package com.creativeInfotechSolution.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	
	
	// method
		public static Connection getDb() {
			
			try {
				//Class.forName("com.mysql.jdbc.Driver");
				 return DriverManager.getConnection("jdbc:mysql://localhost:3306/inventorydb","root","");
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		} // end of getDb()
}
