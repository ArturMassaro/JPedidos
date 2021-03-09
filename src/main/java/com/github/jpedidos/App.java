package com.github.jpedidos;

import com.github.jpedidos.database.ConexaoBD;
import com.github.jpedidos.database.MainMigration;
import java.sql.DriverManager;


public class App {
	// DriverManager conection;
	public static void main(String[] args) {
		// Inicie a app aqui
		ConexaoBD connect = new ConexaoBD();
		MainMigration mainMigration = new MainMigration();
		connect.main(args);
		mainMigration.main();

	}
}
