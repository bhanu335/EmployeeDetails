package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.repository.EmployeeRepository;


@Service

public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	
	@Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
		
	}
	

}
