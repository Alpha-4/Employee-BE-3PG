package com.ad.employee.service;
import java.util.List;

import com.ad.employee.entity.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(Long id);
	
	void deleteEmployee(Long id);
	
	Employee updateEmployee(Employee employee,Long id);
	
	Employee addEmployee(Employee employee);
}
