package com.employee.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.dto.EmployeeDetailsResponse;
import com.employee.model.Employee;

@Repository
@Transactional
public interface EmployeeDao extends JpaRepository<Employee, Long> {

	@Query("select new com.employee.dto.EmployeeDetailsResponse(e.employeeId,e.employeeName,"
			+ "e.designation,e.emailId,t.description) from Employee e JOIN e.tasks t")
	public List<EmployeeDetailsResponse> findAllEmployeeDetails();

}
