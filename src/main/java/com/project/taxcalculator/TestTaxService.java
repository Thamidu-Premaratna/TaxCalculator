package com.project.taxcalculator;

import com.project.taxcalculator.service.TaxService;

public class TestTaxService {
    public static void main(String[] args) {
        // Test the TaxService class
        TaxService taxService = new TaxService(130000);
        taxService.printTaxBrackets();
        taxService.calculateEPFandETF();
        System.out.println("Employee EPF: " + taxService.getEmployeeEPFContribution());
        System.out.println("Employer EPF: " + taxService.getEmployerEPFContribution());
        System.out.println("Employer ETF: " + taxService.getEmployerETFContribution());
    }
}
