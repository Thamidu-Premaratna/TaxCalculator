package com.project.taxcalculator.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlserver://taxservicefinalproject2024.database.windows.net:1433;database=taxservice;user=taxserviceadmin@taxservicefinalproject2024;password=TaxService@2024;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    private static Connection connection = null;

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // Return new connection or return existing database connection
    public static Connection getConnection() {
        try{
            if(connection != null){
                return connection;
            }else{
                connection = DriverManager.getConnection(URL);
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
