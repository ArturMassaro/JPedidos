package com.github.jpedidos.database.migrations;

import java.sql.*;
import com.github.jpedidos.database.ConexaoBD;

public class OrderProductMigration {
	public static void main() {
		// Inicie a app aqui
		ConexaoBD connect = new ConexaoBD();
		
		String sql = "CREATE TABLE IF NOT EXISTS `order_products` (	`id` int NOT NULL AUTO_INCREMENT,	`product_id` int DEFAULT NULL,	`order_id` int DEFAULT NULL,	`qtd` int DEFAULT NULL,	`created_at` datetime NOT NULL,	`updated_at` datetime DEFAULT NULL,	PRIMARY KEY (`id`),	KEY `fk_order_products_product_idx` (`product_id`),	KEY `fk_order_products_order_idx` (`order_id`),	CONSTRAINT `fk_order_products_order` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,	CONSTRAINT `fk_order_products_product` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`) ON DELETE SET NULL ON UPDATE CASCADE) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

		//Prepara a instrução SQL
		try {
			
			PreparedStatement ps = connect.conn.prepareStatement(sql);
			//Executa a instrução SQL
			ps.execute();
			System.out.println("Products created");

		} catch (Exception e) {
			//TODO: handle exception
			System.out.println(e);

		}


	}
}
