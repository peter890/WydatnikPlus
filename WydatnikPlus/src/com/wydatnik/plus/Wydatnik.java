package com.wydatnik.plus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Wydatnik {

	/*public static void main(String[] s) {
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
	}*/
	
	private int userId=0;
	private StringBuffer sqlQuery;
	private ShoppingList shoppingList;
	private void execQuery(String query){
		// to implement
	}
	public void synchronizeData(){
		// to implement
	}
	public void addProduct(Product p){
		// to implement
	}
	public void delProduct(Product p){
		// to implement
	}
	public void editProduct(Product p){
		
	}
	public void addExpense(Product p){
		// to implement
	}
	public void delExpense(Product p){
		// to implement
	}
	public void editExpense(Product p){
		// to implement
		
	}
}
