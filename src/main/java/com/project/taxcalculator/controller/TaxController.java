package com.project.taxcalculator.controller;

import com.project.taxcalculator.dao.TaxHistoryDao;
import com.project.taxcalculator.model.TaxBracket;
import com.project.taxcalculator.service.TaxService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


@WebServlet(name = "TaxController", value = "/tax-servlet")
public class TaxController extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        // Get the error message that will be shown to user in case of errors.
        // And initializing it will a default message
        String errorMessage = "";

        // Get the success message that will be shown to user in case of successful operations.
        // And initializing it will a default message
        String successMessage = "";

        boolean isEpfEtf = false;

        // Get the basic salary input from the user
        double basicSalary = Double.parseDouble(request.getParameter("salary"));
        // Get whether epf/etf calculation is required by the user
        String isEpfEtfParam = request.getParameter("isepfetf");
        if (isEpfEtfParam != null && isEpfEtfParam.equals("on")) {
            isEpfEtf = true;
        }

        // Validations for the input
        // Epf and Etf check slider should only provide 1 or 0 as values
//        if (isEpfEtf) {
//            errorMessage += "Please select a valid value for the check slider for ETF/EPF calculation";
//
//        }
//        if (basicSalary <= 0) {
//            errorMessage += "Please enter a valid Salary value (non-zero and non-negative)!";
//        } else if (String.valueOf(basicSalary).matches(String.valueOf(Pattern.compile("[a-zA-Z]")))) { // Check if non numerics are present
//            errorMessage += "Please enter a valid Salary value (numeric)!";
//        }
        // SQL injection stopping

        // HTML sanitation, escaping etc

        // Create Tax service instance to calculate the tax values according to the brackets
        TaxService taxService = new TaxService(basicSalary);

        // Get the Tax brackets as a List in order to show them in a tabular format in view dynamically
        List<TaxBracket> taxBrackets = new ArrayList<>();
        taxBrackets = taxService.getTaxBracketList();

        // Setting inital values for the epf and etf
        double employeeEpf = 0.0;
        double employerEpf = 0.0;
        double employerEtf = 0.0;

        // If the user has selected to calculate the epf and etf
        if (isEpfEtf) {
            System.out.println("EPF and ETF calculation is available!");
            // Calculate the EPF and ETF
            taxService.calculateEPFandETF();
            employeeEpf = taxService.getEmployeeEPFContribution();
            employerEpf = taxService.getEmployerEPFContribution();
            employerEtf = taxService.getEmployerETFContribution();
        }

        // Insert the tax brackets into the database (Table: taxservice) as a record
        //Using the DAO pattern, insert the tax brackets into the database
        TaxHistoryDao taxHistoryDao = new TaxHistoryDao();
        if (taxHistoryDao.insertTaxBrackets(basicSalary, taxService.getTotalTax(), employeeEpf, employerEpf, employerEtf)) {
            // If the insertion is successful show the success message to the user
            System.out.println("Tax brackets inserted successfully!");
            successMessage = "Tax brackets inserted successfully!";
            request.setAttribute("successMessage", successMessage);
            request.setAttribute("taxbrackets", taxBrackets);
            request.setAttribute("totalTax", taxService.getTotalTax());
            request.setAttribute("takeHomeSalary", taxService.getTakeHomeSalary());
            request.setAttribute("employeeEpf", employeeEpf);
            request.setAttribute("employerEpf", employerEpf);
            request.setAttribute("employerEtf", employerEtf);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        } else {
            // If the insertion is not successful show the error message to the user
            errorMessage = "Error occurred while inserting tax brackets!";
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }

        if(!errorMessage.equals("")){
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void destroy() {
    }
}