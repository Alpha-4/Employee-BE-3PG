package com.ad.employee.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ad.employee.entity.Employee;
import com.ad.employee.exceptions.CustomException;
import com.ad.employee.service.EmployeeService;
import com.ad.employee.service.EmployeeServiceImpl;
import com.ad.employee.utils.EmployeeDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {
	
	Logger logger= LoggerFactory.getLogger(EmployeeController.class);
	
	private EmployeeService service;
	
	public EmployeeController(EmployeeService service) {
		this.service=service;
	}
	
	
	@GetMapping
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
		logger.info("Executing getAllEmployees() method");
		List<EmployeeDTO> res=service.getAllEmployees().stream()
				.map(EmployeeServiceImpl::toDTO)
				.collect(Collectors.toList());
		logger.info("Returning back the getAllEmployees() method response");
		return new ResponseEntity<List<EmployeeDTO>>(res,HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable String id){
		EmployeeDTO res=null;
		logger.info("Executing getEmployeeById() method for id {}",id);
		try {
		 res=EmployeeServiceImpl.toDTO(service.getEmployeeById(Long.valueOf(id)));
		}catch(Exception e) {
			logger.error("Error while executing getEmployeeById(): {}",e);
			throw new CustomException(e.getMessage());
		}
		logger.info("Returning back the getAllEmployees() method response: {}",res);
		return new ResponseEntity<EmployeeDTO>(res,HttpStatus.OK);
	}
	
	
	@PostMapping
	public ResponseEntity<EmployeeDTO> addNewEmployee(@Valid @RequestBody EmployeeDTO dto){
		logger.info("Executing addNewEmployee() method");
		EmployeeDTO res=null;
		try {
			Employee newEmployee = EmployeeServiceImpl.toEntity(dto);
			res=EmployeeServiceImpl.toDTO(service.addEmployee(newEmployee));
		}
		catch(Exception ex) {
			logger.error("Error while executing addNewEmployee(): {}",ex);
			throw new CustomException(ex.getMessage());
		}
		logger.info("Returning back the addNewEmployee() method response: {}",res);
		return new ResponseEntity<EmployeeDTO>(res,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDTO> updateEmployeeById(@PathVariable String id, @Valid @RequestBody EmployeeDTO dto){
		Employee emp=EmployeeServiceImpl.toEntity(dto);
		Employee updated=service.updateEmployee(emp,Long.valueOf(id));
		EmployeeDTO updatedDTO=EmployeeServiceImpl.toDTO(updated);
		return new ResponseEntity<EmployeeDTO>(updatedDTO,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable String id){
		service.deleteEmployee(Long.valueOf(id));
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	

}
