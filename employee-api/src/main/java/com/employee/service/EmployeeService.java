package com.employee.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.employee.dto.EmployeeDetailsResponse;
import com.employee.exceptions.EmployeeNotFoundException;
import com.employee.exceptions.ExistingEmployeeException;
import com.employee.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployeeService();

	Employee addEmployeeService(Employee employee) throws ExistingEmployeeException;

	Employee updateEmployeeService(Employee employee) throws EmployeeNotFoundException;

	//String deleteEmployeeService(long employeeId) throws EmployeeNotFoundException;

	Employee getEmployee(long employeeId) throws EmployeeNotFoundException;

	List<EmployeeDetailsResponse> findAllEmployeeService();

	ResponseEntity<Object> deleteEmployeeService(long employeeId) throws EmployeeNotFoundException;

}