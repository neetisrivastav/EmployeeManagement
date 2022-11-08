package com.employee.management.controller;

import com.employee.management.model.Employee;
import com.employee.management.model.Role;
import com.employee.management.model.User;
import com.employee.management.repository.RoleRepository;
import com.employee.management.repository.UserRepository;
import com.employee.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;
	@PostMapping("/save-update-employee")
	public String saveEmployee(@RequestBody Employee student) {
		employeeService.saveEmployee(student);
		return "successfully inserted or updated";
	}

	@GetMapping("/employee")
	public List<Employee> listEmployee() {
		return employeeService.getAllEmployee();
	}

	@PostMapping("/delete-employee/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "deleted successfully";
	}

//	@PostMapping("/employeeById/{id}")
//	public String employeeById(@PathVariable Long id) {
//		employeeService.getEmployeeById(id);
//		return "deleted successfully";
//	}

	@PostMapping("/employeeByName/{name}")
	public String employeeByName(@PathVariable String firstName) {
		employeeService.getEmployeeByName(firstName);
		return "deleted successfully";
	}
	@PostMapping("/sortAllEmployeeByName")
	public String sortAllEmployeeByName(@PathVariable String order) {
		employeeService.sortAllEmployeeByName(order);
		return "deleted successfully";
	}
	@PostMapping("/save-update-users")
	public String saveUser(@RequestBody User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		Optional<User> userUpdate = userRepository.findByUsername(user.getUsername());
		if(userUpdate.isPresent())
		{
			user.setId(userUpdate.get().getId());
		}
		userRepository.save(user);

		return "successfully inserted or updated user";
	}

	@PostMapping("/save-update-role")
	public String saveRole(@RequestBody Role role) {
		roleRepository.save(role);
		return "successfully inserted or updated role";
	}
}
