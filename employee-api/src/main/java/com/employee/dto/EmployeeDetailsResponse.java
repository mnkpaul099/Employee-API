package com.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDetailsResponse {

	private long employeeId;
	private String employeeName;
	private String designation;
	private String emailId;
	private String taskName;
}
