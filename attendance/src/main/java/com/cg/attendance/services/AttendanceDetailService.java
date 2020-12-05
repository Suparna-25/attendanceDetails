package com.cg.attendance.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.attendance.entities.AttendanceDetail;
import com.cg.attendance.exception.AttendanceIDException;
import com.cg.attendance.repositories.AttendanceDetailRepository;

@Service
public class AttendanceDetailService implements IAttendanceDetailService {
	@Autowired
	private AttendanceDetailRepository attendanceRepo;

	@Override
	public AttendanceDetail addAttendanceDetail(AttendanceDetail attendance) {
		
		return attendanceRepo.save(attendance);

	}

	@Override
	public AttendanceDetail updateAttendanceStatus(Integer attendanceId, String status) {
				AttendanceDetail  attendance = attendanceRepo.findByAttendanceId(attendanceId);
				AttendanceDetail newAttendance=attendance;
				if(newAttendance==null)
				{
					throw new AttendanceIDException("No attenndance is added for attendance id"+attendanceId);
				}
			    if(newAttendance.getStatus().equalsIgnoreCase("pending"))
		        newAttendance.setStatus(status);
			    BeanUtils.copyProperties(attendance, newAttendance, "attendanceId");		
		return attendanceRepo.save(newAttendance);
	}

	@Override
	public AttendanceDetail viewAttendanceByAttendanceId(Integer attendanceId) {
		AttendanceDetail newAttendance=attendanceRepo.findByAttendanceId(attendanceId);
		if(newAttendance==null)
		{
			throw new AttendanceIDException("No attenndance is added for attendance id"+attendanceId);
		}
		return newAttendance;
	}

}