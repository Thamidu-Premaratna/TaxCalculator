package com.project.taxcalculator.model;

public class TaxHistory {
    private double grosssalary;
    private double taxvalue;
    private double employeeEpf;
    private double  employerEpf;
    private double  employerEtf;

    public TaxHistory(double grosssalary, double taxvalue, double employeeEpf, double employerEpf, double employerEtf) {
        this.grosssalary = grosssalary;
        this.taxvalue = taxvalue;
        this.employeeEpf = employeeEpf;
        this.employerEpf = employerEpf;
        this.employerEtf = employerEtf;
    }

    public double getGrosssalary() {
        return grosssalary;
    }

    public void setGrosssalary(double grosssalary) {
        this.grosssalary = grosssalary;
    }

    public double getTaxvalue() {
        return taxvalue;
    }

    public void setTaxvalue(double taxvalue) {
        this.taxvalue = taxvalue;
    }

    public double getEmployeeEpf() {
        return employeeEpf;
    }

    public void setEmployeeEpf(double employeeEpf) {
        this.employeeEpf = employeeEpf;
    }

    public double getEmployerEpf() {
        return employerEpf;
    }

    public void setEmployerEpf(double employerEpf) {
        this.employerEpf = employerEpf;
    }

    public double getEmployerEtf() {
        return employerEtf;
    }

    public void setEmployerEtf(double employerEtf) {
        this.employerEtf = employerEtf;
    }
}
