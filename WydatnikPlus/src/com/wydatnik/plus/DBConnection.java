package com.wydatnik.plus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class DBConnection {

	/** 
	 * @uml.property name="DriverName" readOnly="true"
	 */
	protected String driverName;
	/** 
	 * @uml.property name="DBURL"
	 */
	protected String dburl;

	/** 
	 * Getter of the property <tt>DBURL</tt>
	 * @return Returns the dburl.
	 * @uml.property name="DBURL"
	 */
	public String getDBURL() {
		return dburl;
	}

	/** 
	 * Setter of the property <tt>DBURL</tt>
	 * @param DBURL The dburl to set.
	 * @uml.property  name="DBURL"
	 */
	public void setDBURL(String dburl) {
		this.dburl = dburl;
	}

	/** 
	 * @uml.property name="statement"
	 */
	protected Statement statement;

	public ResultSet executeQuery(String sqlQuery) throws SQLException {

		return statement.executeQuery(sqlQuery);
	}

	/**
			 */
	public void close() {
	}

	/** 
	 * @uml.property name="connection"
	 */
	protected static Connection connection;
	
	

}
