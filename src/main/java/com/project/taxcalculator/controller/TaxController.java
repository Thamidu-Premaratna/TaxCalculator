package com.project.taxcalculator.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

import com.project.taxcalculator.model.TaxBracket;
import com.project.taxcalculator.service.TaxService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "TaxController", value = "/tax-servlet")
public class TaxController extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Get the error message that will be shown to user in case of errors.
        // And initializing it will a default message
        String errorMessage = "Unknown error occurred! Please contact admin!";

        //

        // Get the basic salary input from the user
        double basicSalary = Double.parseDouble(request.getParameter("salary"));
        // Get whether epf/etf calculation is required by the user
        boolean isEpfEtf = Boolean.parseBoolean(request.getParameter("isepfetf"));

        // Validations for the input
        // Epf and Etf check slider should only provide 1 or 0 as values
        if(isEpfEtf){
            errorMessage = "Please select a valid value for the check slider for ETF/EPF calculation";
        }
        if(basicSalary <= 0){
            errorMessage = "Please enter a valid Salary value (non-zero and non-negative)!";
        }else if(String.valueOf(basicSalary).matches(String.valueOf(Pattern.compile("[a-zA-Z]")))){ // Check if non numerics are present
            errorMessage = "Please enter a valid Salary value (numeric)!";
        }
        // SQL injection stopping

        // HTML sanitation, escaping etc

        // Create Tax service instance to calculate the tax values according to the brackets
        TaxService taxService = new TaxService(basicSalary);

        // Get the Tax brackets as a List in order to show them in a tabular format in view dynamically
        List<TaxBracket> taxBrackets = new ArrayList<>();


        // Send the response (tax bracket list) to the respective View (JSP) to be shown dynamically in a table
        request.setAttribute("taxbrackets", taxBrackets);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }

    public void destroy() {
    }
}