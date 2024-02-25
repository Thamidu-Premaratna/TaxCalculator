package com.project.taxcalculator.dao;

import com.project.taxcalculator.model.TaxHistory;
import com.project.taxcalculator.model.User;
import com.project.taxcalculator.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaxHistoryDao {
    // Insert the tax brackets into the database (Table: taxservice) as a record
    public boolean insertTaxBrackets(int userId, double grossSalary, double taxValue, double employeeEpf, double employerEpf, double employerEtf) throws SQLException, Exception{
        // Insert the tax brackets into the database
        TaxHistory taxHistory = new TaxHistory(grossSalary, taxValue, employeeEpf, employerEpf, employerEtf);

        // Using the DAO pattern, insert the tax brackets into the database
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO taxhistory (grosssalary, taxvalue, userId, employee_epf,employer_epf, employer_etf) VALUES (?, ?, ?, ?,?,?)");
            preparedStatement.setDouble(1, taxHistory.getGrosssalary());
            preparedStatement.setDouble(2, taxHistory.getTaxvalue());
            preparedStatement.setInt(3, userId);
            preparedStatement.setDouble(4, taxHistory.getEmployeeEpf());
            preparedStatement.setDouble(5, taxHistory.getEmployerEpf());
            preparedStatement.setDouble(6, taxHistory.getEmployerEtf());
            int value = preparedStatement.executeUpdate();
            if (value > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new SQLException("Error occurred while inserting tax brackets!" );
        }catch (Exception e){
            throw new Exception("Error occurred!");
        }
        return false;
    }

    // Get the Tax brackets as a List in order to show them in a tabular format in view dynamically
    public ResultSet getTaxBrackets() throws SQLException, Exception{
        // Get the tax brackets from the database
        ResultSet resultSet = null;
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM AllTaxHistory");
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new SQLException("Error occurred while getting tax brackets!");
        }catch (Exception e){
            throw new Exception("Error occurred!");
        }
        return resultSet;
    }

    // Get all the tax brackets for a specific user
    public ResultSet getTaxBracketsByUserId(int userId) throws SQLException, Exception{
        // Get the tax brackets from the database
        ResultSet resultSet = null;
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM taxhistory WHERE userId = ?");
            preparedStatement.setInt(1, userId);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new SQLException("Error occurred while getting tax brackets!");
        }catch (Exception e){
            throw new Exception("Error occurred!");
        }
        return resultSet;
    }
}
