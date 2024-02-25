package com.project.taxcalculator.model;

public class TaxBracket {
    private String bracketSalaryRange;
    private double taxRate;
    private double tax;

    public TaxBracket(String bracketSalaryRange, double taxRate, double tax) {
        this.bracketSalaryRange = bracketSalaryRange;
        this.taxRate = taxRate;
        this.tax = tax;
    }

    public String getBracketSalaryRange() {
        return bracketSalaryRange;
    }

    public void setBracketSalaryRange(String bracketSalaryRange) {
        this.bracketSalaryRange = bracketSalaryRange;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
}
