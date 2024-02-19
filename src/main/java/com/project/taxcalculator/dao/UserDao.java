package com.project.taxcalculator.dao;

import com.project.taxcalculator.util.DatabaseConnection;

import java.sql.Connection;

public class UserDao {
    private Connection connection = null;

    public UserDao(Connection connection) {
        this.connection = DatabaseConnection.getConnection();
    }
}
