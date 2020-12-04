package com.cg.attendance.services;

import org.springframework.stereotype.Service;

import com.cg.attendance.entities.AttendanceDetail;
import com.cg.attendance.exception.AttendanceIDException;
import com.cg.attendance.repositories.AttendanceDetailRepository;

@Service
public class AttendanceDetailService implements IAttendanceDetailService {
	private AttendanceDetailRepository attendanceRepo;

	@Override
	public void addAttendanceDetail(AttendanceDetail attendance) {
		attendanceRepo.save(attendance);

	}

	@Override
	public AttendanceDetail updateAttendanceStatus(Long attendanceId, String status) {
		AttendanceDetail newAttendance= null;
		try {
		    newAttendance = attendanceRepo.findByAttendanceId(attendanceId);
			if(newAttendance.getStatus().equalsIgnoreCase("pending"))
		               newAttendance.setStatus(status);
			if (newAttendance == null) {
				throw new AttendanceIDException("No attendance with attendance id " + attendanceId + " exist");
				}	
		} catch (Exception ex) {
			
			System.out.println(ex);			
		}
		return attendanceRepo.save(newAttendance);
	}

	@Override
	public void setAttendanceType(int choice, AttendanceDetail attendance) {
		switch (choice) {
		case 1:
			attendance.setTypeId("Forgot Card");
			break;
		case 2:
			attendance.setTypeId("Client Location");
			break;
		case 3:
			attendance.setTypeId("Working From Home");
			break;
		case 4:
			attendance.setTypeId("Business Travel");
			break;
		default:
			attendance.setTypeId("Missed Both Swipes");

		}
	}

}