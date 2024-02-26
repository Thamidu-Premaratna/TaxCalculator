package com.project.taxcalculator.controller;

import com.project.taxcalculator.dao.TaxHistoryDao;
import com.project.taxcalculator.model.TaxHistory;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.text.StringEscapeUtils;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "TaxHistoryController", urlPatterns = {"/taxhistory-servlet"})
public class TaxHistoryController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setHeader("Content-Security-Policy", "script-src 'self'");

        // Get the error message that will be shown to user in case of errors.
        // And initializing it will a default message
        String errorMessage = "";

        // Store the user id from the session if a user is logged in
        String userId = StringEscapeUtils.escapeHtml4(request.getParameter("userid"));
        if(userId == null || userId.isEmpty()){
            errorMessage = "Please login to view your tax history!";
        }
        try {
            // Redirect to the tax history page
            // Get the tax brackets from the database using the DAO and store them in an ArrayList
            // Set the ArrayList as an attribute to the request
            TaxHistoryDao taxHistoryDao = new TaxHistoryDao();
            // Convert the result set to an ArrayList
            ResultSet resultSet = taxHistoryDao.getTaxBracketsByUserId(Integer.parseInt(userId));
            List<TaxHistory> taxHistory = new ArrayList<>();

            while (resultSet.next()) {
                double grosssalary = resultSet.getDouble("grosssalary");
                double taxvalue = resultSet.getDouble("taxvalue");
                double employeeEpf = resultSet.getDouble("employee_epf");
                double employerEpf = resultSet.getDouble("employer_epf");
                double employerEtf = resultSet.getDouble("employer_etf");

                TaxHistory taxHistoryItem = new TaxHistory(grosssalary, taxvalue, employeeEpf, employerEpf, employerEtf);
                taxHistory.add(taxHistoryItem);
            }
            if (taxHistory.isEmpty()) {
                errorMessage = "No tax history found!";
                request.setAttribute("errorMessage", errorMessage);
            }else{
                request.setAttribute("taxHistories", taxHistory);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("/taxhistory.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            errorMessage = "Server Error while getting results! Please try again later!";
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
        }
        if(!errorMessage.equals("")){
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/taxhistory.jsp");
            dispatcher.forward(request, response);
        }

    }
}
