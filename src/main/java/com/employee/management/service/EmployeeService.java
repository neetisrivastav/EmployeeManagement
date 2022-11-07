package com.employee.management.service;

import com.employee.management.model.Employee;

import java.util.List;


public interface EmployeeService {
	List<Employee> getAllEmployee();

	Employee saveEmployee(Employee employee);

	Employee getEmployeeById(Long id);

	void deleteEmployeeById(Long id);

	 Employee getEmployeeByName(String name);

	public List<Employee> sortAllEmployeeByName(String order);
}
