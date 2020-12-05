package com.cg.attendance.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * This Java bean contains all the attendance details
 * 
 * @author Suparna Arya & Aswitha
 *
 */
@Entity
public class AttendanceDetail {

	// attendanceId is primary key for attendance detail entity
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // Creates auto generated values for attendanceId
	private Integer attendanceId;
	@JsonFormat(pattern = "HH:mm")
	private Date inTime;
	@JsonFormat(pattern = "HH:mm")
	private Date outTime;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date attendanceDate;
	//@NotNull(message = "Reason is required")
	private String reason;
	//@NotNull(message = "Type Id is required")
	private String typeId;
	//@NotNull(message = "Status: Pending")
	private String status;

	// Attendance details has many to one relationship with Employees entity using
	// empId
	@ManyToOne
	@JoinColumn(name = "id")
	private Employee employee;

	
	// Default constructor for employee bean
	public AttendanceDetail() {
		super();
	}

	
	// Parameterized constructor for employee bean
	public AttendanceDetail(Integer attendanceId, Date inTime, Date outTime, Date attendanceDate, String reason, String typeId,
			String status) {
		super();
		this.attendanceId = attendanceId;
		this.inTime = inTime;
		this.outTime = outTime;
		this.attendanceDate=attendanceDate;
		this.reason = reason;
		this.typeId = typeId;
		this.status = status;
	}

	// setters and getters for Attendance details to access outside this class
	public Integer getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(Integer attendanceId) {
		this.attendanceId = attendanceId;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public Date getDate() {
		return attendanceDate;
	}

	public void setDate(Date attendanceDate) {
		this.attendanceDate=attendanceDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	/**
	 * It returns the desired output for object
	 */
	@Override
	public String toString() {
		return "AttendanceDetail [attendanceId=" + attendanceId + ", inTime=" + inTime + ", outTime=" + outTime
				+ ", date=" + attendanceDate + ", reason=" + reason + ", typeId=" + typeId + ", status=" + status + ", employee="
				+ employee + "]";
	}

	
	
}
