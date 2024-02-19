package com.project.taxcalculator.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlserver://taxservicefinalproject2024.database.windows.net:1433;database=taxservice";
    private static final String USER = "taxserviceadmin@taxservicefinalproject2024";
    private static final String PASSWORD = "TaxService@2024";
    private static Connection connection = null;

    // Return new connection or return existing database connection
    public static Connection getConnection() {
        try{
            if(!connection.isClosed() || connection != null){
                return connection;
            }else{
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }


        return connection;
    }

    // Close the database connection
    public static void closeConnection() throws SQLException {
        if(!connection.isClosed() || connection != null){
            connection.close();
        }
    }
}
