package com.wydatnik.plus;

import java.sql.DriverManager;
import java.sql.SQLException;

public final class MysqlConnection extends DBConnection {

	/**
	 * @uml.property name="ourInstance" readOnly="true"
	 */
	private static final MysqlConnection ourInstance = new MysqlConnection();

	public static MysqlConnection getInstance() {

		return ourInstance;
	}

	private MysqlConnection() {
		driverName = "com.mysql.jdbc.Driver";
		setUserName("root");
		setPassword("");
		setDBURL("jdbc:mysql://localhost/test?user=" + userName + "&password="
				+ password);
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(dburl);
			statement = connection.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("B³¹d po³¹czenia z baz¹ danych");
		}
	}

	/**
	 * @uml.property name="userName"
	 */
	private String userName;

	/**
	 * Getter of the property <tt>userName</tt>
	 * 
	 * @return Returns the userName.
	 * @uml.property name="userName"
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Setter of the property <tt>userName</tt>
	 * 
	 * @param userName
	 *            The userName to set.
	 * @uml.property name="userName"
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @uml.property name="password"
	 */
	private String password;

	/**
	 * Getter of the property <tt>password</tt>
	 * 
	 * @return Returns the password.
	 * @uml.property name="password"
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter of the property <tt>password</tt>
	 * 
	 * @param password
	 *            The password to set.
	 * @uml.property name="password"
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
