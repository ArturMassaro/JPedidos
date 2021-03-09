package com.github.jpedidos.database.migrations;

import java.sql.*;
import com.github.jpedidos.database.ConexaoBD;

public class UserMigration {
	public static void main() {
		// Inicie a app aqui
		ConexaoBD connect = new ConexaoBD();
		
		String sql = "CREATE TABLE IF NOT EXISTS `users` ( `id` int NOT NULL AUTO_INCREMENT, `name` varchar(500) DEFAULT NULL, `email` varchar(500) NOT NULL, `login` varchar(500) NOT NULL, `password` varchar(500) DEFAULT NULL, `access_type` varchar(500) NOT NULL, `created_at` datetime DEFAULT NULL, `updated_at` datetime DEFAULT NULL, PRIMARY KEY (`id`), UNIQUE KEY `id_UNIQUE` (`id`), UNIQUE KEY `login_UNIQUE` (`login`)) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";

		//Prepara a instrução SQL
		try {
			
			PreparedStatement ps = connect.conn.prepareStatement(sql);
			//Executa a instrução SQL
			ps.execute();
			System.out.println("Users created");

		} catch (Exception e) {
			//TODO: handle exception
			System.out.println(e);

		}


	}
}
