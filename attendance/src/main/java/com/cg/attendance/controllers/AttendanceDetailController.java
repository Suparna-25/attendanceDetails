package com.cg.attendance.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.attendance.entities.AttendanceDetail;
import com.cg.attendance.exception.AttendanceIDException;
import com.cg.attendance.services.AttendanceDetailService;
import com.cg.attendance.services.MapValidationErrorService;


	@RestController
	@RequestMapping("/api/attendanceapplication")
	public class AttendanceDetailController {
		@Autowired
		private AttendanceDetailService attendanceService;
		@Autowired
		private MapValidationErrorService mapValidateErrorService;

		@PostMapping("/add-attendance")
			public ResponseEntity<?> addNewAttendance(@Valid @RequestBody AttendanceDetail attendance, BindingResult result)throws AttendanceIDException {
			ResponseEntity<?> errorMap = mapValidateErrorService.mapValidationError(result);
			if (errorMap != null)
				return errorMap;
			AttendanceDetail newAttendance= attendanceService.addAttendanceDetail(attendance);
			return new ResponseEntity<AttendanceDetail>(newAttendance, HttpStatus.CREATED);
		
		}
		
		@PutMapping("/update-{attendanceId}")
		public ResponseEntity<?> updateAttendanceByStatus(@PathVariable Integer attendanceId,String status)throws AttendanceIDException
		{
			return new ResponseEntity<AttendanceDetail>(attendanceService.updateAttendanceStatus(attendanceId, status),HttpStatus.OK);
		}
		
		@GetMapping("/attendance-{attendanceId}")
		public ResponseEntity<?> viewAttendanceById(@PathVariable Integer attendanceId)throws AttendanceIDException
		{
			return new ResponseEntity<AttendanceDetail>(attendanceService.viewAttendanceByAttendanceId(attendanceId),HttpStatus.OK);
		}
}
