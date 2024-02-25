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
import org.apache.commons.text.StringEscapeUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


@WebServlet(name = "TaxController", value = "/tax-servlet")
public class TaxController extends HttpServlet {

    public void init() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        response.setHeader("Content-Security-Policy", "script-src 'self'");

        // Get the error message that will be shown to user in case of errors.
        // And initializing it will a default message
        String errorMessage = "";

        // Get the success message that will be shown to user in case of successful operations.
        // And initializing it will a default message
        String successMessage = "";

        boolean isEpfEtf = false;

        // Get the basic salary input from the user
        double basicSalary = 0.0;
        try {
            // Escape the HTML characters and get the input from the user
            basicSalary = Double.parseDouble(StringEscapeUtils.escapeHtml4(request.getParameter("salary")));
            if (basicSalary <= 0 || basicSalary > Double.MAX_VALUE) {
                errorMessage += "Please enter a valid Salary value (greater than 0 and less than or equal to " + Double.MAX_VALUE + ")!\n";
            }else if(String.valueOf(basicSalary).matches(String.valueOf(Pattern.compile("[a-zA-Z]")))){
                errorMessage += "Please enter a valid Salary value (numeric)!\n";
            }
        } catch (NumberFormatException e) {
            errorMessage += "Please enter a valid Salary value!\n";
        }

        // Escape the HTML characters and get the input from the user
        // Get whether epf/etf calculation is required by the user
        String isEpfEtfParam = StringEscapeUtils.escapeHtml4(request.getParameter("isepfetf"));

        // Validations for the input
        if (isEpfEtfParam != null && isEpfEtfParam.equals("on")) {
            isEpfEtf = true;
        }
        // Epf and Etf check slider should only provide 1 or 0 as values
        if (isEpfEtf) {
            errorMessage += "Please select a valid value for the check slider for ETF/EPF calculation\n";

        }

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
            // Calculate the EPF and ETF
            taxService.calculateEPFandETF();
            employeeEpf = taxService.getEmployeeEPFContribution();
            employerEpf = taxService.getEmployerEPFContribution();
            employerEtf = taxService.getEmployerETFContribution();
        }

        if(errorMessage.equals("")){
            // Insert the tax brackets into the database (Table: taxservice) as a record
            //Using the DAO pattern, insert the tax brackets into the database
            TaxHistoryDao taxHistoryDao = new TaxHistoryDao();
            try{
                if (taxHistoryDao.insertTaxBrackets(basicSalary, taxService.getTotalTax(), employeeEpf, employerEpf, employerEtf)) {
                    // If the insertion is successful show the success message to the user
                    successMessage = "Tax brackets inserted successfully!\n";
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
                    errorMessage = "Error occurred while inserting tax brackets!\n";
                    request.setAttribute("errorMessage", errorMessage);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                }
            }catch (Exception e){
                errorMessage = "Server Error ( 500 )!\n";
                request.setAttribute("errorMessage", errorMessage);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/error.jsp");
                dispatcher.forward(request, response);
            }

        }else{
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void destroy() {
    }
}