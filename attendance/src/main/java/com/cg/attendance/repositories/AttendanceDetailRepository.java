package com.cg.attendance.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.attendance.domain.AttendanceDetail;
/**
 * This a Attendance Details repository that performs all the crud operation on employee attendance details
 * @author Suparna Arya & Aswitha 
 *
 */
@Repository
public interface AttendanceDetailRepository extends CrudRepository<AttendanceDetail,Integer>
{
	// TODO ALL THE CRUD OPERATIONS ON ATTENDANCE DETAILS BEAN
		public AttendanceDetail findByAttendanceId(Long attendanceId);
	

}