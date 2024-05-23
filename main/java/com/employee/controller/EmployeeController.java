package com.employee.controller;

import org.springframework.http.ResponseEntity;
import com.employee.model.Employee;
import com.employee.service.EmployeeService;
import com.employee.service.TaxService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

     @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        try {
            Employee savedEmployee = employeeService.save(employee);
            return ResponseEntity.ok(savedEmployee);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null); 
        }
    }
     @GetMapping("/employees/{id}")
     public Employee getEmployeeTaxDeduction(@PathVariable Long id) {
        
         Employee employee = fetchEmployeeById(id);
         double taxAndCess = TaxService.calculateTaxAndCess(employee);
         employee.setSalary(employee.getSalary() - taxAndCess);

         return employee;
     }

	private Employee fetchEmployeeById(Long id) {
		return new Employee();
	}

}
