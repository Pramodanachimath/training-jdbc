package com.training.demos;

import java.sql.*;

public class CreateDemo {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/traildb";
		String username = "root";
		String password = "root";
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(url, username, password);

			statement = connection.createStatement();

			String sql = "create table policy(name varchar(20),policy_id int primary key, type varchar(20),premium float)";

			boolean result = statement.execute(sql);
			System.out.println("table created  " + result);
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
