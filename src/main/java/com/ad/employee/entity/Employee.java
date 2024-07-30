package com.ad.employee.entity;


import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.ad.employee.utils.Department;
import com.ad.employee.utils.EmpStatus;
import com.ad.employee.utils.Gender;
import com.ad.employee.utils.Location;
import com.ad.employee.utils.Position;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;

	private String firstName;
	private String lastName;
	private String empCode;
	
	private LocalDate dob;
	private LocalDate doj;
	private String email;
	
	@Enumerated
	private Department dept;
	
	@Enumerated
	private Location location;
	
	@Enumerated
	private EmpStatus empStatus;
	
	@Enumerated
	private Position position;
	
	@Enumerated
	private Gender gender;
	
	
	@UpdateTimestamp
	private LocalDate LastUpdated;
	
	
	@CreationTimestamp
	private LocalDate createdDate;
	
	public Employee() {
		
	}
	


	public Employee(String firstName, String lastName, String empCode, LocalDate dob, LocalDate doj, String email,
			Department dept, Location location, EmpStatus empStatus, Position position, Gender gender,
			LocalDate lastUpdated, LocalDate createdDate) {
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
		LastUpdated = lastUpdated;
		this.createdDate = createdDate;
	}





	public Employee(String firstName, String lastName, String empCode, LocalDate dob, LocalDate doj, String email,
			Department dept, Location location, EmpStatus empStatus, Position position, Gender gender) {
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


	public Department getDept() {
		return dept;
	}


	public void setDept(Department dept) {
		this.dept = dept;
	}


	public Location getLocation() {
		return location;
	}


	public void setLocation(Location location) {
		this.location = location;
	}


	public EmpStatus getEmpStatus() {
		return empStatus;
	}


	public void setEmpStatus(EmpStatus empStatus) {
		this.empStatus = empStatus;
	}


	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}


	public LocalDate getLastUpdated() {
		return LastUpdated;
	}


	public void setLastUpdated(LocalDate lastUpdated) {
		LastUpdated = lastUpdated;
	}


	public LocalDate getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}



	public Gender getGender() {
		return gender;
	}



	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	
	
	
}
