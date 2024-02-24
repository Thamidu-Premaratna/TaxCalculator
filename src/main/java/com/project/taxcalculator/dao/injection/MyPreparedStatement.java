package com.project.taxcalculator.dao.injection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

// Base Handler - Exception
abstract class BaseExceptionHandler {
    protected BaseExceptionHandler successor;

    public void setSuccessor(BaseExceptionHandler successor) {
        this.successor = successor;
    }

    public abstract void handleException(SQLException e);
}

// Concrete Handler 1 - Exception
class PrintStackTraceHandler extends BaseExceptionHandler {
    @Override
    public void handleException(SQLException e) {
        e.printStackTrace();
    }
}

// Concrete Handler 2 - Exception
class LogToConsoleHandler extends BaseExceptionHandler {
    @Override
    public void handleException(SQLException e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
}

public class MyPreparedStatement {
    //replace DB URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASS = "password";
    private BaseExceptionHandler exceptionHandler;

    public MyPreparedStatement() {
        // Chain the handlers
        this.exceptionHandler = new PrintStackTraceHandler();
        LogToConsoleHandler logHandler = new LogToConsoleHandler();
        this.exceptionHandler.setSuccessor(logHandler);
    }


    public void insertData(String firstname, String lastname,String email, double salary) {
        String insertQuery = "INSERT INTO users (firstname,lastname,email,salary) VALUES (?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             MyPreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {

            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, email);
            preparedStatement.setDouble(4, salary);

            preparedStatement.executeUpdate();
            System.out.println("Data inserted successfully.");

        } catch (SQLException e) {
            // Handle exception using Chain of Responsibility
            exceptionHandler.handleException(e);
        }
    }

}
