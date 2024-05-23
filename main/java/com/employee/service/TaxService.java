package com.employee.service;

import com.employee.model.Employee;

public class TaxService {
	public static double calculateTaxAndCess(Employee employee) {
        double taxAmount = 0;
        double cessAmount = 0;

        if (employee.getSalary() <= 250000) {
           
        } else if (employee.getSalary() > 250000 && employee.getSalary() <= 500000) {
            taxAmount = employee.getSalary() * 0.05; 
        } else if (employee.getSalary() > 500000 && employee.getSalary() <= 1000000) {
            taxAmount = 25000 + ((employee.getSalary() - 500000) * 0.1); 
        } else if (employee.getSalary() > 1000000) {
            taxAmount = 27500 + ((employee.getSalary() - 1000000) * 0.2); 
        }

        
        cessAmount = employee.getSalary() * 0.04;

        return taxAmount + cessAmount;
    }


}
