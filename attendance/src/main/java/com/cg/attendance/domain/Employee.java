package com.cg.attendance.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This Bean contains all the details of an employee
 * 
 * @author Suparna Arya & Aswitha
 *
 */
@Entity(name = "employees")
public class Employee {
	// empId is primary key for employees entity
	@Id
    //@NotBlank(message="Employee Id is required")
	//@Column(unique=true,updatable=false)
    //@Size(min=8,max=10,message="Employee Id size must be in between 8 and 10")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long empId;
	@NotNull(message = "Employee Name is required")
	private String empName;
	@NotNull(message = "Phone Number is required")
	private String phoneNumber;
	@NotNull(message = "Mail ID is required")
	private String empEmail;
	@NotNull(message = "Employee Location is required")
	private String empLocation;
	//@NotBlank(message="Supervisior Id is required")
	private long supervisiorId;

	// Employee details has one to many relationship with Attendance Detail entity
	// using empId
	@OneToMany(mappedBy = "employee")
	private List<AttendanceDetail> attendance = new ArrayList<>();

	// Default constructor for employee bean
	public Employee() {
		super();
	}

	// Parameterized constructor for employee bean
	public Employee(long empId, String empName, String phoneNumber, String empEmail, String empLocation,
			long supervisiorId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.phoneNumber = phoneNumber;
		this.empEmail = empEmail;
		this.empLocation = empLocation;
		this.supervisiorId = supervisiorId;

	}

	// setters and getters for Employee to access outside this class
	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String emp_Name) {
		this.empName = emp_Name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpLocation() {
		return empLocation;
	}

	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}

	public List<AttendanceDetail> getAttendance() {
		return attendance;
	}

	public void setAttendance(List<AttendanceDetail> attendance) {
		this.attendance = attendance;
	}

	public long getSupervisiorId() {
		return supervisiorId;
	}

	public void setSupervisiorId(long supervisiorId) {
		this.supervisiorId = supervisiorId;

	}

}