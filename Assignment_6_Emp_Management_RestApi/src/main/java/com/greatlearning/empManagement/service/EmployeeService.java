package com.greatlearning.empManagement.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.empManagement.entities.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(int id);

	void deleteById(int id);

	void save(Employee employee);
	
	List<Employee> search(String firstName);
	
	List<Employee> findAllCustomSorted(Direction direction);

}