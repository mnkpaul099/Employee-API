package com.employee.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Manager {

	@Id
	private Long managerEmpId;
	private String managerName;
	private String email;
	
	public Manager(Long managerEmpId, String managerName, String email) {
		super();
		this.managerEmpId = managerEmpId;
		this.managerName = managerName;
		this.email = email;
	}
	
}