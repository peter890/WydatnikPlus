package com.wydatnik.plus;

public final class User {

	private double id;
	private String login;
	private String password;
	private String imie;
	private String nazwisko;
	private String email;
	private String lastLogin;
	
	
	
	public User(double id, String login, String password, String imie, String nazwisko, String email, String lastLogin)
	{
		this.id = id;
		this.login = login;
		this.password = password;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.email = email;
		this.lastLogin = lastLogin;
	}



	public double getId() {
		return id;
	}



	public String getLogin() {
		return login;
	}



	public String getPassword() {
		return password;
	}



	public String getImie() {
		return imie;
	}



	public String getNazwisko() {
		return nazwisko;
	}



	public String getEmail() {
		return email;
	}



	public String getLastLogin() {
		return lastLogin;
	}
	
	
}
