package com.wydatnik.plus;

public final class User {

	private int id;
	private String login;
	private String password;
	private String imie;
	private String nazwisko;
	private String email;
	private String lastLogin;
	
	
	
	public User(int id, String login, String password, String imie, String nazwisko, String email, String lastLogin)
	{
		this.id = id;
		this.login = login;
		this.password = password;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.email = email;
		this.lastLogin = lastLogin;
	}
	public User(){
		this.id = 0;
		this.login = "";
		this.password = "";
		this.imie = "";
		this.nazwisko = "";
		this.email = "";
		this.lastLogin = "";
		
	}



	public int getId() {
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
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password
				+ ", imie=" + imie + ", nazwisko=" + nazwisko + ", email="
				+ email + ", lastLogin=" + lastLogin + "]";
	}
	
	
}
