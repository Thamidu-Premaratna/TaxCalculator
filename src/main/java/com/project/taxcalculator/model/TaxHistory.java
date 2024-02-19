package com.project.taxcalculator.model;

public class TaxHistory {
    private Double grosssalary;
    private Double taxvalue;
    private Double epf;
    private Double  etf;

    public TaxHistory(Double grosssalary, Double taxvalue, Double epf, Double etf) {
        this.grosssalary = grosssalary;
        this.taxvalue = taxvalue;
        this.epf = epf;
        this.etf = etf;
    }

    public Double getGrosssalary() {
        return grosssalary;
    }

    public void setGrosssalary(Double grosssalary) {
        this.grosssalary = grosssalary;
    }

    public Double getTaxvalue() {
        return taxvalue;
    }

    public void setTaxvalue(Double taxvalue) {
        this.taxvalue = taxvalue;
    }

    public Double getEpf() {
        return epf;
    }

    public void setEpf(Double epf) {
        this.epf = epf;
    }

    public Double getEtf() {
        return etf;
    }

    public void setEtf(Double etf) {
        this.etf = etf;
    }
}
