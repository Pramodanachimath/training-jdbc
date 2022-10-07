package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreInsertScanDemo {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/traildb";
		String username = "root";
		String password = "root";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
			String sql = "insert into food values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			Scanner sc = new Scanner(System.in);
			for (int i = 0; i < 2; i++) {
				System.out.println("Enter food name");
				String name = sc.next();
				System.out.println("Enter food Id");
				int foodId = sc.nextInt();
				System.out.println("Enter food type");
				String type = sc.next();
				System.out.println("Enter cost");
				float cost = sc.nextFloat();

				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, foodId);
				preparedStatement.setString(4, type);
				preparedStatement.setFloat(3, cost);
			}

			preparedStatement.execute();
			sc.close();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {
				if (connection != null) {
					connection.close();
					if (preparedStatement != null) {
						preparedStatement.close();
					}
				}

			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}

}
