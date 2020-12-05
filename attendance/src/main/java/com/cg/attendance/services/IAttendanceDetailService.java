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
	 * @return 
	 */
	public AttendanceDetail addAttendanceDetail(AttendanceDetail attendance);
    /**
     * This method is used to update AttendanceDetails status from pending to approve/reject using attendance id
     * @param attendance
     * @param status
     * @return 
     */
	public AttendanceDetail updateAttendanceStatus(Integer attendanceId,String status);
	/**
	 * This method will show attendance details for the provided attendanceId
	 * @param attendanceId
	 * @return AttendanceDetail object
	 */
    public AttendanceDetail viewAttendanceByAttendanceId(Integer attendanceId);
}

