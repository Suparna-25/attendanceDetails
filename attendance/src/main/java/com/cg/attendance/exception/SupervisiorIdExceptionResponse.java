package com.cg.attendance.exception;

public class SupervisiorIdExceptionResponse {

	private Long supervisiorId;

	public SupervisiorIdExceptionResponse(String message) {
		super();
		
	}

	public Long getSupervisiorId() {
		return supervisiorId;
	}

	public void setSupervisiorId(Long supervisiorId) {
		this.supervisiorId = supervisiorId;
	}


}