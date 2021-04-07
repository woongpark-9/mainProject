package com.javaline.custom;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MyOracleConnectionTest {
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String URL = "jdbc:postgresql://nowflix.cwawhirfvjft.us-east-2.rds.amazonaws.com:5432/nowflix";
	private static final String ID = "nowflix";
	private static final String PASS = "nowflix3";

	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		try (Connection conn = DriverManager.getConnection(URL, ID, PASS)) {
			System.out.println(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
