package com.employee.management.repository;

import com.employee.management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

         Employee findByFirstName(String name);

         List<Employee> findAllByOrderByFirstNameAsc();

        List<Employee> findAllByOrderByFirstNameDesc();
	
}
