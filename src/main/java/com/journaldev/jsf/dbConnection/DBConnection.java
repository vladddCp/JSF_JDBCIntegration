package com.journaldev.jsf.dbConnection;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBConnection {
	
    private static DBConnection datasource;
    private ComboPooledDataSource cpds;
	
	private DBConnection() {
	cpds = new ComboPooledDataSource(); 
	
	try {
		cpds.setDriverClass( "com.mysql.jdbc.Driver" );  //loads the jdbc driver 
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	cpds.setJdbcUrl( "jdbc:mysql://localhost/mysqltestdb" ); 
	cpds.setUser("root"); 
	cpds.setPassword("");
	
	cpds.setMaxStatements( 180 );
	cpds.setMinPoolSize(5);
	cpds.setAcquireIncrement(5); 
	cpds.setMaxPoolSize(20);
	}
	
	public static DBConnection getInstance() throws IOException, SQLException, PropertyVetoException {
		if (datasource == null) {
			datasource = new DBConnection();
			return datasource;
		} else {
			return datasource;
		}
	}

	public Connection getConnection() throws SQLException {
		return this.cpds.getConnection();
	}

}