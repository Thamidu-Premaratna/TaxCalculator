package com.project.taxcalculator.service;

import com.project.taxcalculator.model.TaxBracket;

import java.util.ArrayList;
import java.util.List;

// Logic implementation
public class TaxService {

    private double basicSalary;
    private double taxTotalValue;
    private List<TaxBracket> taxBrackets = null;
    private final double[] SALARY_BRACKETS = {100000, 141667, 183333, 225000, 266667, 308333};
    private final double[] TAX_RATES = {0, 0.06, 0.12, 0.18, 0.24, 0.30, 0.36};

    public TaxService(double basicSalary){
        this.basicSalary = basicSalary;
    }

    public List<TaxBracket> getTaxBrackets(){

        taxBrackets = new ArrayList<>();
        // SALARY_BRACKETS[0] is the relief salary,
        // so we reduce this amount from whatever the users basic salary is to
        // get the extra salary amount to which we need to apply taxes to

        if(this.basicSalary > SALARY_BRACKETS[0]){
            double remainingSalary = this.basicSalary - SALARY_BRACKETS[0];

            for (int i = 0; i < SALARY_BRACKETS.length; i++) {
                double bracketSalary = Math.min(remainingSalary, SALARY_BRACKETS[i]);
                double tax = bracketSalary * TAX_RATES[i];

                // Create a new tax bracket instance to store the respective tax bracket details
                TaxBracket taxBracket = new TaxBracket();
                taxBracket.setBracketSalaryRange(bracketSalary);
                taxBracket.setTaxRate(TAX_RATES[i]);
                taxBracket.setTax(tax);

                // Add the tax bracket to the tax bracket Array list
                taxBrackets.add(taxBracket);
                remainingSalary -= bracketSalary;
            }

            if (remainingSalary > 0) {
                double tax = remainingSalary * TAX_RATES[TAX_RATES.length - 1];
                TaxBracket taxBracket = new TaxBracket();
                taxBracket.setBracketSalaryRange(remainingSalary);
                taxBracket.setTaxRate(TAX_RATES[TAX_RATES.length - 1]);
                taxBracket.setTax(tax);
                taxBrackets.add(taxBracket);
            }
        }else{
           taxBrackets = null;
        }

        return taxBrackets;
    }
}
