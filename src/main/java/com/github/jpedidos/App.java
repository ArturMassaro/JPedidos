package com.github.jpedidos;

import com.github.jpedidos.database.ConexaoBD;
import com.github.jpedidos.database.MainMigration;
import com.github.jpedidos.app.models.User;
import com.github.jpedidos.app.models.Product;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class App {
	// DriverManager conection;
	public static void main(String[] args) {
		// Inicie a app aqui
		ConexaoBD connect = new ConexaoBD();
		MainMigration mainMigration = new MainMigration();
		User user = new User();
		Product product = new Product();
		connect.main(args);
		mainMigration.main();
		try {

			product.id = 3;
			product.name = "asd - EDIT";
			product.description = "artur@email.com";
			product.price = 10.50;
			product.qtd = 5;
			

			List<Product> findedProducts = product.list();
			System.out.println(findedProducts.get(1).name);
			
		} catch (Exception e) {
			//TODO: handle exception
			System.out.println(e);

		}

	}
}
