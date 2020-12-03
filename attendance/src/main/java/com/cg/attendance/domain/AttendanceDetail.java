package com.cg.attendance.domain;

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
	private int attendanceId;
	@JsonFormat(pattern = "HH:mm aa")
	private Date inTime;
	@JsonFormat(pattern = "HH:mm aa")
	private Date outTime;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	@NotNull(message = "Reason is required")
	private String reason;
	@NotNull(message = "Type Id is required")
	private String typeId;
	@NotNull(message = "Status: Pending")
	private String status;

	// Attendance details has many to one relationship with Employees entity using
	// empId
	@ManyToOne
	@JoinColumn(name = "empId")
	private Employee employee;

	
	// Default constructor for employee bean
	public AttendanceDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	// Parameterized constructor for employee bean
	public AttendanceDetail(int attendanceId, Date inTime, Date outTime, Date date, String reason, String typeId,
			String status) {
		super();
		this.attendanceId = attendanceId;
		this.inTime = inTime;
		this.outTime = outTime;
		this.date = date;
		this.reason = reason;
		this.typeId = typeId;
		this.status = status;
	}

	// setters and getters for Attendance details to access outside this class
	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
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
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
		return "AttendanceDetails [attendanceId=" + attendanceId + ", inTime=" + inTime + ", outTime=" + outTime
				+ ", date=" + date + ", reason=" + reason + ", typeId=" + typeId + ", status=" + status + ", employee="
				+ employee + "]";
	}
}