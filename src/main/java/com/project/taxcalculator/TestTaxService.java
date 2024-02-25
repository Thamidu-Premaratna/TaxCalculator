package com.project.taxcalculator;

import com.project.taxcalculator.service.TaxService;

public class TestTaxService {
    public static void main(String[] args) {
        // Test the TaxService class
        TaxService taxService = new TaxService(500000);
        taxService.printTaxBrackets();
    }
}
