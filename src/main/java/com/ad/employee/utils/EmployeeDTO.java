package com.ad.employee.utils;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class EmployeeDTO {
	private Long id;

	@NotBlank(message = "firstName cannot be blank")
	private String firstName;
	
	@NotBlank(message = "lastName cannot be blank")
	private String lastName;
	
	@NotBlank(message = "EmployeeCode cannot be blank")
	private String empCode;
	
	@NotNull(message = "dob cannot be blank")
	private LocalDate dob;
	
	@NotNull
	private LocalDate doj;
	
	@NotBlank
	@Email
	private String email;
	
	@NotNull
	private String dept;
	
	@NotNull
	private String location;
	
	@NotNull
	private String empStatus;
	
	@NotNull
	private String position;
	
	@NotNull
	private String gender;
	
	public EmployeeDTO() {
	}
	
	public EmployeeDTO(Long id, String firstName, String lastName, String empCode, LocalDate dob, LocalDate doj,
			String email, String dept, String location, String empStatus, String position, String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.empCode = empCode;
		this.dob = dob;
		this.doj = doj;
		this.email = email;
		this.dept = dept;
		this.location = location;
		this.empStatus = empStatus;
		this.position = position;
		this.gender = gender;
	}
	
	public EmployeeDTO( String firstName, String lastName, String empCode, LocalDate dob, LocalDate doj,
			String email, String dept, String location, String empStatus, String position, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.empCode = empCode;
		this.dob = dob;
		this.doj = doj;
		this.email = email;
		this.dept = dept;
		this.location = location;
		this.empStatus = empStatus;
		this.position = position;
		this.gender = gender;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmpCode() {
		return empCode;
	}

	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", empCode=" + empCode
				+ ", dob=" + dob + ", doj=" + doj + ", email=" + email + ", dept=" + dept + ", location=" + location
				+ ", empStatus=" + empStatus + ", position=" + position + ", gender=" + gender + "]";
	}
	
	
	
}
