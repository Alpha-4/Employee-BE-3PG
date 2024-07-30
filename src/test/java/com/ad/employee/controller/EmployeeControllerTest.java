package com.ad.employee.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ad.employee.entity.Employee;
import com.ad.employee.repo.EmployeeRepository;
import com.ad.employee.service.EmployeeService;
import com.ad.employee.utils.Department;
import com.ad.employee.utils.EmpStatus;
import com.ad.employee.utils.EmployeeDTO;
import com.ad.employee.utils.Gender;
import com.ad.employee.utils.Location;
import com.ad.employee.utils.Position;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

	  @Autowired
	  private MockMvc mockMvc;

	  @Autowired
	  private ObjectMapper objectMapper;
	  
	  @MockBean
	  private EmployeeRepository repo;
	  
	  @MockBean
	  private EmployeeService service;
	  
	  
	  @Test
	  void testAddNewEmployee() throws Exception {
		    EmployeeDTO dto = new EmployeeDTO(1L,"John", "Doe", "E001", LocalDate.of(1990, 1, 1), LocalDate.of(2020, 1, 1), "john.doe@example.com", "Administration", "India", "Contractual", "Manager", "Male");
	
		    mockMvc.perform(post("/employee").contentType(MediaType.APPLICATION_JSON)
		        .content(objectMapper.writeValueAsString(dto)))
		        .andExpect(status().isCreated());
	  }
	  
	  @Test
	  public void testGetAllEmployees() throws Exception {
			Employee emp = new Employee("John", "Doe", "E001", LocalDate.of(1990, 1, 1), LocalDate.of(2020, 1, 1), "john.doe@example.com", Department.TECH, Location.IND, EmpStatus.CON,Position.MA,Gender.MALE);
		    List<Employee> employees = Arrays.asList(emp);
	
		    Mockito.when(service.getAllEmployees()).thenReturn(employees);
	
		    mockMvc.perform(get("/employee"))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$", Matchers.hasSize(1)))
		        .andExpect(jsonPath("$[0].firstName", Matchers.is("John")));
	  }

	  @Test
	  public void testGetEmployeeById() throws Exception {
		  	Employee emp = new Employee("John", "Doe", "E001", LocalDate.of(1990, 1, 1), LocalDate.of(2020, 1, 1), "john.doe@example.com", Department.TECH, Location.IND, EmpStatus.CON,Position.MA,Gender.MALE);
		  	emp.setId(1L);
		  	
		    Mockito.when(service.getEmployeeById(1L)).thenReturn(emp);

		    mockMvc.perform(get("/employee/1"))
		        .andExpect(status().isOk())
		        .andExpect(jsonPath("$.id", Matchers.is(1)))
		        .andExpect(jsonPath("$.firstName", Matchers.is("John")));
	  }

}
