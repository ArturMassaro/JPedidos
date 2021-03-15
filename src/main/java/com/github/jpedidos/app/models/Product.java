package com.github.jpedidos.app.models;


import java.sql.*;
import com.github.jpedidos.database.ConexaoBD;
import com.github.jpedidos.app.services.CurrentDateInString;
import java.util.*;

public class Product {
  public int id;
  public String name;
  public String description;
  public double price;
  public int qtd;
  public String created_at;
  public String updated_at;


  public static Product find(int id) throws SQLException {
    ConexaoBD connect = new ConexaoBD();
    Product findedProduct = new Product();
    
    String sql = "SELECT * FROM products WHERE id = ? limit 1";
      
    PreparedStatement ps = connect.conn.prepareStatement(sql);
    ps.setInt(1, id);

    ResultSet returnData = ps.executeQuery();
    
    
    if (returnData.next()) {
      findedProduct.id = returnData.getInt("id");
      findedProduct.name = returnData.getString("name");
      findedProduct.description = returnData.getString("description");
      findedProduct.price = returnData.getDouble("price");
      findedProduct.qtd = returnData.getInt("qtd");
      findedProduct.created_at = returnData.getString("created_at");
      findedProduct.updated_at = returnData.getString("updated_at");
    }
    return findedProduct;
  }

  public static List<Product> list() throws SQLException {
    ConexaoBD connect = new ConexaoBD();
    
    String sql = "SELECT * FROM products";
      
    PreparedStatement ps = connect.conn.prepareStatement(sql);

    ResultSet returnData = ps.executeQuery();
    
    List<Product> findedProducts = new ArrayList<Product>();
    while (returnData.next()) {
      Product findedProduct = new Product();

      findedProduct.id = returnData.getInt("id");
      findedProduct.name = returnData.getString("name");
      findedProduct.description = returnData.getString("description");
      findedProduct.price = returnData.getDouble("price");
      findedProduct.qtd = returnData.getInt("qtd");
      findedProduct.created_at = returnData.getString("created_at");
      findedProduct.updated_at = returnData.getString("updated_at");
      findedProducts.add(findedProduct);
    }
    return findedProducts;
  }

  public static void create(Product productToCreate) throws SQLException {
   ConexaoBD connect = new ConexaoBD();
   
   CurrentDateInString currentDateInString = new CurrentDateInString();
   
   String sql = "INSERT INTO products (name, description, price, qtd, created_at) values (?,?,?,?,?)";
     
   PreparedStatement ps = connect.conn.prepareStatement(sql);
   ps.setString(1, productToCreate.name);
   ps.setString(2, productToCreate.description);
   ps.setDouble(3, productToCreate.price);
   ps.setInt(4, productToCreate.qtd);
   ps.setString(5, currentDateInString.execute());

   ps.executeUpdate();

  }

  public static void update(Product productToUpdate) throws SQLException {
   ConexaoBD connect = new ConexaoBD();
   
   CurrentDateInString currentDateInString = new CurrentDateInString();
   
   String sql = "UPDATE products SET name=?, description=?, price=?, qtd=?, updated_at=? WHERE id=?";
     
   PreparedStatement ps = connect.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
   ps.setString(1, productToUpdate.name);
   ps.setString(2, productToUpdate.description);
   ps.setDouble(3, productToUpdate.price);
   ps.setInt(4, productToUpdate.qtd);
   ps.setString(5, currentDateInString.execute());
   ps.setInt(6, productToUpdate.id);

   ps.executeUpdate();

   ResultSet returnData = ps.getGeneratedKeys();
   
   if (returnData.next()) {
     System.out.println(returnData.getInt(1));
   }
  }

  public void delete(Product productToDelete) throws SQLException {
    ConexaoBD connect = new ConexaoBD();
    
    String sql = "DELETE FROM products WHERE name = ?";
     
    PreparedStatement ps = connect.conn.prepareStatement(sql);
    ps.setString(1, productToDelete.name);
  
    ps.executeUpdate();
  }
    

}