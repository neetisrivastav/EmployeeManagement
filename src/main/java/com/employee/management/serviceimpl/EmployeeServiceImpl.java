package com.employee.management.serviceimpl;

import com.employee.management.model.Employee;
import com.employee.management.repository.EmployeeRepository;
import com.employee.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public Employee saveEmployee(Employee student) {
		return employeeRepository.save(student);
	}

	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).get();
	}
	public Employee getEmployeeByName(String name) {
		return employeeRepository.findByFirstName(name);
	}

	public List<Employee> sortAllEmployeeByName(String order)
	{
		if(order.equals("asc"))
		return employeeRepository.findAllByOrderByFirstNameAsc();
		else if(order.equals("desc"))
			return employeeRepository.findAllByOrderByFirstNameDesc();
		return null;
	}
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}


}
