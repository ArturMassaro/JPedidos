package com.github.jpedidos.database;

import java.sql.*;
import com.github.jpedidos.database.migrations.UserMigration;
import com.github.jpedidos.database.migrations.ProductsMigration;
import com.github.jpedidos.database.migrations.OrderMigration;
import com.github.jpedidos.database.migrations.OrderProductMigration;

public class MainMigration {
	public static void main() {
		UserMigration.main();
		ProductsMigration.main();
		OrderMigration.main();
		OrderProductMigration.main();
	}
}
