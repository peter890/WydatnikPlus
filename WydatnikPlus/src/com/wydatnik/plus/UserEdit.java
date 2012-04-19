package com.wydatnik.plus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;

public class UserEdit {

	User user;

	private int id;
	private String login;
	private String password;
	private String imie;
	private String nazwisko;
	private String email;
	private String lastLogin;

	public UserEdit(User user) {
		this.user = user;
		this.id = user.getId();
		this.login = user.getLogin();
		this.password = user.getPassword();
		this.imie = user.getImie();
		this.nazwisko = user.getNazwisko();
		this.email = user.getEmail();
		this.lastLogin = user.getLastLogin();
	}

	public void editPassword(String oldPass, String newPass1, String newPass2) {

		if (Login.isLogged()) {
			if (password.equals(oldPass)) {
				if (newPass1.equals(newPass2)) {
					password = newPass1;
				}
			}
		}
	}

	public void editImie(String imie) {
		this.imie = imie;
	}

	public void editNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public void editEmail(String email) {
		this.email = email;
	}

	public void editLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public void acceptChanges() throws SQLException {
		String acceptChanges = "UPDATE users_global SET passwd='" + password
				+ "', imie='" + imie + "', nazwisko='" + nazwisko
				+ "', email='" + email + "', lastLogin='" + lastLogin
				+ "' WHERE id='" + id + "'";

		Connection cn = SqliteConnection.getConnection();

		if (!cn.createStatement().execute(acceptChanges)) {
			System.out.println("Profil uaktualniono");
			Login.loginByUser(new User(user.getId(), user.getLogin(), user
					.getPassword(), user.getImie(), user.getNazwisko(), user
					.getEmail(), user.getLastLogin()));

		} else {
			System.out.println("Problem z edycja");
		}
	}

	public void resetPassword(String login, String email) throws SQLException {
		Connection cn = SqliteConnection.getConnection();
		ResultSet rs = cn.createStatement().executeQuery(
				"SELECT * FROM users_global WHERE email='" + email + "' AND login='"+login+"'");
		String newPassword = passwordGenerator(8);
		if (rs.next() && rs.getString("email").equals(email)) {
			String updateQuery = "UPDATE users_global SET passwd='"
					+ newPassword + "' WHERE email='" + email + "'";
			cn.createStatement().execute(updateQuery);
			
			String[] to = {"\n"+email+"\n"};
			String subject = "Nowe haslo";
			String message = "Twoje nowe haslo: "+newPassword;
			
			Mail mail = new Mail(to, subject, message);
			
			mail.sendMail(to, subject, message);
		}

	}

	public String passwordGenerator(int length) {
		char[] text = new char[length];
		Random rnd = new Random();
		String characters = "ABCDEFGHIJKLMNOPRSTUWXYZ0123456789";

		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rnd.nextInt(characters.length()));
		}
		return new String(text);
	}
	
	
	

	public static void main(String[] arg) {
		try {
			User u = new Registration().Register("user234", "haslo",
					"haslo", "siekierski89@o2.pl");

			Login.loginByUser(u);

			System.out.println(Login.isLogged());
			
			UserEdit userEdit = new UserEdit(u);

			/*
			 * userEdit.editImie("Piotr"); userEdit.editNazwisko("Kopiñski3");
			 * userEdit.editPassword("zaqwsx", "pass", "pass");
			 * userEdit.acceptChanges(); System.out.println(u.toString());
			 */

			userEdit.resetPassword("user234","siekierski89@o2.pl");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("B³¹d sql");
		}
	}

}
