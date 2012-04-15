package com.wydatnik.plus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Statyczna klasa, która zapewnia po zalogowaniu dostêp do informacji o
 * uzytkowniku.
 */
public final class Login {
	private static User user;
	private static boolean isLogged;
	private static final Login instance = new Login();

	public static Login getInstance() {
		return instance;
	}

	private Login() {
		user = null;
		isLogged = false;
	};

	/**
	 * Zwraca referencjê do obiektu User
	 */
	public static com.wydatnik.plus.User getUser() {

		return user;
	}

	/**
	 * Metoda pozwalaj¹ca zalogowac sie na podstawie loginu i hasla
	 * 
	 * @throws SQLException
	 */
	public static boolean login(String login, String password)
			throws SQLException {
		Connection cn = SqliteConnection.getConnection();

		ResultSet rs = cn
				.createStatement()
				.executeQuery(
						"SELECT id, login, passwd, imie, nazwisko, email, lastLogin FROM users_global WHERE login ='"
								+ login + "' AND passwd='" + password + "'");
		if (rs.getRow() == 1) {
			loginByUser(new User(rs.getInt("id"), rs.getString("login"),
					rs.getString("passwd"), rs.getString("imie"),
					rs.getString("nazwisko"), rs.getString("email"),
					rs.getString("lastLogin")));

			return true;
		}

		return false;
	}

	/**
	 * Metoda pozwalaj¹ca zalogowac sie na podstawie obiektu klasy User
	 */
	public static boolean loginByUser(User u) {

		if (u != null) {
			user = u;
			isLogged = true;
			return true;
		}
		return false;
	}

	/**
	 * Wylogowuje aktualnego Usera i odcina dostêp do referencji(user = null)
	 */
	public static boolean logout() {
		isLogged = false;
		user = null;
		return true;
	}
	
	public static boolean isLogged(){
			return isLogged;
	}

}
