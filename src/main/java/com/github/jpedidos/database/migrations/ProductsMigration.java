package com.github.jpedidos.database.migrations;

import java.sql.*;
import com.github.jpedidos.database.ConexaoBD;

public class ProductsMigration {
	public static void main() {
		// Inicie a app aqui
		ConexaoBD connect = new ConexaoBD();
		
		String sql = "CREATE TABLE IF NOT EXISTS `jpedidos`.`products` (`id` INT NOT NULL AUTO_INCREMENT,`name` VARCHAR(1000) NOT NULL,`description` VARCHAR(1000) NULL,`price` FLOAT NOT NULL,`created_at` DATETIME NOT NULL,`updated_at` DATETIME NULL,PRIMARY KEY (`id`));";

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
