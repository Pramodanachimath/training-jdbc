package com.training.prepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PtreResultDemo {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/traildb";
		String username = "root";
		String password = "root";
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
			String type1 = "Veg";
			String sql = "select * from food where type=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, type1);

			resultset = preparedStatement.executeQuery();

			while (resultset.next()) {
				String name = resultset.getString("name");
				int foodId = resultset.getInt("food_id");
				String type = resultset.getString("type");
				float cost = resultset.getFloat("cost");
				System.out.println(name + "\t" + foodId + "\t" + type + "\t" + cost);
			}

			preparedStatement.execute();

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
