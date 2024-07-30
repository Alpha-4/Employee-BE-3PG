package com.ad.employee.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ad.employee.entity.Employee;
import com.ad.employee.repo.EmployeeRepository;
import com.ad.employee.utils.Department;
import com.ad.employee.utils.EmpStatus;
import com.ad.employee.utils.EmployeeDTO;
import com.ad.employee.utils.Gender;
import com.ad.employee.utils.Location;
import com.ad.employee.utils.Position;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository repo;
	
	Logger logger= LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	public static EmployeeDTO toDTO(Employee employee) {
		if(employee==null) {
			return null;
		}
		return new EmployeeDTO(employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmpCode(),
				employee.getDob(),
				employee.getDoj(),
				employee.getEmail(),
				employee.getDept().toString(),
				employee.getLocation().toString(),
				employee.getEmpStatus().toString(),
				employee.getPosition().toString(),
				employee.getGender().toString());
	}
	
	public static Employee toEntity(EmployeeDTO dto) {
		if(dto==null) {
			return null;
		}
		return new Employee(dto.getFirstName(), dto.getLastName(), dto.getEmpCode(), 
				dto.getDob(), dto.getDoj(),dto.getEmail() , Department.fromString(dto.getDept()), 
				Location.fromString(dto.getLocation()), EmpStatus.fromString(dto.getEmpStatus()), 
				Position.fromString(dto.getPosition()), Gender.fromString(dto.getGender()));
	}
	
	
	
	public EmployeeServiceImpl(EmployeeRepository repo) {
		this.repo=repo;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list= repo.findAll();
		return list;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		logger.info("Get employee by: "+id);
		Optional<Employee> emp=repo.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}
		
		logger.error("Employee with: "+id+" not found in the db");
		
		return null;
	}

	@Override
	public void deleteEmployee(Long id) {
		repo.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee updatedEmployee, Long id) {
		updatedEmployee.setId(id);
		updatedEmployee=repo.save(updatedEmployee);
		return updatedEmployee;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		Employee newEmployee=repo.save(employee);
		return newEmployee;
	}

}
