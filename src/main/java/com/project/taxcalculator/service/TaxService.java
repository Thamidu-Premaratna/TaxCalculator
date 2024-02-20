package com.project.taxcalculator.service;

import com.project.taxcalculator.model.TaxBrackets;

import java.util.List;

// Logic implementation
public class TaxService {

    private Double basicsalary;
    private Double taxvalue;
    private List<TaxBrackets> taxbrackets = null;

    public List<TaxBrackets> getTaxBrackets(){

        return taxbrackets;
    }
}
