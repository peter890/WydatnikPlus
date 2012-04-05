package com.wydatnik.plus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Wydatnik {

	public static void main(String[] s) {
		Connection conn = MysqlConnection.getConnection();
		try {

			ResultSet rs = conn.createStatement().executeQuery(
					"select * from users_global");

			while (rs.next()) {

				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					System.out.print(rs.getMetaData().getColumnName(i) + ": ");
					System.out.println(rs.getString(i));
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
