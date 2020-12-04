package com.cg.attendance.services;

import com.cg.attendance.entities.AttendanceDetail;

/**
 * This Interface holds the structure for AttendanceDetailsService class
 * @author Suparna Arya
 *
 */

public interface IAttendanceDetailService {
	/**
	 * This method is used to add attendance details
	 * @param attendance
	 */
	public void addAttendanceDetail(AttendanceDetail attendance);//{inbuilt repo method}
    /**
     * This method is used to update AttendanceDetails status from pending to approve/reject using attendance id
     * @param attendance
     * @param status
     * @return 
     */
	public AttendanceDetail updateAttendanceStatus(Long attendanceId, String status);//{inbuilt repo method}
	/**
	 * This method is used to set the attendanceType according to the user's choice
	 * @param choice
	 * @param attendance
	 */
	public void setAttendanceType(int choice, AttendanceDetail attendance);

}

