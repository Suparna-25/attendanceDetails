package com.cg.attendance.exception;

public class AttendanceIdExceptionResponse {

	private Integer attendanceId;

	public AttendanceIdExceptionResponse(Integer attendanceId) {
		super();
		this.attendanceId = attendanceId;
	}

	public Integer getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(Integer attendanceId) {
		this.attendanceId = attendanceId;
	}


}