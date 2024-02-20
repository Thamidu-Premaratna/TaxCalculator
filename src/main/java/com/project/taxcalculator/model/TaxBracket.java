package com.project.taxcalculator.model;

public class TaxBracket {
    private double bracketSalaryRange;
    private double taxRate;
    private double tax;

    public TaxBracket() {
    }

    public double getBracketSalaryRange() {
        return bracketSalaryRange;
    }

    public void setBracketSalaryRange(double bracketSalaryRange) {
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
