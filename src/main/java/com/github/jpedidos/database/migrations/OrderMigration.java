package com.github.jpedidos.database.migrations;

import java.sql.*;
import com.github.jpedidos.database.ConexaoBD;

public class OrderMigration {
	public static void main() {
		// Inicie a app aqui
		ConexaoBD connect = new ConexaoBD();
		
		String sql = "CREATE TABLE IF NOT EXISTS `jpedidos`.`order` (`id` INT NOT NULL AUTO_INCREMENT,`client_name` VARCHAR(1000) NULL,`client_phone` VARCHAR(1000) NULL,`created_at` DATETIME NOT NULL,`updated_by` DATETIME NULL,`created_by` INT NULL,PRIMARY KEY (`id`),INDEX `fk_order_1_idx` (`created_by` ASC) VISIBLE,CONSTRAINT `fk_order_created_by`	FOREIGN KEY (`created_by`)	REFERENCES `jpedidos`.`users` (`id`)	ON DELETE SET NULL	ON UPDATE CASCADE);";

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
