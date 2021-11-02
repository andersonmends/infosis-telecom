package br.jus.tjpe.infosistelecom.factory;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionFactory {

	public static Connection getConnection() {

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("SUCESSO");
			return DriverManager.getConnection("jdbc:mysql://???.???.???.??/??_???????????", "?????????", "???????"); //apaguei o login e senha do BD para deixar no git
		} catch (SQLException e) {
			System.out.println("ERRO");
			throw new RuntimeException(e);
			
		}

	}
}
