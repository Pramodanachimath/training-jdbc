package com.training.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDemo {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/traildb";
		String username = "root";
		String password = "root";
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection(url, username, password);

			statement = connection.createStatement();

			Scanner sc = new Scanner(System.in);
			for (int i = 0; i <= 4; i++) {
				System.out.println("Enter policy name");
				String name = sc.next();
				System.out.println("Enter policy Id");
				int policyId = sc.nextInt();
				System.out.println("Enter policy type");
				String type = sc.next();
				System.out.println("Enter policy premium");
				float premium = sc.nextFloat();

				String sql = "insert into policy values('" + name + "'," + policyId + ",'" + type + "'," + premium
						+ ")";

				int result = statement.executeUpdate(sql);
				System.out.println("Inserted  " + result);
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
