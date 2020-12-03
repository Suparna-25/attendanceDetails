package com.cg.attendance.exception;

public class EmployeeIdExceptionResponse {

	private Long empId;

	public EmployeeIdExceptionResponse(String message) {
		super();
		
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}


}