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
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
