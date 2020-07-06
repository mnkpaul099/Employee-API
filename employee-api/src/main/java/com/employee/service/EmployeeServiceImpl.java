package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.dto.EmployeeDetailsResponse;
import com.employee.exceptions.EmployeeNotFoundException;
import com.employee.exceptions.ExistingEmployeeException;
import com.employee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAllEmployeeService() {
		return employeeDao.findAll();
	}
	
	@Override
	public List<EmployeeDetailsResponse> findAllEmployeeService() {
		return employeeDao.findAllEmployeeDetails();
	}
	
	@Override
	public Employee addEmployeeService(Employee employee) throws ExistingEmployeeException {
		if (employeeDao.existsById(employee.getEmployeeId())) {
            throw new ExistingEmployeeException("Invalid Data!");
        }
		employeeDao.save(employee);
		return employee;
	}

	@Override
	public Employee updateEmployeeService(Employee employee) throws EmployeeNotFoundException {
		if (!employeeDao.existsById(employee.getEmployeeId())) {
            throw new EmployeeNotFoundException("Invalid data!");
        }
		employeeDao.save(employee);
		return employee;
	}

	/**
	@Override
	public String deleteEmployeeService(long employeeId) throws EmployeeNotFoundException {
        if (!employeeDao.existsById(employeeId)) {
            throw new EmployeeNotFoundException("Invalid data!");
        }
        //Employee employee = (Employee)employeeDao.findById(employeeId).get();
        employeeDao.deleteById(employeeId);
        return "employee deleted!";
	}**/

	@Override
	public Employee getEmployee(long employeeId) throws EmployeeNotFoundException {
		if (!employeeDao.existsById(employeeId)) {
            throw new EmployeeNotFoundException("Invalid data!");
        }
		return employeeDao.findById(employeeId).orElse(new Employee());
	}
	
	@Override
	public ResponseEntity<Object> deleteEmployeeService(long employeeId) throws EmployeeNotFoundException {
        if (employeeDao.findById(employeeId).isPresent()) {
        	if(employeeDao.getOne(employeeId).getTasks().size() == 0) {
        		employeeDao.deleteById(employeeId);
        		if (employeeDao.findById(employeeId).isPresent()) {
                    return ResponseEntity.unprocessableEntity().body("Failed to Delete the specified User");
        		} else return ResponseEntity.ok().body("Successfully deleted the specified user");
        	} else return ResponseEntity.badRequest().body("Failed to Delete the specified User");
        } else throw new EmployeeNotFoundException("Invalid Data!");
    }
	
}