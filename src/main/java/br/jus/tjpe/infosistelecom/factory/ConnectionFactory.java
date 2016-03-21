package br.jus.tjpe.infosistelecom.factory;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;



public class ConnectionFactory {

	public static Connection getConnection() {

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("SUCESSO");
//			return DriverManager.getConnection("jdbc:mysql://localhost/db_infosistele", "root", "123456");
		//	return DriverManager.getConnection("jdbc:mysql://172.28.50.3/db_infosistelecom_homo", "root", "(C15c*)");
			return DriverManager.getConnection("jdbc:mysql://192.168.251.19/db_infosistele", "sistelecom", "123456");
		} catch (SQLException e) {
			System.out.println("ERRO");
			throw new RuntimeException(e);
			
		}

	}
}
