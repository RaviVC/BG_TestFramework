package com.te.qa.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class DataBase_Helper {
	
	@Test
	public void testDB() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","Kukkeshree@179");
		System.out.println("Connected to MySQL DB");
		Statement set = connection.createStatement();
		ResultSet rs = set.executeQuery("select * from country");
		while(rs.next()) {
			String regionName = rs.getString("Region");
			System.out.println(regionName);
		}
	}

}
