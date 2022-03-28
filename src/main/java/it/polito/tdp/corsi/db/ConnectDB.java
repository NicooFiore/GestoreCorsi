package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
public static Connection getConnection() {

   try {
		String url="jdbc:mysql://localhost/iscritticorsi?user=root&password=morataNove9";
	return DriverManager.getConnection(url);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	return null;
}
}
}
