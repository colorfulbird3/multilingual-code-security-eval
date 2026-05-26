package com.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {

  public List<String> getUserList() throws SQLException {
    List<String> userList = new ArrayList<>();
    userList.add("user1");
    userList.add("user2");
    return userList;
  }


  public List<String> getUserList2() throws SQLException {
    List<String> userList = new ArrayList<>();
    userList.add("user1");
    userList.add("user2");
    return userList;
  }

  public String getRandomUser() throws SQLException {
    Connection connection = null;
    String[] usernames = {"user1", "user2", "user3"};
    try {
      connection = connectToDatabase("jdbc:mysql://localhost:3306/testdb", "root", "");
      PreparedStatement ps = connection.prepareStatement("SELECT username FROM users WHERE username =?");
      for (String username : usernames) {
        ps.setString(1, username);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
          return username;
        }
      }
    } finally {
      if (connection!= null) {
        connection.close();
      }
    }
    return null;
  }
}