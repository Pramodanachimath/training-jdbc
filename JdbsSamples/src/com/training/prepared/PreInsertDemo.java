package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreInsertDemo {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/traildb";
		String username = "root";
		String password = "root";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
			String sql = "insert into  food values(?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "Dosa");
			preparedStatement.setInt(2, 10);
			preparedStatement.setFloat(3, 120);
			preparedStatement.setString(4, "veg");
			System.out.println();
			preparedStatement.setString(1, "poori");
			preparedStatement.setInt(2, 20);
			preparedStatement.setFloat(3, 120);
			preparedStatement.setString(4, "veg");
			System.out.println();

			preparedStatement.execute();

			System.out.println("values inserted");

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
