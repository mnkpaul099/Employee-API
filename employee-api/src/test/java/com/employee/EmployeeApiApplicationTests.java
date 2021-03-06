package com.employee;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.employee.dao.EmployeeDao;
import com.employee.exceptions.ExistingEmployeeException;
import com.employee.model.Employee;
import com.employee.model.Manager;
import com.employee.model.Task;
import com.employee.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class EmployeeApiApplicationTests {

	@Autowired
	private EmployeeService employeeServiceTest;
	
	@MockBean
	private EmployeeDao employeeDaoTest;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetAllEmployee() {
		Task testTask1 = new Task(90001,"testTask1");
		Task testTask2 = new Task(90002,"testTask2");
		List<Task> listTask = new ArrayList<Task>();
		listTask.add(testTask1);
		listTask.add(testTask2);
		Manager testManager = new Manager((long) 999,"TestM","testM@test.com");
		Employee testEmp1 = new Employee((long) 9001,"testEmp1","testemp1@test.com","TD",testManager,listTask);
		Employee testEmp2 = new Employee((long) 9002,"testEmp2","testemp2@test.com","TD",testManager,listTask);
		
		when(employeeDaoTest.findAll()).thenReturn(Stream.of(testEmp1,testEmp2).collect(Collectors.toList()));
		
		assertEquals(2, employeeServiceTest.getAllEmployeeService().size());
	}
	/**
	@Test
	public void testGetEmployee() {
		Task testTask1 = new Task(90001,"testTask1");
		List<Task> listTask = new ArrayList<Task>();
		listTask.add(testTask1);
		Manager testManager = new Manager((long) 999,"TestM","testM@test.com");
		Employee testEmp1 = new Employee((long) 9001,"testEmp1","testemp1@test.com","TD",testManager,listTask);
		when(employeeDaoTest.findById((long) 9001)).thenReturn(Optional.of(Stream.of(testEmp1).collect(Collectors.toList())));
		assertEquals(1, employeeServiceTest.getAllEmployeeService().size());
	}
	**/
	@Test
	public void testAddEmployee() throws ExistingEmployeeException {
		Task testTask1 = new Task(90001,"testTask1");
		List<Task> listTask = new ArrayList<Task>();
		listTask.add(testTask1);
		Manager testManager = new Manager((long) 999,"TestM","testM@test.com");
		Employee testEmp1 = new Employee((long) 9001,"testEmp1","testemp1@test.com","TD",testManager,listTask);
		when(employeeDaoTest.save(testEmp1)).thenReturn(testEmp1);
		assertEquals(testEmp1, employeeServiceTest.addEmployeeService(testEmp1));
	}

}
