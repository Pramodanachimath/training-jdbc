package com.training.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultDemo {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/traildb";
		String username = "root";
		String password = "root";
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(url, username, password);

			statement = connection.createStatement();

			String query = "select * from policy";
			ResultSet rs = statement.executeQuery(query);

			while (rs.next()) {
				System.out.println(rs.getString("name") + "\t " + rs.getInt("policy_id") + " \t" + rs.getString("type")
						+ "\t " + rs.getFloat("premium"));
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (connection != null) {
					connection.close();
					if (statement != null) {
						statement.close();
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
