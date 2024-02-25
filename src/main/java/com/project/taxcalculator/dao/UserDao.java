package com.project.taxcalculator.dao;

import com.project.taxcalculator.model.User;
import com.project.taxcalculator.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private Connection connection;

    public UserDao() {
        this.connection = DatabaseConnection.getConnection();
    }

    public User getUserById(int id) {
        User user = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
            }
            ps.close(); // Close PreparedStatement
            rs.close(); // Close ResultSet
        } catch (SQLException e) {
            e.printStackTrace(); // Handle this properly in your application
        }
        return user;
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        User user = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setFirstname(rs.getString("firstname"));
                user.setLastname(rs.getString("lastname"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
            }
            ps.close(); // Close PreparedStatement
            rs.close(); // Close ResultSet
        } catch (SQLException e) {
            e.printStackTrace(); // Handle this properly in your application
        }
        return user;
    }

    public void createUser(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users (firstname, lastname, username, password, email) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getEmail());

            ps.executeUpdate();
            ps.close(); // Close PreparedStatement
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
