package com.employee.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "taskId")
public class Task {

	@Id
	private int taskId;
	private String description;
	@JsonIdentityReference
	@JsonIgnore
	@ManyToMany(targetEntity = Employee.class, mappedBy = "tasks", 
		cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	private List<Employee> employee;
	
	public Task(int taskId, String description) {
		super();
		this.taskId = taskId;
		this.description = description;
	}
}