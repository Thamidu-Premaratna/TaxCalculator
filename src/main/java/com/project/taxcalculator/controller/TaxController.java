package com.project.taxcalculator.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.project.taxcalculator.model.TaxBrackets;
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
        String err_message = "Unknown error occurred! Please contact admin!";

        //

        // Get the basic salary input from the user
        double basicSalary = Double.parseDouble(request.getParameter("salary"));
        // Get whether epf/etf calculation is required by the user
        boolean isEpfEtf = Boolean.parseBoolean(request.getParameter("isepfetf"));

        // Validations for the input
        // Epf and Etf check slider should only provide 1 or 0 as values
        if(isEpfEtf){
            err_message = "Please select a valid value for the check slider for ETF/EPF calculation";
        }
        if(basicSalary <= 0){
            err_message = "Please enter a valid Salary value (non-zero and non-negative)!";
        }
        // SQL injection stopping

        // HTML sanitation, escaping etc

        // Create Tax service instance to calculate the tax values according to the brackets
        TaxService taxservice = new TaxService();

        // Get the Tax brackets as a List in order to show them in a tabular format in view dynamically
        List<TaxBrackets> taxbrackets = new ArrayList<>();


        // Send the response (tax bracket list) to the respective View (JSP) to be shown dynamically in a table
        request.setAttribute("taxbrackets", taxbrackets);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }

    public void destroy() {
    }
}