package com.github.jpedidos.app.models;


import java.sql.*;
import com.github.jpedidos.database.ConexaoBD;
import com.github.jpedidos.app.services.CurrentDateInString;
import java.util.*;

public class User {
  public int id;
  public String name;
  public String email;
  public String login;
  public String password;
  public String access_type;
  public String created_at;
  public String updated_at;


  public static User find(int id) throws SQLException {
    ConexaoBD connect = new ConexaoBD();
    User findedUser = new User();
    
    String sql = "SELECT * FROM users WHERE id = ? limit 1";
      
    PreparedStatement ps = connect.conn.prepareStatement(sql);
    ps.setInt(1, id);

    ResultSet returnData = ps.executeQuery();
    
    
    if (returnData.next()) {
      findedUser.id = returnData.getInt("id");
      findedUser.name = returnData.getString("name");
      findedUser.login = returnData.getString("login");
      findedUser.access_type = returnData.getString("access_type");
      findedUser.created_at = returnData.getString("created_at");
      findedUser.updated_at = returnData.getString("updated_at");
    }
    return findedUser;
  }

  public static List<User> list() throws SQLException {
    ConexaoBD connect = new ConexaoBD();
    
    String sql = "SELECT * FROM users";
      
    PreparedStatement ps = connect.conn.prepareStatement(sql);

    ResultSet returnData = ps.executeQuery();
    
    List<User> findedUsers = new ArrayList<User>();
    while (returnData.next()) {
      User findedUser = new User();

      findedUser.id = returnData.getInt("id");
      findedUser.name = returnData.getString("name");
      findedUser.login = returnData.getString("login");
      findedUser.access_type = returnData.getString("access_type");
      findedUser.created_at = returnData.getString("created_at");
      findedUser.updated_at = returnData.getString("updated_at");
      findedUsers.add(findedUser);
    }
    return findedUsers;
  }

  public static void create(User userToCreate) throws SQLException {
   ConexaoBD connect = new ConexaoBD();
   
   CurrentDateInString currentDateInString = new CurrentDateInString();
   
   String sql = "INSERT INTO users (name, email, login, password, access_type, created_at) values (?,?,?,?,?,?)";
     
   PreparedStatement ps = connect.conn.prepareStatement(sql);
   ps.setString(1, userToCreate.name);
   ps.setString(2, userToCreate.email);
   ps.setString(3, userToCreate.login);
   ps.setString(4, userToCreate.password);
   ps.setString(5, userToCreate.access_type);
   ps.setString(6, currentDateInString.execute());

   ps.executeUpdate();
  }

  public static void update(User userToUpdate) throws SQLException {
   ConexaoBD connect = new ConexaoBD();
   
   CurrentDateInString currentDateInString = new CurrentDateInString();
   
   String sql = "UPDATE users SET name=?, email=?, login=?, password=?, access_type=?, updated_at=? WHERE id=?";
     
   PreparedStatement ps = connect.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
   ps.setString(1, userToUpdate.name);
   ps.setString(2, userToUpdate.email);
   ps.setString(3, userToUpdate.login);
   ps.setString(4, userToUpdate.password);
   ps.setString(5, userToUpdate.access_type);
   ps.setString(6, currentDateInString.execute());
   ps.setInt(7, userToUpdate.id);

   ps.executeUpdate();

   ResultSet returnData = ps.getGeneratedKeys();
   
   if (returnData.next()) {
     System.out.println(returnData.getInt(1));
   }
  }

  public void delete(User userToDelete) throws SQLException {
    ConexaoBD connect = new ConexaoBD();
    
    String sql = "DELETE FROM users WHERE name = ?";
     
    PreparedStatement ps = connect.conn.prepareStatement(sql);
    ps.setString(1, userToDelete.name);
  
    ps.executeUpdate();
  }
    

}