package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreUpdateDemo {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/traildb";
		String username = "root";
		String password = "root";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManager.getConnection(url, username, password);
			String type1 = "BreakFast";
			String sql = "update food set type=? where food_Id=10";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, type1);

			preparedStatement.executeUpdate();
			System.out.println("Updated");

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
