package com.wydatnik.plus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class Registration {

	/*
	 * private String login; private String password; private String imie;
	 * private String nazwisko; private String email;
	 */
	private String login;
	private String password1;
	private String password2;
	private String email;

	public Registration() {
	}

	public User Register(String login, String password1, String password2,
			String email) throws SQLException {

		this.login = login;
		this.password1 = password1;
		this.password2 = password2;
		this.email = email;

		Connection cn = SqliteConnection.getConnection();

		if (checkLogin() && checkEmail() && passwordCompare()) {
			if ((cn.createStatement()
					.execute("SELECT * FROM users_global WHERE login='" + login
							+ "'AND email='" + email + "'"))) {
				String registerQuery = "INSERT INTO \"users_global\" (login,passwd,email) VALUES ('"
						+ login + "','" + password1 + "','" + email + "')";

				if (!cn.createStatement().execute(registerQuery)) {
					ResultSet rs = cn
							.createStatement()
							.executeQuery(
									"SELECT id, login, passwd, imie, nazwisko, email, lastLogin FROM users_global");
					return new User(rs.getInt("id"), rs.getString("login"),
							rs.getString("passwd"), rs.getString("imie"),
							rs.getString("nazwisko"), rs.getString("email"),
							rs.getString("lastLogin"));
				}
			}
		}

		return new User();
	}

	public boolean checkEmail() throws SQLException {
		// zwraca true jesli email NIE istnieje w bazie danych
		Connection cn = SqliteConnection.getConnection();
		ResultSet rs = cn.createStatement().executeQuery(
				"SELECT email FROM users_global WHERE email='" + email + "'");

		if (rs.next() && rs.getString("email").equals(email)) {
			return false;
		} else {
			return true;
		}
	}

	public boolean checkLogin() throws SQLException {
		// zwraca true jesli login NIE istnieje w bazie danych
		Connection cn = SqliteConnection.getConnection();
		ResultSet rs = cn.createStatement().executeQuery(
				"SELECT login FROM users_global WHERE login='" + login + "'");

		if (rs.next() && rs.getString("login").equals(login)) {
			return false;
		} else {
			return true;
		}
	}

	public boolean passwordCompare() {
		// zwraca true jesli hasla sa identyczne
		if (password1.equals(password2)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static void main(String[] arg) {
		try {
			User reg = new Registration().Register("janek12", "zaqwsx",
					"zaqwsx", "zolter2212@gmail.com");

			System.out.println(reg.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("B³¹d sql");
		}
	}

}
