package com.wydatnik.plus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class SqliteConnection extends DBConnection {

	/**
	 * @uml.property  name="ourInstance" readOnly="true"
	 */
	private static final SqliteConnection ourInstance = new SqliteConnection();
	
			public static SqliteConnection getInstance(){
			
						return ourInstance;
			}
					private SqliteConnection(){
						driverName = "org.sqlite.JDBC";
						dbPath ="d:\\wydatnikpro.sqlite";
						
						sJdbc = "jdbc:sqlite";
						setDBURL(sJdbc + ":" + dbPath);
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
					 * @uml.property  name="DbPath"
					 */
					private String dbPath;
					/**
					 * @uml.property  name="sJdbc"
					 */
					private String sJdbc;
					public static Connection getConnection(){
						return connection;
						
					}

}
