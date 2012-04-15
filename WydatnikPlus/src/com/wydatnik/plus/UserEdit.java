package com.wydatnik.plus;

import java.sql.Connection;
import java.sql.SQLException;

public class UserEdit {
	
	User user;
	
	private int id;
	private String login;
	private String password;
	private String imie;
	private String nazwisko;
	private String email;
	private String lastLogin;
	
	
	public UserEdit(User user){
		this.user = user;
		this.id = user.getId();
		this.login = user.getLogin();
		this.password = user.getPassword();
		this.imie = user.getImie();
		this.nazwisko = user.getNazwisko();
		this.email = user.getEmail();
		this.lastLogin = user.getLastLogin();
	}
	
	
	public void editPassword(String oldPass, String newPass1, String newPass2){
		
		if(Login.isLogged()){
			if(password.equals(oldPass))
			{
				if(newPass1.equals(newPass2)){
					password = newPass1;
				}
			}
		}
	}
	
	
	public void editImie(String imie){
		this.imie = imie;
	}
	
	
	public void editNazwisko(String nazwisko){
		this.nazwisko = nazwisko;
	}
	
	
	public void editEmail(String email){
		this.email = email;
	}
	
	
	public void editLastLogin(String lastLogin){
		this.lastLogin = lastLogin;
	}
	
	
	public void acceptChanges() throws SQLException{
		String acceptChanges = "UPDATE users_global SET passwd='"+ password +"', imie='"+ imie +"', nazwisko='"+ nazwisko +"', email='"+ email +"', lastLogin='"+ lastLogin +"' WHERE id="+id;
		
		Connection cn = SqliteConnection.getConnection();
		
		if (!cn.createStatement().execute(acceptChanges)){
			System.out.println("Profil uaktualniono");
			Login.loginByUser(new User(user.getId(), user.getLogin(), user.getPassword(), user.getImie(), user.getNazwisko(), user.getEmail(), user.getLastLogin()));
			
		}
		else{
			System.out.println("Problem z edycja");
		}
	}
	
	public static void main(String[] arg) {
		try {
			User u  = Registration.Register("peter890", "zaqwsx", "zolter17@gmail.com");
			System.out.println(u.toString());
			
			Login.loginByUser(u);
			UserEdit userEdit = new UserEdit(u);
			
			
			userEdit.editImie("Piotr");
			userEdit.editNazwisko("Kopiñski2");
			userEdit.editPassword("zaqwsx", "pass", "pass");
			userEdit.acceptChanges();
			System.out.println(u.toString());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("B³¹d sql");
		}
	}

}
