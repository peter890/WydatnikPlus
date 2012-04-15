package com.wydatnik.plus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public  class ShoppingList {

	/**
	 * dodaje otrzymany przez parametr produkt do(listy zakupów) bazy danych
	 * @throws SQLException s
	 */
	public void addProduct(Product produkt) throws SQLException {
	StringBuffer sqlQuery = new StringBuffer();
	sqlQuery.append("INSERT INTO \"main\".\"pio_tran\" (\"title\",\"amount\",\"type\",\"data\") \"VALUES \"("+produkt.getNazwa()+","+produkt.getCena()+","+produkt.getTyp()+","+produkt.getData()+")");
	Connection cn = MysqlConnection.getConnection();
	ResultSet rs = cn.createStatement().executeQuery(sqlQuery.toString());
	} 

	/**
				 */
	public void delProduct(Product produkt) {
	}

	/**
					 */
	public void moveToTheExpenditure(Product produkt) {
	}
		
		/**
		 */
		//public abstract void show();
		
public static void main(String[] arg){
	ShoppingList sl = new ShoppingList();
}
}
