package com.project.taxcalculator.service;

import com.project.taxcalculator.model.TaxBracket;

import java.util.ArrayList;
import java.util.List;

public class TaxService {

    // Define tax brackets and rates
    private final double[][] brackets = {
            {100000.0, 0.0},
            {141667.0, 0.06},
            {183333.0, 0.12},
            {225000.0, 0.18},
            {266667.0, 0.24},
            {308334.0, 0.30},
            {Double.MAX_VALUE, 0.36}
    };
    private double basicSalary;
    private List<TaxBracket> taxBrackets;

    public TaxService(double basicSalary) {
        this.basicSalary = basicSalary;
        // Initialize the tax brackets
        initTaxBrackets();
    }

    // Get the tax brackets for the respective salary range
    public void initTaxBrackets() {
        taxBrackets = new ArrayList<>();
        double remaining = basicSalary - 100000.0; // Relief salary

        if (remaining > 0) {
            // Add the first tax bracket
            taxBrackets.add(new TaxBracket(
                    "Up to Rs. 100000", 0.0, 0.0
            ));
            // Calculate the number of possible divisions by 41667 and the remainder
            int divisions = (int) (remaining / 41667);
            double remainder = remaining % 41667;

            // If divisions are more than 6, add the excess to the remainder
            if (divisions > 5) {
                int excessDivisions = divisions - 5;
                remainder += excessDivisions * 41667;
                divisions = 5;
            }

            // Calculate the tax for each bracket
            for (int i = 0; i < divisions; i++) {
                double upperLimit = 100000.0 + (i + 1) * 41667;
                double taxRate = brackets[i+1][1];

                // Calculate the tax for the bracket (Round to the nearest integer)
                double taxAmount = 41667 * taxRate;
                double tax = Math.floor(taxAmount + 0.5);

                taxBrackets.add(new TaxBracket(
                        formatBracketRange(upperLimit), taxRate, tax
                ));
            }
            // Calculate the tax for the remainder
            if (remainder > 0) {
                double upperLimit = 100000.0 + (divisions + 1) * 41667;
                double taxRate = brackets[divisions+1][1];

                // Calculate the tax for the bracket (Round to the nearest integer)
                double taxAmount = remainder * taxRate;
                double tax = Math.floor(taxAmount + 0.5);

                taxBrackets.add(new TaxBracket(
                        formatBracketRange(upperLimit), taxRate, tax
                ));
            }
        }else {
            // The salary is less than 100000
            taxBrackets.add(new TaxBracket(
                    "Up to 100000", 0.0, 0.0
            ));
        }
    }

    // Get the tax brackets ArrayList
    public List<TaxBracket> getTaxBracketList() {
        return taxBrackets;
    }

    // Get the total tax value
    public double getTotalTax() {
        double totalTax = 0.0;
        for (TaxBracket bracket : taxBrackets) {
            totalTax += bracket.getTax();
        }
        return totalTax;
    }

    // Get the take home salary
    public double getTakeHomeSalary() {
        return basicSalary - getTotalTax();
    }

    // Print the tax brackets and total tax
    public void printTaxBrackets() {
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Tax Brackets:");
        for (TaxBracket bracket : taxBrackets) {
            System.out.println(bracket.getBracketSalaryRange() + " - Tax rate : " + bracket.getTaxRate() + " - Tax value :  " + bracket.getTax());
        }
        System.out.println("Total Tax: " + getTotalTax());
        System.out.println("Take home salary: " + getTakeHomeSalary());
    }

    // Format the bracket range string
    private String formatBracketRange(double upperLimit) {
        if (upperLimit > 308335.0) {
            return "Above Rs. 308334";
        }
        return "Next Rs. 41667 till " + (int) upperLimit;

    }

    // Epf and Etf calculation
    // Define EPF and ETF contribution rates
    private final double employeeEPF = 0.08;
    private final double employerEPF = 0.12;
    private final double employerETF = 0.03;

    double employeeEPFContribution = 0.0;
    double employerEPFContribution = 0.0;
    double employerETFContribution = 0.0;

    public void calculateEPFandETF() {
        double totalEPF = 0.0;
        double totalETF = 0.0;

        // Calculate employee EPF contribution
        employeeEPFContribution = this.basicSalary * employeeEPF;
        totalEPF += employeeEPFContribution;

        // Calculate employer EPF contribution
        employerEPFContribution = this.basicSalary * employerEPF;
        totalEPF += employerEPFContribution;

        // Calculate employer ETF contribution
        employerETFContribution = this.basicSalary * employerETF;
        totalETF += employerETFContribution;
    }

    public double getEmployeeEPFContribution() {
        return employeeEPFContribution;
    }

    public double getEmployerEPFContribution() {
        return employerEPFContribution;
    }

    public double getEmployerETFContribution() {
        return employerETFContribution;
    }

}
